package com.piwko.dawid.searchgithubrepos.home;

import android.os.Bundle;

import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.base.BaseActivity;
import com.piwko.dawid.searchgithubrepos.search.SearchReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected SearchReposController initialScreen() {
        return new SearchReposController();
    }
}
