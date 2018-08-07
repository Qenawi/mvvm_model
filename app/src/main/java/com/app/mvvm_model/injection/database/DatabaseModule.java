package com.app.mvvm_model.injection.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.app.mvvm_model.data.database.DetailsDao.DetailMovieDao;
import com.app.mvvm_model.data.database.MovieDao;
import com.app.mvvm_model.data.database.OMDbDatabase;
import com.app.mvvm_model.utils.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Module
public class DatabaseModule
{
    private static final String DATABASE = "database_name";

    @Provides
    @Named(DATABASE)
    String provideDatabaseName() {
        return Constants.DATABASE_NAME;
    }

    @Provides
    @Singleton
    OMDbDatabase provideOMDbDao(Context context, @Named(DATABASE) String databaseName)
    {
        return Room.databaseBuilder(context, OMDbDatabase.class, databaseName).build();
    }
    @Provides
    @Singleton
    MovieDao provideMovieDao(OMDbDatabase OMDbDb)
    {
        return OMDbDb.movieDao();
    }
    @Provides
    @Singleton
    DetailMovieDao provideDetailMovieDao(OMDbDatabase OMDbDb)
    {
        return OMDbDb.detailMovieDao();
    }
}
