package com.app.mvvm_model.usecase;

import com.app.mvvm_model.data.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public interface MovieDataSource

{
    Flowable<List<Movie>> loadPopular(boolean forceRemote );
    Flowable<List<Movie>> loadTopRated(boolean forceRemote );
    void addMovie(Movie movie);
    void clearDataByTag(String Tag);
    void clearData();
}
