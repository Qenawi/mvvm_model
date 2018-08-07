package com.app.mvvm_model.injection.moviedetails;

import com.app.mvvm_model.injection.AppModule;
import com.app.mvvm_model.injection.database.DatabaseModule;
import com.app.mvvm_model.injection.movie.MovieInteractorModule;
import com.app.mvvm_model.injection.service.ApiServiceModule;
import com.app.mvvm_model.usecase.DetailMovie.MovieDetailUseCase;
import com.app.mvvm_model.usecase.Movie.MovieUseCase;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {MovieDetailInteractorModule.class, AppModule.class, ApiServiceModule.class, DatabaseModule.class})
public interface MovieDetailInteractorComponent
{
    //usecase
    MovieDetailUseCase provideMovieDetailRepo();
}
