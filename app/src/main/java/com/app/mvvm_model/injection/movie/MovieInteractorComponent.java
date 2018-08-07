package com.app.mvvm_model.injection.movie;

import com.app.mvvm_model.injection.AppModule;
import com.app.mvvm_model.injection.database.DatabaseModule;
import com.app.mvvm_model.injection.service.ApiServiceModule;
import com.app.mvvm_model.usecase.Movie.MovieUseCase;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Singleton
@Component(modules = {MovieInteractorModule.class, AppModule.class, ApiServiceModule.class, DatabaseModule.class})
public interface MovieInteractorComponent
{
    MovieUseCase provideMovieRepo();
}
