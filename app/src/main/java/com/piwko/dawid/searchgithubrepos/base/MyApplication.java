package com.piwko.dawid.searchgithubrepos.base;

import android.app.Application;


import com.piwko.dawid.searchgithubrepos.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.BuildConfig;
import timber.log.Timber;

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;
    protected ApplicationComponent component;

    protected ApplicationComponent init() {
        return DaggerApplicationComponent.builder()
                .myApplicationModule(new MyApplicationModule(this))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = init();
        component.inject(this);

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
