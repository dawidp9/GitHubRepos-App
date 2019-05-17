package com.piwko.dawid.searchgithubrepos.test;

import android.content.Intent;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.data.TestRepoService;
import com.piwko.dawid.searchgithubrepos.home.MainActivity;
import com.piwko.dawid.searchgithubrepos.ui.TestScreenNavigator;


import org.junit.Rule;

public abstract class TestController {

    @Rule
    public TestControllerRule<MainActivity> testControllerRule =
            new TestControllerRule<>(MainActivity.class);

    protected TestScreenNavigator testScreenNavigator = testControllerRule.testScreenNavigator;
    protected TestRepoService testRepoService = testControllerRule.testRepoService;

    public TestController() {
        testScreenNavigator.initController(setUpController());
    }

    protected abstract Controller setUpController();

    protected void launchActivity() {
        launchActivity(null);
    }
    protected void launchActivity(Intent intent) {
        testControllerRule.launchActivity(intent);
    }



}
