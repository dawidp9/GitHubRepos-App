package com.piwko.dawid.searchgithubrepos.data;

import com.piwko.dawid.searchgithubrepos.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepoRequester {

    private final RepoService service;

    @Inject
    public RepoRequester(RepoService service) {
        this.service = service;
    }

    public Single<List<Repo>> getUserRepos(String username) {
        return service.getUserRepos(username).subscribeOn(Schedulers.io());
    }

}
