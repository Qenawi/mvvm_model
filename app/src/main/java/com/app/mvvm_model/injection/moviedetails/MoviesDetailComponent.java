package com.app.mvvm_model.injection.moviedetails;

import com.app.mvvm_model.injection.rx.SchedulerModule;
import com.app.mvvm_model.presentation.base.ActivityScope;
import com.app.mvvm_model.presentation.sup.MovieDetail.DetailActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {Extra_Data.class,MoviesDetailPresenterModule.class, SchedulerModule.class},
        dependencies = {MovieDetailInteractorComponent.class})
public interface MoviesDetailComponent
{
    // inject detail activity
    void inject(DetailActivity detailActivity);
}
