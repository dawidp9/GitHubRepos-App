package com.piwko.dawid.searchgithubrepos.details;


import com.piwko.dawid.searchgithubrepos.di.ScreenScope;
import com.piwko.dawid.searchgithubrepos.ui.ScreenNavigator;

import javax.inject.Inject;

@ScreenScope
public class RepoDetailsPresenter  {

    private final ScreenNavigator screenNavigator;

    @Inject
    public RepoDetailsPresenter(ScreenNavigator screenNavigator) {
        this.screenNavigator = screenNavigator;
    }
}
