package com.app.mvvm_model.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.database.DetailsDao.DetailMovieConvertor;
import com.app.mvvm_model.data.database.DetailsDao.DetailMovieDao;
import com.app.mvvm_model.data.model.Movie;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Database(entities = {Movie.class,DetailResponse.class}, version = 4)
@TypeConverters({DetailMovieConvertor.class})
public abstract class OMDbDatabase extends RoomDatabase
{
    public abstract MovieDao movieDao();
    public abstract DetailMovieDao detailMovieDao();
}
