package com.piwko.dawid.searchgithubrepos.repos;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.test.TestController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
public class UserReposControllerTest extends TestController {
    private ResponseBody emptyResponseBody;

    @Override
    protected Controller setUpController() {
        return UserReposController.newInstance("dawidp9");
    }

    @Before
    public void setUp() {
        emptyResponseBody = ResponseBody.create(null, new byte[0]);
    }


    @Test
    public void checkLoadedRepos() {
        testRepoService.clearThrowable();
        launchActivity();

        ArrayList<String> repoNamesList = new ArrayList<>();
        repoNamesList.add("CodingKnowledgeTest-App");
        repoNamesList.add("GameManager-WebApp");
        repoNamesList.add("InstagramGalleryKotlin-App");
        repoNamesList.add("iOS_Apps");
        repoNamesList.add("mCommerce-App");
        repoNamesList.add("python_in_telecom_Nokia_course");
        repoNamesList.add("REST-API-Commerce");
        repoNamesList.add("University");

        // when successfully loaded by repoService
        // then
        // loading indicator gone
        onView(withId(R.id.loading_indicator))
                .check(matches(
                        withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        // repos list visible
        onView(withId(R.id.repos_recycleView))
                .check((matches(
                        withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));

        // check repos list data
        for (String repoName: repoNamesList) {
            onView(allOf(withId(R.id.text_view_repo_name), withText(repoName)))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }
    }

    @Test
    public void checkReposError() {
        testRepoService.clearThrowable();
        // when
        // throw exception
        testRepoService.setThrowable(new Exception());
        launchActivity();

        // then
        onView(withText(R.string.error_repos))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkReposErrorHttp404() {
        testRepoService.clearThrowable();

        // when
        // throw http exception
        testRepoService.setThrowable(
                new HttpException(
                        Response.error(
                                404,
                                emptyResponseBody)));
        launchActivity();

        // then
        onView(withText(R.string.api_error_repos_404_not_found))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkReposHttpErrorHttp500() {
        testRepoService.clearThrowable();

        // when
        // throw http exception
        testRepoService.setThrowable(
                new HttpException(
                        Response.error(
                                500,
                                emptyResponseBody)));
        launchActivity();

        // then
        onView(withText(R.string.api_error_repos_500_server_error))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
    }


}
