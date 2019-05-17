package com.piwko.dawid.searchgithubrepos.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.piwko.dawid.searchgithubrepos.model.Repo;


import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class TestScreenNavigator implements ScreenNavigator {
    private MyScreenNavigator myScreenNavigator;
    private Controller controller;

    @Inject
    TestScreenNavigator(MyScreenNavigator myScreenNavigator) {
        this.myScreenNavigator = myScreenNavigator;
    }

    public void initController(Controller initController) {
        this.controller = initController;
    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        Controller launch = controller == null ? rootScreen : controller;
        myScreenNavigator.initWithRouter(router, launch);
    }

    @Override
    public void goToRepoDetails(Repo repo) {

    }

    @Override
    public void goToUserReposList(String username) {
        myScreenNavigator.goToUserReposList(username);
    }

    @Override
    public void goToRepoSearch() {
        myScreenNavigator.goToRepoSearch();
    }

    @Override
    public boolean pop() {
        return myScreenNavigator.pop();
    }

    @Override
    public void clear() {
        myScreenNavigator.clear();
    }
}
