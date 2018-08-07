package com.app.mvvm_model.injection.moviedetails;

import com.app.mvvm_model.presentation.sup.MovieDetail.DetailContract;
import com.app.mvvm_model.presentation.sup.Movies.MoviesContract;

import dagger.Module;
import dagger.Provides;
@Module

public class MoviesDetailPresenterModule
{
    DetailContract.View view;

    public MoviesDetailPresenterModule(DetailContract.View view) {
        this.view = view;
    }

    @Provides
    DetailContract.View provideView() {
        return view;
    }
}
