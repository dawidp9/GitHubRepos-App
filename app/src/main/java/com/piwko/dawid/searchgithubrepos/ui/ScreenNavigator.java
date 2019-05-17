package com.piwko.dawid.searchgithubrepos.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.piwko.dawid.searchgithubrepos.model.Repo;

public interface ScreenNavigator {

    void initWithRouter(Router router, Controller rootScreen);
    void goToRepoDetails(Repo repo);
    void goToUserReposList(String username);
    void goToRepoSearch();
    boolean pop();
    void clear();

}
