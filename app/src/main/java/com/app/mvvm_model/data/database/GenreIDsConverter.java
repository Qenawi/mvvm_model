package com.app.mvvm_model.data.database;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenreIDsConverter
{
    /*
    Room Can only Store premative
     */
    @TypeConverter
    public List<Integer> ListFromString(String myList) {
        if (myList == null || TextUtils.isEmpty(myList)) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Integer>>() {
        }.getType();

        return gson.fromJson(myList, type);
    }

    @TypeConverter
    public String ListToString(List<Integer> myList) {
        if (myList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        return gson.toJson(myList, type);
    }


}
