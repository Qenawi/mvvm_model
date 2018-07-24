package com.app.mvvm_model.presentation.sup.Movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.app.mvvm_model.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.imageView)
    ImageView src;
    @BindView(R.id.textView)
    TextView title;


    public MoviesViewHolder(View itemView)
    {
        super(itemView);
        ButterKnife.bind(this , itemView);
    }
}
