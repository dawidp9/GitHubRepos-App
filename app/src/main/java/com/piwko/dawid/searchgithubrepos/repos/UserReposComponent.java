package com.piwko.dawid.searchgithubrepos.repos;

import com.piwko.dawid.searchgithubrepos.di.ScreenScope;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface UserReposComponent extends AndroidInjector<UserReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserReposController> {

        @BindsInstance
        public abstract void bindReposUsename(@Named("repo_username") String repoUsername);

        @Override
        public void seedInstance(UserReposController instance) {
            bindReposUsename(instance.getArgs().getString(UserReposController.REPOS_USERNAME_KEY));
        }
    }
}
