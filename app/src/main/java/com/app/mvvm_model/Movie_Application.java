package com.app.mvvm_model;

import android.app.Application;

import com.app.mvvm_model.injection.AppModule;
import com.app.mvvm_model.injection.movie.MovieInteractorComponent;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class Movie_Application extends Application
{
    private MovieInteractorComponent interactorComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        initializeDependencies();
    }
    private void initializeDependencies()
    {
        interactorComponent = DaggerMovieInteractorComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public MovieInteractorComponent getMovieInteractorComponent()
    {
        return interactorComponent;
    }
}
