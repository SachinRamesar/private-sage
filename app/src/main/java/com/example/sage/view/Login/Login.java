package com.example.sage.view.Login;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sage.R;
import com.example.sage.model.TutorAccount;
import com.example.sage.model.UserAccount;
import com.example.sage.view.MainActivity;
import com.example.sage.view.Register.Register;
import com.example.sage.view.subjectsTypeMenu.SubjectsTypeMenu;

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

    Button loginButton;
    EditText usernameEditText;
    EditText passwordEditText;
    TextView createAccountTextView;
    PasswordMgr passwordMgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.loginButton);
        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        createAccountTextView = (TextView) findViewById(R.id.createAccountTextView);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_name, p_word;

                u_name = usernameEditText.getText().toString();
                p_word = passwordEditText.getText().toString();
                /*
                ArrayList<UserAccount> userAccounts = getUserAccounts();
                Iterator iter = userAccounts.iterator();
                while(iter.hasNext()){
                    UserAccount u_account = (UserAccount)iter.next();
                    if(u_account.getUserName().equals(u_name)){
                        passwordMgr.isExpectedPassword(p_word);
                    }
                }
                */
                Intent intent = new Intent(Login.this, SubjectsTypeMenu.class);
                startActivity(intent);


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

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    private ArrayList<UserAccount> getUserAccounts(){

        return null;
    }


}