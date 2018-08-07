package com.app.mvvm_model.usecase.DetailMovie;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public interface MovieDetailDataSource

{
    Flowable<DetailResponse> loadMovieDetails(boolean forceRemote,int MovieID);
    void addMovie(DetailResponse movie);
    void clearDataByID(int id);
    void clearData();
}
