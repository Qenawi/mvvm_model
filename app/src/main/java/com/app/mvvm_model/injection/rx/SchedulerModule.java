package com.app.mvvm_model.injection.rx;


import com.app.mvvm_model.rx.RunOn;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.app.mvvm_model.rx.SchedulerType.COMPUTATION;
import static com.app.mvvm_model.rx.SchedulerType.IO;
import static com.app.mvvm_model.rx.SchedulerType.UI;

/**
 * Created by Andorid-win on 7/18/2018.
 */


@Module
public class SchedulerModule
{
    @Provides
    @RunOn(IO)
    Scheduler provideIo(){
        return Schedulers.io();
    }

    @Provides
    @RunOn(COMPUTATION)
    Scheduler provideComputation() {
        return Schedulers.computation();
    }

    @Provides
    @RunOn(UI)
    Scheduler provideUi() {
        return AndroidSchedulers.mainThread();
    }
}
