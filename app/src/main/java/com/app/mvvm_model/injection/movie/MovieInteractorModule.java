package com.app.mvvm_model.injection.movie;

import com.app.mvvm_model.usecase.local.Local;
import com.app.mvvm_model.usecase.local.MovieLocalDataSource;
import com.app.mvvm_model.usecase.remote.Remote;

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
    public MovieLocalDataSource provideLocalDataSource(MovieLocalDataSource questionLocalDataSource) {
        return questionLocalDataSource;
    }

    @Provides
    @Remote
    @Singleton
    public MovieLocalDataSource provideRemoteDataSource(MovieLocalDataSource questionRemoteDataSource) {
        return questionRemoteDataSource;
    }


}
