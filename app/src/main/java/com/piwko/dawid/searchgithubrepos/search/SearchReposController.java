package com.piwko.dawid.searchgithubrepos.search;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.base.BaseController;


import javax.inject.Inject;

import butterknife.BindView;

public class SearchReposController extends BaseController {

    @Inject SearchReposPresenter presenter;

//    @BindView(R.id.buttonSearch)
//    Button buttonSearch;
//    @BindView(R.id.editTextUsername)
//    EditText editTextUsername;

    public SearchReposController() {

    }

    public static Controller newInstance() {
        return new SearchReposController();
    }

    public SearchReposController(Bundle bundle) {
        super(bundle);
    }

    @Override
    protected void onViewBound(View view) {
//        buttonSearch.setOnClickListener(v -> {
//            String username = editTextUsername.getText().toString().trim();
//            if (username.isEmpty()) {
//                presenter.showAlertDialog(
//                        v.getContext(),
//                        R.string.alert_dialog_empty_username_title,
//                        R.string.alert_dialog_empty_username_message);
//            } else  {
//                presenter.setUsername(username);
//                presenter.onClick(v);
//            }
//        });

        super.onViewBound(view);
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_search_repos;
    }
}
