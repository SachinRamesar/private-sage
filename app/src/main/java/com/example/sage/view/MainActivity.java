package com.example.sage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sage.R;
import com.example.sage.model.Class;
import com.example.sage.model.SubjectCatalogue;
import com.example.sage.model.TutorAccount;
import com.example.sage.view.Class.CreateClass;
import com.example.sage.view.Login.Login;
import com.example.sage.view.subjectsMenu.SubjectsMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button nextScreen;
    private Button nextScreen2;
    private static List<Class> classes = new ArrayList<>();
    public static void addToClass(Class c){
        classes.add(c);
    }


    /* test code for database*/
    private Button buttonUpdate;
    private EditText updateEditText;
    private TextView printTextView;
    public DatabaseReference ref;
    /*end*/


    public static List<Class> getClasses(){
        return classes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SubjectCatalogue.loadSubjects();   //temporary -- use database

        nextScreen = (Button) findViewById(R.id.nextScreen);
        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubjectsMenu.class);
                startActivity(intent);
            }
        });

        nextScreen2 = (Button) findViewById(R.id.nextScreen2);
        nextScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });







        /*test code for database*/

        printTextView = findViewById(R.id.printTextView);
        updateEditText = findViewById(R.id.updateEditText);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        ref = FirebaseDatabase.getInstance().getReference();

        /*write code*/

        TutorAccount t = new TutorAccount("fname","lname","email@email.com","password","1213123");
        TutorAccount t2 = new TutorAccount("Phil","Roberts","phil@email.com","pw","123123");



        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = updateEditText.getText().toString();
                ref.child("Tutor").child("1").child("email").setValue(s);

                //you may use getKey() method to get the id of node that changed in the database
            }
        });

        /*end write*/


        /*read code*/

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                TutorAccount updatedTutor = dataSnapshot.getValue(TutorAccount.class);
                printTextView.setText(updatedTutor.getEmail());
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        ref.child("Tutor").child("1").addValueEventListener(postListener);

        /*end read*/





        /*end*/







    }


}