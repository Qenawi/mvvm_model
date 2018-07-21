package com.app.mvvm_model.usecase;

import android.support.annotation.VisibleForTesting;

import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.local.Local;
import com.app.mvvm_model.usecase.remote.Remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static com.app.mvvm_model.utils.Constants.UNSUPPORTED_OPERATION;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieUseCase implements MovieDataSource {
    private MovieDataSource localDataSource;
    private MovieDataSource remoteDataSource;
    @VisibleForTesting
    List<Movie> caches;

    @Inject
    public MovieUseCase(@Remote MovieDataSource remoteDataSource, @Local MovieDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.caches = new ArrayList<>();
    }

    @Override
    public Flowable<List<Movie>> loadMovies(boolean isRemote) {
        if (isRemote) {
            return refreshData();
        } else {
            if (caches.size() > 0) {
                // if cache is available, return it immediately
                return Flowable.just(caches);
            } else {
                return localDataSource.loadMovies(false).
                        take(1).flatMap(Flowable::fromIterable).
                        doOnNext(movie -> caches.add(movie))
                        .toList()
                        .toFlowable().filter(list -> !list.isEmpty())
                        .switchIfEmpty(
                                refreshData()
                        );
            }//else
        }//else

    }


    @Override
    public void addMovie(Movie movie) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearData() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }


    /**
     * Fetches data from remote source.
     * Save it into both local database and cache.
     *
     * @return the Flowable of newly fetched data.
     */
    private Flowable<List<Movie>> refreshData() {
        return remoteDataSource.loadMovies(true).doOnNext(list ->
        {
            // Clear cache
            caches.clear();
            // Clear data in local storage
            localDataSource.clearData();
        }).flatMap(Flowable::fromIterable).doOnNext(movie ->
        {
            caches.add(movie);
            localDataSource.addMovie(movie);
        }).toList().toFlowable();
    }
}
