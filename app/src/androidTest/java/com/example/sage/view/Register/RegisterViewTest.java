package com.example.sage.view.Register;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.sage.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RegisterViewTest {


    @Rule
    public ActivityScenarioRule<Register> registerRule = new ActivityScenarioRule<>(Register.class);

    @Test
    public void viewClassesViewsPresent(){
        onView(withId(R.id.registerToolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.billingCountrySpinner)).check(matches(isDisplayed()));
        onView(withId(R.id.creditCardEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.emailEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.textView4)).check(matches(isDisplayed()));
        onView(withId(R.id.textView5)).check(matches(isDisplayed()));
        onView(withId(R.id.textView6)).check(matches(isDisplayed()));
        onView(withId(R.id.textView8)).check(matches(isDisplayed()));
        onView(withId(R.id.nameEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.accountTypeSpinner)).check(matches(isDisplayed()));
        onView(withId(R.id.billingAddressTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.creditCardTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.creditCardEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.registerButton)).check(matches(isDisplayed()));

    }

    @Test
    public void textMatches(){
        onView(withId(R.id.textView4)).check(matches(withText(containsString("Name"))));
        onView(withId(R.id.textView5)).check(matches(withText(containsString("Email"))));
        onView(withId(R.id.textView6)).check(matches(withText(containsString("Password"))));
        onView(withId(R.id.textView8)).check(matches(withText(containsString("Account Type"))));
        onView(withId(R.id.billingAddressTextView)).check(matches(withText(containsString("Billing Country"))));
        onView(withId(R.id.creditCardTextView)).check(matches(withText(containsString("Credit Card No."))));
        onView(withId(R.id.registerButton)).check(matches(withText(containsString("Register"))));

    }




}




