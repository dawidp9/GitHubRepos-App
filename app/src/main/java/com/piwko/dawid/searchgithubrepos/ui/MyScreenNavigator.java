package com.piwko.dawid.searchgithubrepos.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.piwko.dawid.searchgithubrepos.details.RepoDetailsController;
import com.piwko.dawid.searchgithubrepos.model.Repo;
import com.piwko.dawid.searchgithubrepos.repos.UserReposController;
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
    public void goToRepoDetails(Repo repo) {
        if(router != null) {
            router.pushController(RouterTransaction.with(RepoDetailsController.newInstance(repo)));
        }
    }

    @Override
    public void goToUserReposList(String username) {
        if(router != null) {
            router.pushController(RouterTransaction.with(UserReposController.newInstance(username)));
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
