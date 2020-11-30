package com.example.sage.view.Login;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sage.R;
import com.example.sage.model.StudentAccount;
import com.example.sage.model.TutorAccount;
import com.example.sage.model.UserAccount;
import com.example.sage.view.MainActivity;
import com.example.sage.view.Register.Register;
import com.example.sage.view.subjectsTypeMenu.SubjectsTypeMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class Login extends AppCompatActivity {

    private Button loginButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView createAccountTextView;

    private PasswordMgr passwordMgr;

    private DatabaseReference ref;
    private java.util.List<UserAccount> userAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ref= FirebaseDatabase.getInstance().getReference();
        userAccounts = new ArrayList<>();
        loadUserData();

        loginButton = (Button) findViewById(R.id.loginButton);
        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.password);

        createAccountTextView = (TextView) findViewById(R.id.createAccountTextView);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_email, p_word;

                u_email = emailEditText.getText().toString();
                p_word = passwordEditText.getText().toString();

                MainActivity.myUser = null;
                Iterator iter = userAccounts.iterator();
                while(iter.hasNext()){
                    UserAccount u_account = (UserAccount)iter.next();
                    System.out.println("1 "+u_account.getEmail().toLowerCase());
                    if(u_account.getEmail().toLowerCase().equals(u_email.toLowerCase())){
                        System.out.println("2: "+u_account.getEmail().toLowerCase());
                        //passwordMgr.isExpectedPassword(p_word);  to be implemented
                        if(u_account.getPassword().equals(p_word)){
                            MainActivity.myUser=u_account;
                        }

                    }
                }

                if(MainActivity.myUser != null){
                    Intent intent = new Intent(Login.this, SubjectsTypeMenu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this,"Please enter a valid email and password",Toast.LENGTH_SHORT).show();
                }




            }
        });

        createAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivityForResult(intent, 1);
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(Login.this, name +
                        ", your account has been Successfully created.", Toast.LENGTH_LONG).show();
                recreate();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    public void loadUserData(){

        ValueEventListener usersListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                UserAccount userAccount=null;

                for(DataSnapshot snapshot: dataSnapshot.getChildren()){


                    for(DataSnapshot s: snapshot.getChildren()){


                        if(snapshot.getKey().equals("Tutors")){
                            userAccount= s.getValue(TutorAccount.class);
                        } else if(snapshot.getKey().equals("Students")) {
                            userAccount = s.getValue(StudentAccount.class);
                        }

                        userAccounts.add(userAccount);

                    }

                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        ref.child("Users").addListenerForSingleValueEvent(usersListener);
    }



}