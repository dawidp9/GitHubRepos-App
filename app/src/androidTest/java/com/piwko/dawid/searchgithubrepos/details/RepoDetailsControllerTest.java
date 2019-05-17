package com.piwko.dawid.searchgithubrepos.details;

import android.support.test.runner.AndroidJUnit4;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.test.TestController;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class RepoDetailsControllerTest extends TestController {

    @Override
    protected Controller setUpController() {
        // load details screen witch first repo from mock json response
        return RepoDetailsController.newInstance(testRepoService.getUserReposList().get(0));
    }

    @Before
    public void setUp() {

    }

    @Test
    public void checkLoadedData() {
        launchActivity();
        // when
        // first repo from the list is clicked

        // then
        // check details screen data
        onView(withId(R.id.text_view_repo_details_name))
                .check(matches(withText("CodingKnowledgeTest-App")));
        onView(withId(R.id.text_view_repo_details_desc))
                .check(matches(withText("Android App based on Firebase")));
        onView(withId(R.id.text_view_id))
                .check(matches(withText("121981919")));
        onView(withId(R.id.text_view_node_id))
                .check(matches(withText("MDEwOlJlcG9zaXRvcnkxMjE5ODE5MTk=")));
        onView(withId(R.id.text_view_language))
                .check(matches(withText("Java")));
        onView(withId(R.id.text_view_stargazers_count))
                .check(matches(withText("0")));
        onView(withId(R.id.text_view_watchers_count))
                .check(matches(withText("0")));
        onView(withId(R.id.text_view_forks_count))
                .check(matches(withText("0")));
        onView(withId(R.id.text_view_created_date))
                .check(matches(withText("18.02.2018 19:13:16")));
        onView(withId(R.id.text_view_update_date))
                .check(matches(withText("18.02.2018 19:23:07")));
        onView(withId(R.id.text_view_default_branch))
                .check(matches(withText("master")));
        onView(withId(R.id.text_view_html_url))
                .check(matches(withText("https://github.com/dawidp9/CodingKnowledgeTest-App")));
        onView(withId(R.id.text_view_ssh_url))
                .check(matches(withText("git@github.com:dawidp9/CodingKnowledgeTest-App.git")));
        onView(withId(R.id.text_view_size))
                .check(matches(withText("14179")));

    }

}
