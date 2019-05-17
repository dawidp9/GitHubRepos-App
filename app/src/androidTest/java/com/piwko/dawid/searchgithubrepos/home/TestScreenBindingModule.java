package com.piwko.dawid.searchgithubrepos.home;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.details.RepoDetailsComponent;
import com.piwko.dawid.searchgithubrepos.details.RepoDetailsController;
import com.piwko.dawid.searchgithubrepos.di.ControllerKey;
import com.piwko.dawid.searchgithubrepos.repos.UserReposComponent;
import com.piwko.dawid.searchgithubrepos.repos.UserReposController;
import com.piwko.dawid.searchgithubrepos.search.SearchReposComponent;
import com.piwko.dawid.searchgithubrepos.search.SearchReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        SearchReposComponent.class,
        UserReposComponent.class,
        RepoDetailsComponent.class,
})
public abstract class TestScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(SearchReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindSearchReposInjector(
            SearchReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(UserReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindUserReposInjector(
            UserReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(
            RepoDetailsComponent.Builder builder);


}
