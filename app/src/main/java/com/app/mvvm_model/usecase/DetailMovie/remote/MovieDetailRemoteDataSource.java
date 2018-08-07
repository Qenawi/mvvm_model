package com.app.mvvm_model.usecase.DetailMovie.remote;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.api.DetailMovie.DetailService;
import com.app.mvvm_model.data.api.MovieResponse;
import com.app.mvvm_model.data.api.MovieService;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.DetailMovie.MovieDetailDataSource;
import com.app.mvvm_model.usecase.Movie.MovieDataSource;
import com.app.mvvm_model.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static com.app.mvvm_model.utils.Constants.UNSUPPORTED_OPERATION;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieDetailRemoteDataSource implements MovieDetailDataSource {
    private DetailService service;
    @Inject
    public MovieDetailRemoteDataSource(DetailService service) {
        this.service = service;
    }

    @Override
    public Flowable<DetailResponse> loadMovieDetails(boolean forceRemote,int MovieID)
    {
        return service.Get_MovieDetails(Constants.Movies.getMovieDetailUrl(MovieID),Constants.TMDP_API_KEY);

    }


    @Override
    public void addMovie(DetailResponse movie) {
        //Its not needed for remote source.
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearDataByID(int id)
    {
        //Its not needed for remote source.

        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearData()
    {
        //Its not needed for remote source.

        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);

    }
}
