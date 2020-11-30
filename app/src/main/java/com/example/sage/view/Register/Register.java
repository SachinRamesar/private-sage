package com.example.sage.view.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sage.R;
import com.example.sage.model.StudentAccount;
import com.example.sage.model.TutorAccount;
import com.example.sage.model.UserAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Register extends AppCompatActivity {

    private Spinner accountTypeSpinner, billingCountrySpinner;
    private Button registerButton;
    private EditText nameEditText, emailEditText, passwordEditText, creditCardEditText;
    private TextView test;

    private DatabaseReference ref;
    private java.util.List<UserAccount> userAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = findViewById(R.id.registerToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New User");

        //load data
        ref= FirebaseDatabase.getInstance().getReference();
        userAccounts = new ArrayList<>();
        loadUserData();
        //end load data


        test= (TextView) findViewById(R.id.test);



        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        accountTypeSpinner = (Spinner) findViewById(R.id.accountTypeSpinner);
        billingCountrySpinner = (Spinner) findViewById(R.id.billingCountrySpinner);
        creditCardEditText = (EditText) findViewById(R.id.creditCardEditText);
        registerButton = (Button) findViewById(R.id.registerButton);


        populateSpinnerWithCountries();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(isValidate()){
                    String name, fname, lname, email, password, accountType;

                    String[] split;

                    name = nameEditText.getText().toString();

                    split = name.split(" ",2);
                    if(split.length!=2){
                        Toast.makeText(Register.this,"Please enter First name and Last name.",Toast.LENGTH_LONG).show();
                        return; //error case
                    }

                    fname=split[0];
                    lname=split[1];


                    email = emailEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                    accountType = accountTypeSpinner.getSelectedItem().toString();


                    if (!isDuplicateAcc(email)) {

                        UserAccount newUserAccount=null;
                        if (accountType.equals("Tutor")) {
                            newUserAccount = new TutorAccount(fname, lname, email, password); // still to implement Credit Card Class
                            ref.child("Users").child("Tutors").push().setValue(newUserAccount);
                        } else if (accountType.equals("Student")) {
                            newUserAccount = new StudentAccount(fname, lname, email, password );
                            ref.child("Users").child("Students").push().setValue(newUserAccount);
                        }

                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("name",name);
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();

                    } else{
                        Toast.makeText(Register.this,"Account already exists. Please use another email.",Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Register.this,"All fields are mandatory. Please fill out all fields.",Toast.LENGTH_LONG).show();
                }
            }

        });


    }

    public boolean isValidate(){
        String name, email, password, accountType;

        name = nameEditText.getText().toString();
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        accountType = accountTypeSpinner.getSelectedItem().toString();

        if(!(name.trim().equals("")||email.trim().equals("")||password.trim().equals("")||accountType.trim().equals(""))){
            return true;
        }
        return false;
    }

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

    public boolean isDuplicateAcc(String email){

        for(UserAccount userAccount: userAccounts){
            if(userAccount.getEmail().toLowerCase().equals(email.toLowerCase())){
                return true;
            }
        }
        return false;

    }

    public void populateSpinnerWithCountries(){
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(Register.this,
                android.R.layout.simple_spinner_item, countries);

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        billingCountrySpinner.setAdapter(countryAdapter);

    }
}