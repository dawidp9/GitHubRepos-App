package com.piwko.dawid.searchgithubrepos.home;


import com.piwko.dawid.searchgithubrepos.di.ActivityScope;
import com.piwko.dawid.searchgithubrepos.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {



    }
}
