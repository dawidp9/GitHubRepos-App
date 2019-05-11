package com.piwko.dawid.searchgithubrepos.base;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        MyApplicationModule.class,
        ActivityBindingModule.class,
})
public interface ApplicationComponent {


    void inject(MyApplication myApplication);
}
