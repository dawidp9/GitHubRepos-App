package com.piwko.dawid.searchgithubrepos.base;

import android.support.test.InstrumentationRegistry;

public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent init() {
        return DaggerTestApplicationComponent.builder()
                .myApplicationModule(new MyApplicationModule(this))
                .build();
    }

    public static TestApplicationComponent getComponent() {
       return  (TestApplicationComponent) ((TestApplication)
               InstrumentationRegistry
                       .getTargetContext()
                       .getApplicationContext())
               .component;
    }
}
