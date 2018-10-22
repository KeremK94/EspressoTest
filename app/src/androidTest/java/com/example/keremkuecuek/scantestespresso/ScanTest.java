package com.example.keremkuecuek.scantestespresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;



import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScanTest {


    @Rule

    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before

    public void setUp() throws Exception {
        //Before Test case execution

    }

    @Test

    public void Scan() throws InterruptedException {
        onView(withId(R.id.btnScan)).perform(click());

        Thread.sleep(13000);

        onView(withId(R.id.txtInfo)).check(matches(withText("Virus found")));

    }

    @After

    public void tearDown() throws Exception {
        //After Test case Execution
    }
}


