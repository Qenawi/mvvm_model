package com.app.mvvm_model.presentation.sup.MovieDetail;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.rx.RunOn;
import com.app.mvvm_model.usecase.DetailMovie.MovieDetailUseCase;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.app.mvvm_model.rx.SchedulerType.IO;
import static com.app.mvvm_model.rx.SchedulerType.UI;

public class DetailPresenter implements DetailContract.Presenter, LifecycleObserver {
    private MovieDetailUseCase interactor;

    private DetailContract.View view;

    private Scheduler ioScheduler;
    private Scheduler mainScheduler;
    private int MovieID;
    private CompositeDisposable disposable;

    @Inject
    public DetailPresenter(int movieID, MovieDetailUseCase interactor, DetailContract.View view, @RunOn(IO) Scheduler ioScheduler, @RunOn(UI) Scheduler mainScheduler) {
        this.interactor = interactor;
        this.view = view;
        this.MovieID = movieID;
        this.ioScheduler = ioScheduler;
        this.mainScheduler = mainScheduler;
        if (view instanceof LifecycleOwner) {
            Log.v("adad", "|@");
            ((LifecycleOwner) view).getLifecycle().addObserver(this);
        }
        disposable = new CompositeDisposable();
    }

    @Override
    public void loadMovie(boolean onlineRequired) {
        view.showLoading();
        addDisposable(interactor.loadMovieDetails(onlineRequired, MovieID)
                .subscribeOn(ioScheduler).
                        observeOn(mainScheduler).
                        subscribe(this::handleMovie, this::handleError)

        );
    }

    private void handleMovie(DetailResponse detailResponse)
    {
        if (detailResponse != null )
        {
            view.showMovie(detailResponse);
        } else {
            view.showNoDataMessage();
        }
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onAttach() {
        Log.v("ATTACHED", "ATTACHED");
        loadMovie(false);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onDetech() {
        disposable.clear();
    }

    private void addDisposable(Disposable disposable) {
        this.disposable.add(disposable);
    }

    private void handleError(Throwable error) {
        view.hideLoading();
        view.showErrorMessage(error.getLocalizedMessage());
    }
}
