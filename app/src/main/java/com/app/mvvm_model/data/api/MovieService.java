package com.app.mvvm_model.data.api;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public interface MovieService
{
    @GET()
    Flowable<MovieResponse>LoadMoviesByTitle(@Url String url, @Query("apikey") String ApiKey, @Query("s") String title);
}
