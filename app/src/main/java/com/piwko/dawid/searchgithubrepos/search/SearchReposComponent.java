package com.piwko.dawid.searchgithubrepos.search;


import com.piwko.dawid.searchgithubrepos.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface SearchReposComponent extends AndroidInjector<SearchReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SearchReposController> {

    }
}
