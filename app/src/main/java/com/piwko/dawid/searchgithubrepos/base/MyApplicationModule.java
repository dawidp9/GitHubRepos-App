package com.piwko.dawid.searchgithubrepos.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MyApplicationModule {
    private final Application application;

    protected MyApplicationModule(Application application) {
        this.application = application;

    }

    @Provides
    Context provideAppliactionContext() {
        return application;
    }
}
