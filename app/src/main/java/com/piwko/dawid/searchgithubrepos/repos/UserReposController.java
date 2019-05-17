package com.piwko.dawid.searchgithubrepos.repos;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.base.BaseController;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class UserReposController extends BaseController {
    static final String REPOS_USERNAME_KEY = "repos_username";
    Context context;

    @Inject UserReposPresenter presenter;
    @Inject UserReposViewModel viewModel;

    @BindView(R.id.repos_recycleView)
    RecyclerView recyclerView;
    @BindView(R.id.loading_indicator)
    View loadingView;

    public UserReposController(Bundle bundle) {
        super(bundle);
    }

    public static Controller newInstance(String username) {
        Bundle bundle = new Bundle();
        bundle.putString(REPOS_USERNAME_KEY, username);

        return new UserReposController(bundle);
    }


    @Override
    protected void onViewBound(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RepoAdapter(presenter));
        this.context = view.getContext();
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[] {
                viewModel.loading()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loading -> {
                    loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
                    recyclerView.setVisibility(loading ? View.GONE: View.VISIBLE);
                }),
                viewModel.repos()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(((RepoAdapter)Objects.requireNonNull(recyclerView.getAdapter()))::setData),
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(errorRes -> {
                            if (errorRes != -1) {
                                recyclerView.setVisibility(View.GONE);
                                presenter.goToRepoSearch();
                                if (errorRes == R.string.api_error_repos_404_not_found) {
                                    presenter.showAlertDialog(
                                            context,
                                            errorRes,
                                            R.string.alert_dialog_username_not_found_message);
                                } else {
                                    presenter.showAlertDialog(
                                            context,
                                            R.string.title_alert_dialog,
                                            errorRes);
                                }
                            }
                 })
        };
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_user_repos;
    }

}
