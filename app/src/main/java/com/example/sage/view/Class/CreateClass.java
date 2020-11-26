package com.example.sage.view.Class;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.sage.R;
import com.example.sage.model.CapeSubject;
import com.example.sage.model.Class;
import com.example.sage.model.ClassSession;
import com.example.sage.model.CsecSubject;
import com.example.sage.model.Subject;
import com.example.sage.model.SubjectCatalogue;
import com.example.sage.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateClass extends AppCompatActivity {

    private RadioGroup subjectsRadioGroup;
    private RadioButton csecButton, capeButton;
    private LinearLayout unitLinearLayout;
    private Spinner subjectSpinner, unitSpinner;
    private EditText classDescription;
    private NumberPicker classCapacity;
    private EditText classPrice;
    private Button createClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        Toolbar toolbar = findViewById(R.id.createClassToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Class");

        subjectsRadioGroup = (RadioGroup) findViewById(R.id.subjectsRadioGroup);
        csecButton = (RadioButton) findViewById(R.id.csecButton);
        capeButton = (RadioButton) findViewById(R.id.capeButton);
        subjectSpinner = (Spinner) findViewById(R.id.csecSubjectsSpinner);
        classDescription = (EditText) findViewById(R.id.classDescription);
        classCapacity = (NumberPicker) findViewById(R.id.classCapacity);
        classPrice = (EditText) findViewById(R.id.classPrice);
        createClass = (Button) findViewById(R.id.createClassButton);
        unitLinearLayout = (LinearLayout) findViewById(R.id.unitLinearLayout);
        unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
        classCapacity.setMinValue(1);
        classCapacity.setMaxValue(100);


        subjectsRadioGroup.check(R.id.csecButton);

        populateSpinner();
        subjectsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                populateSpinner();
                toggleUnitLayout();

            }
        });


        createClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Subject subject, int capacity, String classDescription, ArrayList<ClassSession> classSessions,double price

                if(classPrice.getText().toString().trim().equals("")){
                    Toast.makeText(CreateClass.this,"Please fill out the price field.",Toast.LENGTH_SHORT).show();

                } else {

                    String description, subjectName;
                    int capacity;
                    double price;


                    description = classDescription.getText().toString();
                    subjectName = subjectSpinner.getSelectedItem().toString();
                    capacity = classCapacity.getValue();
                    price = Double.parseDouble(classPrice.getText().toString());
                    ArrayList<ClassSession> sessions = new ArrayList<>();

                    Subject subject;
                    subject = getSubject(subjectName);

                    Class newClass;
                    newClass = new Class(subject, capacity, description, sessions,price); //then store in database

                    //temporary add to global class
                    MainActivity.addToClass(newClass);

                    Intent returnIntent = new Intent();
                    String result = "New Class created";
                    returnIntent.putExtra("result",result);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }

            }
        });


    }

    private void toggleUnitLayout(){
        if(csecButton.isChecked()){
            unitLinearLayout.setVisibility(View.GONE);
        } else if(capeButton.isChecked()){
            unitLinearLayout.setVisibility(View.VISIBLE);
        }
    }

    private void populateSpinner() {
        List<String> subjectNames = new ArrayList<>();
        subjectNames = getSubjectSpinnerList(SubjectCatalogue.getSubjects());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,subjectNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(arrayAdapter);
    }

    private List<String> getSubjectSpinnerList(List<Subject> subjects){
        List<String> subjectNames = new ArrayList<>();

        if(csecButton.isChecked()){
            for(Subject subject: subjects){
                if(subject instanceof CsecSubject){
                    subjectNames.add(subject.getName());
                }
            }
        }
        else if(capeButton.isChecked()){
            for(Subject subject: subjects){
                if(subject instanceof CapeSubject){
                    if(((CapeSubject)subject).getUnitNumber()==1){   //only show subject once, representing for both units
                        subjectNames.add(subject.getName());
                    }

                }
            }
        }

        return subjectNames;
    }



    private Subject getSubject(String subjectName) {
        Subject subject = null;

        if(capeButton.isChecked()){
            int unit;
            unit = Integer.parseInt(unitSpinner.getSelectedItem().toString());
            for (Subject sub : SubjectCatalogue.getSubjects()) {
                if(sub instanceof CapeSubject){
                    if (sub.getName().equals(subjectName) && ((CapeSubject) sub).getUnitNumber()==unit){
                        subject = sub;
                    }
                }
            }
        }
        else if(csecButton.isChecked()){
            for (Subject sub : SubjectCatalogue.getSubjects()) {
                if (sub instanceof CsecSubject) {
                    if (sub.getName().equals(subjectName)) {
                        subject = sub;
                    }
                }
            }

        }

        return subject;

    }


}
