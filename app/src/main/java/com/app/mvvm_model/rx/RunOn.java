package com.app.mvvm_model.rx;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Andorid-win on 7/18/2018.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RunOn
{
    SchedulerType value() default SchedulerType.IO;
}
