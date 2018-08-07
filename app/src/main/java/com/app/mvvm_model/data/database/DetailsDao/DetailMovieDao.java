package com.app.mvvm_model.data.database.DetailsDao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.utils.Constants;

import java.util.List;

import io.reactivex.Flowable;
@Dao
public interface DetailMovieDao
{

    @Query("SELECT * FROM " + Constants.MOVIES_TABLE_NAME_DETAILS + " WHERE id == :id")
    Flowable<DetailResponse> getMovieById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DetailResponse movie);

    @Query("DELETE FROM " + Constants.MOVIES_TABLE_NAME_DETAILS + " WHERE id ==:id ")
    void deleteById(int id);

    @Query("DELETE FROM " + Constants.MOVIES_TABLE_NAME_DETAILS)
    void deleteAll();
}
