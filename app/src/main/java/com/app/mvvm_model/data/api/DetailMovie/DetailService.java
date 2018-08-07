package com.app.mvvm_model.data.api.DetailMovie;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DetailService
{
    @GET()
    Flowable<DetailResponse>Get_MovieDetails(@Url String MovieQuery, @Query("api_key") String ApiKey);
}
