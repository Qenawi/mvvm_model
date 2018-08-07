package com.app.mvvm_model.presentation.sup.MovieDetail;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.presentation.base.BasePresenter;
import com.app.mvvm_model.presentation.sup.Movies.MoviesContract;

import java.util.List;

public interface DetailContract
{
    interface View {
        void showMovie(DetailResponse data);
        void hideLoading();
        void showLoading();
        void showNoDataMessage();
        void showErrorMessage(String error);
    }
    interface Presenter extends BasePresenter<DetailContract.View>
    {
        void loadMovie(boolean onlineRequired);
    }
}
