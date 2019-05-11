package com.piwko.dawid.searchgithubrepos.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.piwko.dawid.searchgithubrepos.search.SearchReposController;

import javax.inject.Inject;

public class MyScreenNavigator implements ScreenNavigator {

    private Router router;

    @Inject
    MyScreenNavigator() {

    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        this.router = router;
        if(!router.hasRootController()){
            router.setRoot(RouterTransaction.with(rootScreen));
        }
    }

    @Override
    public void goToRepoSearch() {
        if(router != null) {
            router.pushController(RouterTransaction.with(SearchReposController.newInstance()));
        }
    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
