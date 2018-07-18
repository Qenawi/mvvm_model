package com.app.mvvm_model.usecase.remote;

import com.app.mvvm_model.data.api.MovieResponse;
import com.app.mvvm_model.data.api.MovieService;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.MovieDataSource;
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

    @Inject
    public MovieRemoteDataSource(MovieService service) {
        this.service = service;
    }

    @Override
    public Flowable<List<Movie>> loadMovies(boolean forceRemote) {
        return service.LoadMoviesByTitle(Constants.OMDP_API_KEY, Constants.CONST_SEARCH_TEST_TITLE).map(MovieResponse::getMovies);
    }

    @Override
    public void addMovie(Movie movie) {
        //Its not needed for remote source.

        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);

    }

    @Override
    public void clearData() {
        //Its not needed for remote source.

        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);

    }
}
