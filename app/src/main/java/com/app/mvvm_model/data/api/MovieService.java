package com.app.mvvm_model.data.api;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public interface MovieService
{
    @GET()
    Flowable<MovieResponse>LoadMoviesByTitle(@Query("apikey") String ApiKey,@Query("s") String title);
}
