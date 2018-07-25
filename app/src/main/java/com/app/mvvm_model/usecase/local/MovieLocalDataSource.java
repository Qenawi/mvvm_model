package com.app.mvvm_model.usecase.local;

import com.app.mvvm_model.data.database.MovieDao;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.MovieDataSource;
import com.app.mvvm_model.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieLocalDataSource implements MovieDataSource {

    private MovieDao movieDao;

    @Inject
    public MovieLocalDataSource(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @Override
    public Flowable<List<Movie>> loadPopular(boolean forceRemote)
    {
        return movieDao.getMoviesByTag(Constants.DAO_TAGS.PopularTag);
    }
    @Override
    public Flowable<List<Movie>> loadTopRated(boolean forceRemote)
    {
        return movieDao.getMoviesByTag(Constants.DAO_TAGS.TopRatedTag);
    }
    @Override
    public void addMovie(Movie movie) {
        movieDao.insert(movie);
    }

    @Override
    public void clearDataByTag(String Tag) {
        movieDao.deleteByTaG(Tag);
    }

    @Override
    public void clearData() {
        movieDao.deleteAll();
    }
}
