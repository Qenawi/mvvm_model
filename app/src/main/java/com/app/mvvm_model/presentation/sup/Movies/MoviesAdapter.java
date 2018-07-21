package com.app.mvvm_model.presentation.sup.Movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.mvvm_model.R;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.presentation.base.BaseRecyclerViewAdapter;
import com.app.mvvm_model.utils.DateTimeUtils;

import java.security.InvalidParameterException;
import java.util.List;


import io.reactivex.annotations.NonNull;

import static com.app.mvvm_model.utils.Constants.INVALID_INDEX;


/**
 * Created by Ahmed Kamal on 21-11-2017.
 */

public class MoviesAdapter extends BaseRecyclerViewAdapter<MoviesViewHolder>
{
    private List<Movie> movies;

    public MoviesAdapter(@NonNull List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        super.onBindViewHolder(holder, position);
        MoviesViewHolder MoviesViewHolder = (MoviesViewHolder) holder; //safe cast
        Movie movie = movies.get(position);
        MoviesViewHolder.titleText.setText(movie.getTitle());
        MoviesViewHolder.userText.setText(movie.getTitle());
        MoviesViewHolder.createdTimeText.setText(movie.getYear());
    }

    @Override
    public int getItemCount()
    {
        return movies.size();
    }

    public void replaceData(List<Movie> movies)
    {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public Movie getItem(int position)
    {
        if (position < 0 || position >= movies.size())
        {
            throw new InvalidParameterException(INVALID_INDEX);
        }
        return movies.get(position);
    }

    public void clearData()
    {
        movies.clear();
        notifyDataSetChanged();
    }
}
