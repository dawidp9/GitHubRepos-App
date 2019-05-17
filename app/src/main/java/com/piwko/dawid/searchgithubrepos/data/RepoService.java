package com.piwko.dawid.searchgithubrepos.data;

import com.piwko.dawid.searchgithubrepos.model.Repo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoService {

    @GET("users/{username}/repos")
    Single<List<Repo>> getUserRepos(@Path("username") String username);

}
