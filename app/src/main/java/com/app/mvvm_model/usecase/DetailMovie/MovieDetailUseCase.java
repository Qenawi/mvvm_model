package com.app.mvvm_model.usecase.DetailMovie;

import android.support.annotation.VisibleForTesting;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.usecase.Movie.MovieDataSource;
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

public class MovieDetailUseCase implements MovieDetailDataSource {
    private MovieDetailDataSource localDataSource;
    private MovieDetailDataSource remoteDataSource;
    @VisibleForTesting
    DetailResponse MovieDetailCache;


    @Inject
    public MovieDetailUseCase(@Remote MovieDetailDataSource remoteDataSource, @Local MovieDetailDataSource localDataSource)
    {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        MovieDetailCache =null;
    }
    @Override
    public Flowable<DetailResponse> loadMovieDetails(boolean isRemote, int MovieID)
    {
        if (isRemote)
        {
            return refreshDetailData(MovieID);
        } else {
            if (MovieDetailCache!=null)
            {
                // if cache is available, return it immediately
                return Flowable.just(MovieDetailCache);
            } else {
                return localDataSource.loadMovieDetails(false,MovieID).
                        filter(detailResponse -> detailResponse.getId()!=null)
                        .switchIfEmpty
                                (
                                        refreshDetailData(MovieID)
                                );
            }//else
        }//else
    }


    @Override
    public void addMovie(DetailResponse movie)
    {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    @Override
    public void clearDataByID(int id)
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

    private Flowable<DetailResponse> refreshDetailData(int MovieID )
    {
        return remoteDataSource.loadMovieDetails(true,MovieID).doOnNext
                (detailResponse ->
                        {
                            // Clear cache + set cache to  new data
                            MovieDetailCache= detailResponse;
                            // Clear data in local storage // and replace it with new data
                            localDataSource.addMovie(detailResponse);
                        }
                );
    }
}


