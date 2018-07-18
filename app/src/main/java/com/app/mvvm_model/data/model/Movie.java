package com.app.mvvm_model.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.app.mvvm_model.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andorid-win on 7/18/2018.
 */
@Entity(tableName = Constants.MOVIES_TABLE_NAME)

public class Movie {


    @SerializedName("Title")
    private String Title;
    @SerializedName("Year")
    private String Year;
    @SerializedName("imdbID")
    @PrimaryKey
    @android.support.annotation.NonNull
    private String imdbID="0";
    @SerializedName("Type")
    private String Type;
    @SerializedName("Poster")
    private String Poster;

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String Poster) {
        this.Poster = Poster;
    }
}
