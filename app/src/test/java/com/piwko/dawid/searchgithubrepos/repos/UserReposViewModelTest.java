package com.piwko.dawid.searchgithubrepos.repos;

import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.TestUtilities;
import com.piwko.dawid.searchgithubrepos.model.Repo;
import com.squareup.moshi.Types;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.observers.TestObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;


public class UserReposViewModelTest {
    private UserReposViewModel userReposViewModel;
    private List<Repo> reposList;
    private ResponseBody emptyResponseBody;

    @Before
    public void setUp() {
        userReposViewModel = new UserReposViewModel();
        // load mock repos json response
        reposList = TestUtilities.loadJson("mock/repos_list_username_dawidp9.json",
                Types.newParameterizedType(List.class, Repo.class));
        emptyResponseBody = ResponseBody.create(null, new byte[0]);
    }

    @Test
    public void loading() throws Exception {
        TestObserver<Boolean> loadingTestObserver = userReposViewModel.loading().test();

        // when
        userReposViewModel.loadingUpdated().accept(true); // toggle loading up
        userReposViewModel.loadingUpdated().accept(false); // toggle loading down

        // then
        loadingTestObserver.assertValues(true, false);
    }

    @Test
    public void repos() throws Exception {
        // when
        // pass the repository List to View Model
        userReposViewModel.reposUpdated().accept(reposList);

        // then
        // check data
        userReposViewModel.repos().test().assertValue(reposList);
    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorTestObserver = userReposViewModel.error().test();

        // when
        // throw exception
        userReposViewModel.onError().accept(new Exception());
        // successful reload data
        userReposViewModel.reposUpdated().accept(reposList);

        // then
        // check response
        errorTestObserver.assertValues(R.string.error_repos, -1);
    }

    @Test
    public void errorHttp404() throws Exception {
        TestObserver<Integer> errorTestObserver = userReposViewModel.error().test();

        // when
        // throw Not Found exception
        userReposViewModel.onError().accept(
                new HttpException(
                        Response.error(
                        404,
                        emptyResponseBody)));
        // successful reload data
        userReposViewModel.reposUpdated().accept(reposList);

        // then
        // check response
        errorTestObserver.assertValues(R.string.api_error_repos_404_not_found, -1);
    }

    @Test
    public void errorHttp500() throws Exception {
        TestObserver<Integer> errorTestObserver = userReposViewModel.error().test();

        // when
        // throw Internal Server Error
        userReposViewModel.onError().accept(
                new HttpException(
                        Response.error(
                        500,
                        emptyResponseBody)));
        // successful reload data
        userReposViewModel.reposUpdated().accept(reposList);

        // then
        // check response
        errorTestObserver.assertValues(R.string.api_error_repos_500_server_error, -1);
    }
}