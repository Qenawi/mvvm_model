package com.app.mvvm_model.presentation.sup.Movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.mvvm_model.R;
import com.app.mvvm_model.data.model.Movie;
import com.app.mvvm_model.presentation.base.BaseRecyclerViewAdapter;
import com.app.mvvm_model.utils.Constants;
import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.security.InvalidParameterException;
import java.util.List;

import io.reactivex.annotations.NonNull;

import static com.app.mvvm_model.utils.Constants.INVALID_INDEX;


/**
 * Created by Ahmed Kamal on 21-11-2017.
 */

public class MoviesAdapter extends BaseRecyclerViewAdapter<MoviesViewHolder> {
    private List<Movie> movies;
    private Context c;

    public MoviesAdapter(@NonNull List<Movie> movies) {
        this.movies = movies;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.most_popular_item, parent, false);
        c = parent.getContext();
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        MoviesViewHolder MoviesViewHolder = (MoviesViewHolder) holder; //safe cast
        Movie movie = movies.get(position);
        OnBind(movie, MoviesViewHolder);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void replaceData(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public Movie getItem(int position) {
        if (position < 0 || position >= movies.size()) {
            throw new InvalidParameterException(INVALID_INDEX);
        }
        return movies.get(position);
    }

    public void clearData() {
        movies.clear();
        notifyDataSetChanged();
    }

    private void OnBind(Movie movie, MoviesViewHolder viewHolder)
    {
        RequestOptions myOptions = new RequestOptions().transforms(new FitCenter(),new RoundedCorners(10));
        viewHolder.title.setText(movie.getTitle());
        String Poster_Path= Constants.Movies.getImageBaseUrl("w500")+movie.getBackdropPath();
       Glide.with(c).load(Poster_Path).apply(myOptions).into(viewHolder.src);
    }
}
