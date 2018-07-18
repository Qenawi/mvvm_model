package com.app.mvvm_model.presentation.sup.Movies;

import com.app.mvvm_model.presentation.base.BasePresenter;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public interface MoviesContract {
    interface View {
        void showMovies();

        void hideLoading();

        void clearMovies();
    }

    interface Presenter extends BasePresenter<View>
    {
        void loadMovies(boolean onlineRequired);

        void search(String MovieTitle);

    }
}
