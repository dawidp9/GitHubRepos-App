package com.piwko.dawid.searchgithubrepos.details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.base.BaseController;
import com.piwko.dawid.searchgithubrepos.model.Repo;

import org.threeten.bp.format.DateTimeFormatter;

import javax.inject.Inject;

import butterknife.BindView;

public class RepoDetailsController extends BaseController {

    @Inject RepoDetailsPresenter presenter;

    @BindView(R.id.text_view_repo_details_name)
    TextView textViewRepoDetailsName;
    @BindView(R.id.text_view_repo_details_desc)
    TextView textViewRepoDetailsDesc;
    @BindView(R.id.text_view_language)
    TextView textViewLanguage;
    @BindView(R.id.text_view_stargazers_count)
    TextView textViewtSstargazersCount;
    @BindView(R.id.text_view_watchers_count)
    TextView textViewWatchersCount;
    @BindView(R.id.text_view_forks_count)
    TextView textViewForksCount;
    @BindView(R.id.text_view_created_date)
    TextView textViewCreatedDate;
    @BindView(R.id.text_view_update_date)
    TextView textViewUpdateDate;
    @BindView(R.id.text_view_default_branch)
    TextView textViewDefaultBranch;
    @BindView(R.id.text_view_id)
    TextView textViewId;
    @BindView(R.id.text_view_node_id)
    TextView textViewNodeId;
    @BindView(R.id.text_view_html_url)
    TextView textViewHtmlUrl;
    @BindView(R.id.text_view_ssh_url)
    TextView textViewSshUrl;
    @BindView(R.id.text_view_size)
    TextView textViewSize;



    private Repo repo;

    public RepoDetailsController(Repo repo) {
        this.repo = repo;
    }

    public RepoDetailsController(Bundle bundle) {
        super(bundle);
    }

    public static Controller newInstance(Repo repo) {
        return new RepoDetailsController(repo);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onViewBound(View view) {
        textViewRepoDetailsName.setText(repo.name());
        String desc = repo.description();
        if(desc != null) textViewRepoDetailsDesc.setText(desc);
        textViewCreatedDate.setText(repo.createdDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        textViewUpdateDate.setText(repo.updatedDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        textViewDefaultBranch.setText(repo.defaultBranch());
        textViewHtmlUrl.setText(repo.htmlUrl());
        textViewLanguage.setText(repo.language());
        textViewtSstargazersCount.setText(Long.toString(repo.stargazersCount()));
        textViewWatchersCount.setText(Long.toString(repo.watchersCount()));
        textViewForksCount.setText(Long.toString(repo.forksCount()));
        textViewId.setText(Long.toString(repo.id()));
        textViewNodeId.setText(repo.nodeId());
        textViewSshUrl.setText(repo.sshUrl());
        textViewSize.setText(Long.toString(repo.size()));
        super.onViewBound(view);
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_repo_details;
    }
}
