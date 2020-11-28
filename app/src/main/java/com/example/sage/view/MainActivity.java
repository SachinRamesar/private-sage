package com.example.sage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sage.R;
import com.example.sage.model.Class;
import com.example.sage.model.SubjectCatalogue;
import com.example.sage.view.Class.CreateClass;
import com.example.sage.view.Login.Login;
import com.example.sage.view.subjectsMenu.SubjectsMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button nextScreen;
    private Button nextScreen2;
    private static List<Class> classes = new ArrayList<>();
    public static void addToClass(Class c){
        classes.add(c);
    }

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







    }


}