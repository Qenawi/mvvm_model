package com.app.mvvm_model.utils;

import android.text.format.DateUtils;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class DateTimeUtils
{
    public static String formatRelativeTime(long time)
    {
        return DateUtils.getRelativeTimeSpanString(time * 1000, System.currentTimeMillis(),
                DateUtils.MINUTE_IN_MILLIS).toString();
    }
}
