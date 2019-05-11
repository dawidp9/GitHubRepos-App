package com.piwko.dawid.searchgithubrepos.home;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.di.ControllerKey;
import com.piwko.dawid.searchgithubrepos.search.SearchReposComponent;
import com.piwko.dawid.searchgithubrepos.search.SearchReposController;


import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        SearchReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(SearchReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindSearchReposInjector(
            SearchReposComponent.Builder builder);

}
