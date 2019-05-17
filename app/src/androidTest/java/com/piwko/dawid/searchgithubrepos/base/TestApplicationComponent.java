package com.piwko.dawid.searchgithubrepos.base;

import com.piwko.dawid.searchgithubrepos.data.TestRepoService;
import com.piwko.dawid.searchgithubrepos.data.TestRepoServiceModule;
import com.piwko.dawid.searchgithubrepos.networking.ServiceModule;
import com.piwko.dawid.searchgithubrepos.ui.TestNavigationModule;
import com.piwko.dawid.searchgithubrepos.ui.TestScreenNavigator;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        MyApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        TestNavigationModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent {
    TestScreenNavigator testScreenNavigator();
    TestRepoService testRepoService();

}
