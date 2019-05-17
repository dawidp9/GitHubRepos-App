package com.piwko.dawid.searchgithubrepos.repos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.piwko.dawid.searchgithubrepos.data.RepoRequester;
import com.piwko.dawid.searchgithubrepos.di.ScreenScope;
import com.piwko.dawid.searchgithubrepos.model.Repo;
import com.piwko.dawid.searchgithubrepos.ui.ScreenNavigator;

import javax.inject.Inject;
import javax.inject.Named;

@ScreenScope
class UserReposPresenter implements RepoAdapter.RepoClickedListener{

    private final UserReposViewModel viewModel;
    private final RepoRequester repoRequester;
    private final ScreenNavigator screenNavigator;

    @Inject
    UserReposPresenter(
            @Named("repo_username") String repoUser,
            UserReposViewModel viewModel,
            RepoRequester repoRequester,
            ScreenNavigator screenNavigator) {
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;
        this.screenNavigator = screenNavigator;
        loadRepos(repoUser);
    }

    @SuppressLint("CheckResult")
    private void loadRepos(String repoUser) {
        repoRequester.getUserRepos(repoUser)
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {
        screenNavigator.goToRepoDetails(repo);
    }

    void goToRepoSearch(){
        screenNavigator.pop();
    }

    void showAlertDialog(Context context, int titleResId, int messageResId){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(context.getResources().getString(titleResId));
        alertDialog.setMessage(context.getResources().getString(messageResId));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }
}
