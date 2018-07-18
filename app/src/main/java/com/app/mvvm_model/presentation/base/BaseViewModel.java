package com.app.mvvm_model.presentation.base;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public final class BaseViewModel<V ,P extends BasePresenter<V>> extends ViewModel
{

    private P presenter;

    void setPresenter(P presenter) {
        if (this.presenter == null) {
            this.presenter = presenter;
        }
    }

    P getPresenter() {
        return this.presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        //presenter.onPresenterDestroy();
        presenter = null;
    }
}
