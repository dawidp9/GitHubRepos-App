package com.piwko.dawid.searchgithubrepos.home;

import com.piwko.dawid.searchgithubrepos.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules =  {
        TestScreenBindingModule.class,
})
public interface TestActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
