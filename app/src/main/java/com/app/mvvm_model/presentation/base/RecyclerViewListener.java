package com.app.mvvm_model.presentation.base;

import android.view.View;

/**
 * Created by Ahmed Kamal on 21-11-2017.
 */

public interface RecyclerViewListener
{
    @FunctionalInterface
    interface OnItemClickListener
    {
        void OnItemClick(View view, int position);
    }

    @FunctionalInterface
    interface OnItemLongClickListener
    {
        void OnItemLongClick(View view, int position);
    }
}
