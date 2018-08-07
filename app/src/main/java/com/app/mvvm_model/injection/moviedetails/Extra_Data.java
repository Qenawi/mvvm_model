package com.app.mvvm_model.injection.moviedetails;

import com.app.mvvm_model.presentation.sup.MovieDetail.DetailContract;

import dagger.Module;
import dagger.Provides;
@Module
public class Extra_Data
{
   int id;

    public Extra_Data(int id) {
        this.id = id;
    }

    @Provides
   int provideMovieID() {
        return id;
    }
}
