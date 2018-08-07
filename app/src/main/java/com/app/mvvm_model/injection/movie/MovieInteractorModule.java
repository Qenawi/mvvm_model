package com.app.mvvm_model.injection.movie;

import com.app.mvvm_model.usecase.Movie.MovieDataSource;
import com.app.mvvm_model.usecase.Local;
import com.app.mvvm_model.usecase.Movie.local.MovieLocalDataSource;
import com.app.mvvm_model.usecase.Movie.remote.MovieRemoteDataSource;
import com.app.mvvm_model.usecase.Remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Module
public class MovieInteractorModule
{
    @Provides
    @Local
    @Singleton
    public MovieDataSource provideLocalDataSource(MovieLocalDataSource movieLocalDataSource) {
        return movieLocalDataSource;
    }

    @Provides
    @Remote
    @Singleton
    public MovieDataSource provideRemoteDataSource(MovieRemoteDataSource movieRemoteDataSource) {
        return movieRemoteDataSource;
    }


}
