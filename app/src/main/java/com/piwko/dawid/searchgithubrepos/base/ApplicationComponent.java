package com.piwko.dawid.searchgithubrepos.base;

import com.piwko.dawid.searchgithubrepos.data.RepoServiceModule;
import com.piwko.dawid.searchgithubrepos.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        MyApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})
public interface ApplicationComponent {


    void inject(MyApplication myApplication);
}
