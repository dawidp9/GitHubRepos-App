package com.piwko.dawid.searchgithubrepos.search;

import android.support.test.runner.AndroidJUnit4;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.test.TestController;


import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SearchReposControllerTest extends TestController {

    @Override
    protected Controller setUpController() {
        return new SearchReposController();
    }

    @Test
    public void checkEmptyUsername(){
        launchActivity();
        // when
        // empty username
        onView(withId(R.id.editTextUsername))
                .perform(clearText());

        // click search
        onView(withId(R.id.buttonSearch))
                .perform(click());

        // then
        // check dialog
        onView(withText(R.string.alert_dialog_empty_username_title))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
    }

}
