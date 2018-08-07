package com.app.mvvm_model.data.database.DetailsDao;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import com.app.mvvm_model.data.api.DetailMovie.DetailResponse;
import com.app.mvvm_model.data.model.Genre;
import com.app.mvvm_model.data.model.ProductionCompany;
import com.app.mvvm_model.data.model.ProductionCountry;
import com.app.mvvm_model.data.model.SpokenLanguage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DetailMovieConvertor
{
    /*
    Room Can only Store premative
     */
    @TypeConverter
    public List<Genre> ListFromStringGenre(String myList) {
        if (myList == null || TextUtils.isEmpty(myList)) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Genre>>() {
        }.getType();

        return gson.fromJson(myList, type);
    }

    @TypeConverter
    public String ListToStringGenre(List<Genre> myList) {
        if (myList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Genre>>() {
        }.getType();
        return gson.toJson(myList, type);
    }
    //-------------------------------------------------------------
    @TypeConverter
    public List<ProductionCompany> ListFromStringProductionCompany(String myList) {
        if (myList == null || TextUtils.isEmpty(myList)) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ProductionCompany>>() {
        }.getType();

        return gson.fromJson(myList, type);
    }

    @TypeConverter
    public String ListToStringProductionCompany(List<ProductionCompany> myList) {
        if (myList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ProductionCompany>>() {
        }.getType();
        return gson.toJson(myList, type);
    }
    //----------------------------------------------------------------------
    @TypeConverter
    public List<ProductionCountry> ListFromStringProductionCountry(String myList) {
        if (myList == null || TextUtils.isEmpty(myList)) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ProductionCountry>>() {
        }.getType();

        return gson.fromJson(myList, type);
    }

    @TypeConverter
    public String ListToStringProductionCountry(List<ProductionCountry> myList)
    {
        if (myList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ProductionCountry>>() {
        }.getType();
        return gson.toJson(myList, type);
    }

//-------------------------------------------------------------------------------------
@TypeConverter
public List<SpokenLanguage> ListFromStringSpokenLanguage(String myList)
{
    if (myList == null || TextUtils.isEmpty(myList)) {
        return null;
    }
    Gson gson = new Gson();
    Type type = new TypeToken<ArrayList<SpokenLanguage>>() {
    }.getType();

    return gson.fromJson(myList, type);
}

    @TypeConverter
    public String ListToStringSpokenLanguage(List<SpokenLanguage> myList)
    {
        if (myList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SpokenLanguage>>() {
        }.getType();
        return gson.toJson(myList, type);
    }
}
