package com.app.mvvm_model.presentation.sup.MovieDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.app.mvvm_model.R;
import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.injection.moviedetails.DaggerMoviesDetailComponent;
import com.app.mvvm_model.injection.moviedetails.Extra_Data;
import com.app.mvvm_model.injection.moviedetails.MoviesDetailPresenterModule;
import com.app.mvvm_model.presentation.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailContract.View
{
    @Inject
    DetailPresenter presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);

        DaggerMoviesDetailComponent.builder()
                .extra_Data(new Extra_Data(233))
                .moviesDetailPresenterModule(new MoviesDetailPresenterModule(this))
                .movieDetailInteractorComponent(getMovieDetailInteractorComponent()).build().inject(DetailActivity.this);
        initUI();
    }

    private void initUI()
    {

    }

    @Override
    public void showMovie(DetailResponse data)
    {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNoDataMessage() {

    }

    @Override
    public void showErrorMessage(String error)
    {

    }
}
