package com.example.sage.view.subjectsTypeMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sage.R;
import com.example.sage.model.Subject;
import com.example.sage.view.subjectsMenu.SubjectsMenu;

public class SubjectsTypeMenu extends AppCompatActivity {

    CardView capeCardView;
    CardView csecCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_type_menu);

        Toolbar toolbar = findViewById(R.id.subjectsLevelMenuToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CXC Level");


        capeCardView = (CardView) findViewById(R.id.capeCardView);
        csecCardView = (CardView) findViewById(R.id.csecCardView);

        capeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextScreen(v);
            }
        });

        csecCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextScreen(v);
            }
        });

    }

    private void goToNextScreen(View v){
        String choice="";
        if(v==capeCardView) {
            choice="CAPE";
        } else {
            choice="CSEC";
        }
        Intent intent = new Intent(SubjectsTypeMenu.this, SubjectsMenu.class);
        intent.putExtra("choice",choice);
        startActivity(intent);

    }
}