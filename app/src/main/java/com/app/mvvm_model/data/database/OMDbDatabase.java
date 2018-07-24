package com.app.mvvm_model.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.app.mvvm_model.data.model.Movie;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Database(entities = Movie.class, version = 2)
public abstract class OMDbDatabase extends RoomDatabase
{
    public abstract MovieDao movieDao();
}
