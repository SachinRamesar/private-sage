package com.example.sage.view.Class;

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
public class CreateClassViewsTest {

    @Rule
    public ActivityScenarioRule<CreateClass>  createClassRule = new ActivityScenarioRule<>(CreateClass.class);

    @Test
    public void createClassViewsPresent(){
        onView(withId(R.id.createClassToolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.classDescription)).check(matches(isDisplayed()));
        onView(withId(R.id.classCapacity)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.csecSubjectsSpinner)).check(matches(isDisplayed()));
        onView(withId(R.id.csecButton)).check(matches(isDisplayed()));
        onView(withId(R.id.capeButton)).check(matches(isDisplayed()));
        onView(withId(R.id.createClassButton)).check(matches(isDisplayed()));
        onView(withId(R.id.textView13)).check(matches(isDisplayed()));
        onView(withId(R.id.textView10)).check(matches(isDisplayed()));
        onView(withId(R.id.textView11)).check(matches(isDisplayed()));
        onView(withId(R.id.classPrice)).check(matches(isDisplayed()));

    }


    @Test
    public void textViewTextMatches(){
        onView(withId(R.id.textView)).check(matches(withText(containsString("Subject:"))));
        onView(withId(R.id.textView10)).check(matches(withText(containsString("Price ($)"))));
        onView(withId(R.id.textView11)).check(matches(withText(containsString("CXC Level:"))));
        onView(withId(R.id.textView13)).check(matches(withText(containsString("Capacity:"))));
    }

}
