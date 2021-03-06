package com.app.mvvm_model.presentation.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.support.v7.app.AppCompatActivity;

import com.app.mvvm_model.Movie_Application;
import com.app.mvvm_model.injection.movie.MovieInteractorComponent;
import com.app.mvvm_model.injection.moviedetails.MovieDetailInteractorComponent;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public abstract class BaseActivity extends AppCompatActivity
{
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    protected MovieInteractorComponent getMovieInteractorComponent()
    {
        return ((Movie_Application) getApplication()).getMovieInteractorComponent();
    }
    protected MovieDetailInteractorComponent getMovieDetailInteractorComponent()
    {
        return ((Movie_Application) getApplication()).getMovieDetailInteractorComponent();
    }
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
