package com.app.mvvm_model.presentation.sup.Movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.app.mvvm_model.R;


import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.injection.movie.DaggerMoviesComponent;
import com.app.mvvm_model.injection.movie.MoviesPresenterModule;
import com.app.mvvm_model.presentation.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MoviesActivity extends BaseActivity implements MoviesContract.View {


    @BindView(R.id.popular_rv)
    RecyclerView recyclerView;
    private MoviesAdapter adapter;
    
    @Inject
    MoviesPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);
        ButterKnife.bind(this);
        DaggerMoviesComponent.builder()
                .moviesPresenterModule(new MoviesPresenterModule(this))
                .movieInteractorComponent(getMovieInteractorComponent()).build().inject(MoviesActivity.this);
        initUI();
    }

    private void initUI()
    {
        // Setup recycler view
        adapter = new MoviesAdapter(new ArrayList<>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(
                (view, position) -> showNotification(position+""));
    }


    @Override
    public void showMovies(List<Movie> list) {
        adapter.replaceData(list);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void clearMovies() {
        adapter.clearData();
    }

    @Override
    public void showNoDataMessage()
    {
showNotification("NO DATA PLZ RELOAD APP :D");
    }

    @Override
    public void showErrorMessage(String error) {
        showNotification(error);
    }

    private void showNotification(String message)
    {
Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
