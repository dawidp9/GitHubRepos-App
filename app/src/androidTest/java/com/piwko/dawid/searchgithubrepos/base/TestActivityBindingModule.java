package com.piwko.dawid.searchgithubrepos.base;

import android.app.Activity;

import com.piwko.dawid.searchgithubrepos.home.MainActivity;
import com.piwko.dawid.searchgithubrepos.home.TestActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = TestActivityComponent.class)
public abstract class TestActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestActivityComponent.Builder builder);
}
