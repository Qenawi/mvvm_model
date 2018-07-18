package com.app.mvvm_model.usecase.local;

import com.app.mvvm_model.data.database.MovieDao;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.MovieDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieLocalDataSource implements MovieDataSource
{

    private MovieDao movieDao;
    @Inject
    public MovieLocalDataSource(MovieDao movieDao){this.movieDao=movieDao;}
    @Override
    public Flowable<List<Movie>> loadMovies(boolean forceRemote)
    {
        return movieDao.getAllMovies();
    }

    @Override
    public void addMovie(Movie movie)
    {
movieDao.insert(movie);
    }

    @Override
    public void clearData()
    {
movieDao.deleteAll();
    }
}
