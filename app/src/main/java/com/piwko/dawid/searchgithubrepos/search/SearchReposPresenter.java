package com.piwko.dawid.searchgithubrepos.search;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;


import com.piwko.dawid.searchgithubrepos.di.ScreenScope;
import com.piwko.dawid.searchgithubrepos.ui.ScreenNavigator;

import javax.inject.Inject;

@ScreenScope
public class SearchReposPresenter implements View.OnClickListener {

    private final ScreenNavigator screenNavigator;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Inject
    SearchReposPresenter(ScreenNavigator screenNavigator) {
        this.screenNavigator = screenNavigator;
    }

    @Override
    public void onClick(View v) {
        //TODO(move to next screen)
    }

    public void showAlertDialog(Context context, int titleResId, int messageResId){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(context.getResources().getString(titleResId));
        alertDialog.setMessage(context.getResources().getString(messageResId));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }

}
