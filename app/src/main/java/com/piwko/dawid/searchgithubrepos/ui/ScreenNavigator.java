package com.piwko.dawid.searchgithubrepos.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

public interface ScreenNavigator {

    void initWithRouter(Router router, Controller rootScreen);
    void goToRepoSearch();
    boolean pop();
    void clear();

}
