package com.app.mvvm_model.usecase.Movie.remote;

import com.app.mvvm_model.data.api.MovieResponse;
import com.app.mvvm_model.data.api.MovieService;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.Movie.MovieDataSource;
import com.app.mvvm_model.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static com.app.mvvm_model.utils.Constants.UNSUPPORTED_OPERATION;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieRemoteDataSource implements MovieDataSource {
    private MovieService service;
    private String extra = "";

    @Inject
    public MovieRemoteDataSource(MovieService service) {
        this.service = service;
    }

    @Override
    public Flowable<List<Movie>> loadPopular(boolean forceRemote)
    {
        return service.LoadMoviesPop(Constants.TMDP_API_KEY).map(MovieResponse::getMovies);

    }

    @Override
    public Flowable<List<Movie>> loadTopRated(boolean forceRemote)
    {
        return service.LoadMoviesTrated(Constants.TMDP_API_KEY).map(MovieResponse::getMovies);
    }

    @Override
    public void addMovie(Movie movie) {
        //Its not needed for remote source.
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearDataByTag(String Tag)
    {
        //Its not needed for remote source.

        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearData() {
        //Its not needed for remote source.

        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);

    }
}
