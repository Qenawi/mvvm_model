package com.app.mvvm_model.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.utils.Constants;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Dao
public interface MovieDao
{
    @Query("SELECT * FROM " + Constants.MOVIES_TABLE_NAME)
    Flowable<List<Movie>> getAllMovies();

    @Query("SELECT * FROM " + Constants.MOVIES_TABLE_NAME + " WHERE id == :id")
    Flowable<Movie> getMovieById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movie movie);

    @Query("DELETE FROM " + Constants.MOVIES_TABLE_NAME)
    void deleteAll();
}
