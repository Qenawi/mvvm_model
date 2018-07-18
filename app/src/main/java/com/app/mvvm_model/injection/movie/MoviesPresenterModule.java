package com.app.mvvm_model.injection.movie;

import com.app.mvvm_model.presentation.sup.Movies.MoviesContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Module
public class MoviesPresenterModule
{
    MoviesContract.View view;

    public MoviesPresenterModule(MoviesContract.View view) {
        this.view = view;
    }

    @Provides
    MoviesContract.View provideView() {
        return view;
    }
}
