package com.app.mvvm_model.presentation.sup.Movies;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.rx.RunOn;
import com.app.mvvm_model.usecase.Movie.MovieUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.app.mvvm_model.rx.SchedulerType.IO;
import static com.app.mvvm_model.rx.SchedulerType.UI;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MoviesPresenter implements MoviesContract.Presenter, LifecycleObserver {
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
        Log.v("adad","|@ss");
        if (view instanceof LifecycleOwner)
        {
            Log.v("adad","|@");
            ((LifecycleOwner) view).getLifecycle().addObserver(this);
        }
        disposable = new CompositeDisposable();
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onAttach()
    {
        Log.v("ATTACHED","ATTACHED");
        loadMovies(false);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onDetech()
    {
        disposable.clear();
    }

    @Override
    public void loadMovies(boolean onlineRequired)
    {
        view.showLoading();
        // Clear old data on view
        view.clearMovies();
        addDisposable(interactor.loadPopular(onlineRequired).
                subscribeOn(ioScheduler).
                observeOn(mainScheduler).
                subscribe(this::handleMovies, this::handleError, () -> addDisposable(interactor.loadTopRated(onlineRequired).subscribeOn(ioScheduler).observeOn(mainScheduler).subscribe(this::handleMovies_Top))));


    }
    private void addDisposable(Disposable disposable) {
        this.disposable.add(disposable);
    }

    @Override
    public void search(String MovieTitle) {

    }

    private void handleError(Throwable error)
    {
        view.hideLoading();
        view.showErrorMessage(error.getLocalizedMessage());
    }

    private void handleMovies(List<Movie> questionList)
    {
      //  view.hideLoading();
        if (questionList != null && !questionList.isEmpty())
        {
            view.showMovies(questionList);
        } else {
            view.showNoDataMessage();
        }
    }
    private void handleMovies_Top(List<Movie> questionList)
    {
        view.hideLoading();
        if (questionList != null && !questionList.isEmpty())
        {
            view.showMoviesTop(questionList);
        } else {
            view.showNoDataMessage();
        }

    }
}
