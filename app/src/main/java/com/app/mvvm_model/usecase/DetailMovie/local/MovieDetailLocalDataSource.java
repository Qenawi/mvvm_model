package com.app.mvvm_model.usecase.DetailMovie.local;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.database.DetailsDao.DetailMovieDao;
import com.app.mvvm_model.data.database.MovieDao;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.DetailMovie.MovieDetailDataSource;
import com.app.mvvm_model.usecase.Movie.MovieDataSource;
import com.app.mvvm_model.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieDetailLocalDataSource implements MovieDetailDataSource {

    private DetailMovieDao movieDao;

    @Inject
    public MovieDetailLocalDataSource(DetailMovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @Override
    public Flowable<DetailResponse> loadMovieDetails(boolean forceRemote,int  MovieID)
    {
        return movieDao.getMovieById(MovieID);
    }
    @Override
    public void addMovie(DetailResponse movie) {
        movieDao.insert(movie);
    }

    @Override
    public void clearDataByID(int ID)
    {
        movieDao.deleteById(ID);
    }

    @Override
    public void clearData() {
        movieDao.deleteAll();
    }
}
