package com.example.sage.view.subjectsMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sage.R;
import com.example.sage.model.CapeSubject;
import com.example.sage.model.CsecSubject;
import com.example.sage.model.Subject;
import com.example.sage.model.SubjectCatalogue;

import java.util.ArrayList;
import java.util.List;

public class SubjectsMenu extends AppCompatActivity {

    public static List<Subject> subjects;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sage.R.layout.activity_subjects_menu);

        String choice = getIntent().getStringExtra("choice");

        Toolbar toolbar = findViewById(R.id.subjectsMenuToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(choice+" Subjects");


        subjects = SubjectCatalogue.getSubjects();

        List<Subject> chosenSubjects = getChosenSubjects(subjects,choice);

        recyclerView=(RecyclerView) findViewById(R.id.subjectsRecyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,chosenSubjects);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<Subject> getChosenSubjects(List<Subject> subjects, String choice) {
        List<Subject> chosenSubjects = new ArrayList<>();


        if(subjects!=null) {
            if (choice.equals("CAPE")) {
                for (Subject subject : subjects) {
                    if (subject instanceof CapeSubject) {
                        if(((CapeSubject)subject).getUnitNumber()==1){   //only show image once, representing for both units
                            chosenSubjects.add(subject);
                        }

                    }
                }
            } else if (choice.equals("CSEC")) {
                for (Subject subject : subjects) {
                    if (subject instanceof CsecSubject) {
                        chosenSubjects.add(subject);
                    }
                }

            }
        }

        return chosenSubjects;
    }

}