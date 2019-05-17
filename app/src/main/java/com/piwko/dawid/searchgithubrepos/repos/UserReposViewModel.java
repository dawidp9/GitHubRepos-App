package com.piwko.dawid.searchgithubrepos.repos;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.di.ScreenScope;
import com.piwko.dawid.searchgithubrepos.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;
import timber.log.Timber;

@ScreenScope
public class UserReposViewModel {

    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    public UserReposViewModel() {
    }

    Observable<Boolean> loading() {
        return loadingRelay;
    }

    Observable<List<Repo>> repos() {
        return reposRelay;
    }

    Observable<Integer> error() {
        return errorRelay;
    }

    Consumer<Boolean> loadingUpdated() {
        return loadingRelay;
    }

    Consumer<List<Repo>> reposUpdated() {
        errorRelay.accept(-1);
        return reposRelay;
    }

    Consumer<Throwable> onError() {
        return throwable -> {
            Timber.e(throwable, "API Error");
            if (throwable instanceof HttpException) {
                HttpException httpException = (HttpException) throwable;
                int code = httpException.code();
                if (code == 404) {
                    errorRelay.accept(R.string.api_error_repos_404_not_found);
                } else if (code == 500) {
                    errorRelay.accept(R.string.api_error_repos_500_server_error);
                } else {
                    errorRelay.accept(R.string.api_error_repos);
                }
            } else {
                errorRelay.accept(R.string.error_repos);
            }
        };
    }



}
