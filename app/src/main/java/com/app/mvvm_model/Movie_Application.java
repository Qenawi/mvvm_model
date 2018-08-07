package com.app.mvvm_model;

import android.app.Application;

import com.app.mvvm_model.injection.AppModule;
import com.app.mvvm_model.injection.movie.DaggerMovieInteractorComponent;
import com.app.mvvm_model.injection.movie.MovieInteractorComponent;
import com.app.mvvm_model.injection.moviedetails.DaggerMovieDetailInteractorComponent;
import com.app.mvvm_model.injection.moviedetails.MovieDetailInteractorComponent;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class Movie_Application extends Application
{
    private MovieInteractorComponent interactorComponent;
   private MovieDetailInteractorComponent movieDetailInteractorComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        initializeDependencies();
    }
/*
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
*/
    private void initializeDependencies()
    {

        interactorComponent = DaggerMovieInteractorComponent.builder()
                .appModule(new AppModule(this))
                .build();


        movieDetailInteractorComponent=DaggerMovieDetailInteractorComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public MovieInteractorComponent getMovieInteractorComponent()
    {
        return interactorComponent;
    }
    public MovieDetailInteractorComponent getMovieDetailInteractorComponent()
    {
        return movieDetailInteractorComponent;
    }


}
