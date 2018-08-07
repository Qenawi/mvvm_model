package com.app.mvvm_model.usecase.Movie;

import android.support.annotation.VisibleForTesting;

import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.Local;
import com.app.mvvm_model.usecase.Remote;
import com.app.mvvm_model.utils.Constants;

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
    List<Movie> PopularCaches;
    List<Movie> TopCaches;


    @Inject
    public MovieUseCase(@Remote MovieDataSource remoteDataSource, @Local MovieDataSource localDataSource)
    {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.PopularCaches = new ArrayList<Movie>();
        this.TopCaches = new ArrayList<Movie>();
    }
    @Override
    public Flowable<List<Movie>> loadPopular(boolean isRemote)
    {
        if (isRemote)
        {
            return refreshPopData();
        } else {
            if (PopularCaches.size() > 0)
            {
                // if cache is available, return it immediately
                return Flowable.just(PopularCaches);
            } else {
                return localDataSource.loadPopular(false).
                        take(1).flatMap(Flowable::fromIterable).
                        doOnNext(movie ->
                                PopularCaches.add(movie))
                        .toList()
                        .toFlowable().filter(list -> !list.isEmpty())
                        .switchIfEmpty(
                                refreshPopData()
                        );
            }//else
        }//else
    }

    @Override
    public Flowable<List<Movie>> loadTopRated(boolean isRemote)
    {
        if (isRemote)
        {
            return refreshTopData();
        } else {
            if (TopCaches.size() > 0)
            {
                // if cache is available, return it immediately
                return Flowable.just(TopCaches);
            } else {
                return localDataSource.loadTopRated(false).
                        take(1).flatMap(Flowable::fromIterable).
                        doOnNext(movie ->
                                TopCaches.add(movie))
                        .toList()
                        .toFlowable().filter(list -> !list.isEmpty())
                        .switchIfEmpty(
                                refreshTopData()
                        );
            }//else
        }//else
    }


    @Override
    public void addMovie(Movie movie)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearDataByTag(String Tag)
    {
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

    private Flowable<List<Movie>> refreshPopData()
    {
        return remoteDataSource.loadPopular(true).doOnNext(list ->
        {
            // Clear cache
            PopularCaches.clear();
            // Clear data in local storage
            localDataSource.clearDataByTag(Constants.DAO_TAGS.PopularTag);
        }).flatMap(Flowable::fromIterable).doOnNext(movie ->
        {
            movie.setTag(Constants.DAO_TAGS.PopularTag);
            PopularCaches.add(movie);
            localDataSource.addMovie(movie);
        }).toList().toFlowable();
    }
    private Flowable<List<Movie>> refreshTopData()
    {
        return remoteDataSource.loadTopRated(true).doOnNext(list ->
        {
            // Clear cache
            TopCaches.clear();
            // Clear data in local storage
            localDataSource.clearDataByTag(Constants.DAO_TAGS.TopRatedTag);
        }).flatMap(Flowable::fromIterable).doOnNext(movie ->
        {
            movie.setTag(Constants.DAO_TAGS.TopRatedTag);
            TopCaches.add(movie);
            localDataSource.addMovie(movie);
        }).toList().toFlowable();
    }
}
