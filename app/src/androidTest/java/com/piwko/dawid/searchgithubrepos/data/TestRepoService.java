package com.piwko.dawid.searchgithubrepos.data;

import com.piwko.dawid.searchgithubrepos.model.Repo;
import com.piwko.dawid.searchgithubrepos.test.TestUtilities;
import com.squareup.moshi.Types;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class TestRepoService implements RepoService {
    private Throwable throwable = null;
    private TestUtilities testUtilities;

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Inject
    TestRepoService(TestUtilities testUtilities) {
        this.testUtilities = testUtilities;
    }

    @Override
    public Single<List<Repo>> getUserRepos(String username) {
        if (throwable != null) {
            return Single.error(throwable);
        }
        List<Repo> repoList = getUserReposList();
        return Single.just(repoList);
    }

    public List<Repo> getUserReposList() {
        return testUtilities
                .loadJson("mock/repos_list_username_dawidp9.json",
                        Types.newParameterizedType(List.class,Repo.class));
    }

    public void clearThrowable() {
        this.throwable = null;
    }
}
