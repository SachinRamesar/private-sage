package com.example.sage.view.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sage.R;
import com.example.sage.model.StudentAccount;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Register extends AppCompatActivity {

    Spinner accountType, billingCountrySpinner;
    Button registerButton;
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        accountType = (Spinner) findViewById(R.id.accountTypeSpinner);
        registerButton = (Button) findViewById(R.id.registerButton);
        billingCountrySpinner = (Spinner) findViewById(R.id.billingCountrySpinner);
        nameEditText = (EditText) findViewById(R.id.nameEditText);


        populateSpinnerWithCountries();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                //if check for all fields

                /*Code to save to database*/




                /*end*/




                Intent returnIntent = new Intent();
                returnIntent.putExtra(name,name);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });







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

        Collections.sort(countries);
        for (String country : countries) {
            System.out.println(country);
        }

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(Register.this,
                android.R.layout.simple_spinner_item, countries);

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        billingCountrySpinner.setAdapter(countryAdapter);

    }
}