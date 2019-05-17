package com.piwko.dawid.searchgithubrepos.data;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TestRepoServiceModule {

    // repo service module without retrofit
    @Binds
    abstract RepoService bindRepoService(TestRepoService testRepoService);
}
