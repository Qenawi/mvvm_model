package com.app.mvvm_model.presentation.sup.Movies;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

import com.app.mvvm_model.rx.RunOn;
import com.app.mvvm_model.usecase.MovieUseCase;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

import static com.app.mvvm_model.rx.SchedulerType.IO;
import static com.app.mvvm_model.rx.SchedulerType.UI;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MoviesPresenter implements MoviesContract.Presenter, LifecycleObserver
{
    private MovieUseCase interactor;

    private MoviesContract.View view;

    private Scheduler ioScheduler;
    private Scheduler mainScheduler;

    private CompositeDisposable disposable;

    @Inject
    MoviesPresenter(MovieUseCase interactor, MoviesContract.View view, @RunOn(IO) Scheduler ioScheduler, @RunOn(UI) Scheduler mainScheduler)
    {
        this.interactor = interactor;
        this.view = view;
        this.ioScheduler = ioScheduler;
        this.mainScheduler = mainScheduler;

        if(view instanceof LifecycleOwner) {((LifecycleOwner) view).getLifecycle().addObserver(this);}
        disposable = new CompositeDisposable();
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetech() {

    }

    @Override
    public void loadMovies(boolean onlineRequired) {

    }

    @Override
    public void search(String MovieTitle) {

    }
}
