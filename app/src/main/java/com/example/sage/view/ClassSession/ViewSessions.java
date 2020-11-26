package com.example.sage.view.ClassSession;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sage.R;
import com.example.sage.model.ClassSession;
import com.example.sage.model.Session;
import com.example.sage.view.Class.CreateClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewSessions extends AppCompatActivity {
    private List<Session> sessionsList;
    private RecyclerView sessionsRecyclerView;
    private ViewSessionsRecyclerViewAdapter sessionRecyclerViewAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(com.example.sage.R.layout.activity_view_sessions);

        Toolbar toolbar = findViewById(R.id.viewSessionsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tutor's Sessions");

        LocalDateTime d1 = LocalDateTime.of(2020, Month.APRIL, 20, 06, 30 );
        LocalDateTime d2 = LocalDateTime.of(2021, Month.FEBRUARY, 20, 2, 30 );
        LocalDateTime d3 = LocalDateTime.of(2019, Month.JUNE, 4, 8, 13 );

        sessionsList = new ArrayList<>();
        sessionsList.add(new ClassSession(d3, d1, "https://zoom.us/join"));
        sessionsList.add(new ClassSession(d3, d2,"https://zoom.us/join"));
        sessionsList.add(new ClassSession(d1, d2, "https://zoom.us/join"));

        sessionsRecyclerView = (RecyclerView) findViewById(R.id.sessionsRecyclerView);
        sessionRecyclerViewAdapter = new ViewSessionsRecyclerViewAdapter(this, sessionsList);
        sessionsRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        sessionsRecyclerView.setAdapter(sessionRecyclerViewAdapter);


        FloatingActionButton fab = findViewById(R.id.sessionFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
