package com.piwko.dawid.searchgithubrepos.ui;

import com.piwko.dawid.searchgithubrepos.di.ActivityScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

    @Binds
    @ActivityScope
    abstract ScreenNavigator provideScreenNavigator(MyScreenNavigator screenNavigator);
}
