package com.example.sage.view.Class;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.Toast;

import com.example.sage.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewClasses extends AppCompatActivity {

    private UnitsAdapter unitsAdapter;
    private ViewPager2 viewPager;
    protected String subjectName;
    protected String subjectType; //temp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_classes);
        subjectName = getIntent().getStringExtra("subject");
        subjectType = getIntent().getStringExtra("subjectType");
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(subjectType+" "+subjectName);


        unitsAdapter = new UnitsAdapter(this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(unitsAdapter);


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        if(subjectType.equals("CAPE")) { // create fragment to deal with two units
            tabLayout.setVisibility(View.VISIBLE);
            new TabLayoutMediator(tabLayout, viewPager,
                    (tab, position) -> tab.setText("Unit " + (position + 1))
            ).attach();
        } else {
            tabLayout.setVisibility(View.GONE);
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateClass.class);
                startActivityForResult(intent, 1);
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                 */
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
                recreate();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }


}
/*
public class ViewClasses extends AppCompatActivity  {


        private static int sessionsAmt;
        private List<Class> classes;
        private RecyclerView classesRecyclerView;
        private ViewClassesRecyclerViewAdapter viewClassesRecyclerViewAdapter;
        private Button addSession, deleteClass;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_classes);

            addSession = (Button) findViewById(R.id.addSession);
            deleteClass = (Button) findViewById(R.id.deleteClass);
            //addSession.setOnClickListener(new Button_Clicker());
            //deleteClass.setOnClickListener(new Button_Clicker());

            classes = new ArrayList<>();

        }

        public class Button_Clicker implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                if(v == addSession){
                    // intent to fill out session form


                }
                else if (v == deleteClass){
                    // remove from list of classes
                }


            }
        }


}
 */