package com.app.mvvm_model.presentation.sup.Movies;

import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.presentation.base.BasePresenter;

import java.util.List;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public interface MoviesContract {
    interface View {
        void showMovies(List<Movie>list);

        void hideLoading();

        void clearMovies();
        void showNoDataMessage();
        void showErrorMessage(String error);
    }

    interface Presenter extends BasePresenter<View>
    {
        void loadMovies(boolean onlineRequired);

        void search(String MovieTitle);

    }
}
