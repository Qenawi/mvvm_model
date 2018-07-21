package com.app.mvvm_model.injection.movie;

import com.app.mvvm_model.injection.rx.SchedulerModule;
import com.app.mvvm_model.presentation.base.ActivityScope;
import com.app.mvvm_model.presentation.sup.Movies.MoviesActivity;

import dagger.Component;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@ActivityScope
@Component(modules = {MoviesPresenterModule.class, SchedulerModule.class},
        dependencies = {MovieInteractorComponent.class})
public interface MoviesComponent {
    void inject(MoviesActivity moviesActivity);
}
