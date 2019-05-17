package com.piwko.dawid.searchgithubrepos.test;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.piwko.dawid.searchgithubrepos.base.TestApplication;
import com.piwko.dawid.searchgithubrepos.data.TestRepoService;
import com.piwko.dawid.searchgithubrepos.ui.TestScreenNavigator;


public class TestControllerRule<T extends Activity> extends ActivityTestRule<T> {
    public TestScreenNavigator testScreenNavigator;
    public TestRepoService testRepoService;

    public TestControllerRule(Class<T> activityClass) {
        super(activityClass, true, false);
        testScreenNavigator = TestApplication.getComponent().testScreenNavigator();
        testRepoService = TestApplication.getComponent().testRepoService();

    }
}
