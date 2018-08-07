package com.app.mvvm_model.injection.moviedetails;

import com.app.mvvm_model.usecase.DetailMovie.MovieDetailDataSource;
import com.app.mvvm_model.usecase.DetailMovie.local.MovieDetailLocalDataSource;
import com.app.mvvm_model.usecase.DetailMovie.remote.MovieDetailRemoteDataSource;
import com.app.mvvm_model.usecase.Local;
import com.app.mvvm_model.usecase.Movie.MovieDataSource;
import com.app.mvvm_model.usecase.Movie.local.MovieLocalDataSource;
import com.app.mvvm_model.usecase.Movie.remote.MovieRemoteDataSource;
import com.app.mvvm_model.usecase.Remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailInteractorModule
{
    @Provides
    @Local
    @Singleton
    public MovieDetailDataSource provideLocalDataSource(MovieDetailLocalDataSource movieDetailLocalDataSource) {
        return movieDetailLocalDataSource;
    }

    @Provides
    @Remote
    @Singleton
    public MovieDetailDataSource provideRemoteDataSource(MovieDetailRemoteDataSource movieDetailRemoteDataSource)
    {
        return movieDetailRemoteDataSource;
    }



}
