package com.app.mvvm_model.presentation.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public abstract class BaseActivity extends AppCompatActivity
{
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
