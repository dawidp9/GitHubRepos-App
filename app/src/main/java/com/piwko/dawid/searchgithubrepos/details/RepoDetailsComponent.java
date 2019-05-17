package com.piwko.dawid.searchgithubrepos.details;


import com.piwko.dawid.searchgithubrepos.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface RepoDetailsComponent extends AndroidInjector<RepoDetailsController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RepoDetailsController> {

    }
}
