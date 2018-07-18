package com.app.mvvm_model.data.api;

import com.app.mvvm_model.data.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andorid-win on 7/18/2018.
 */

public class MovieResponse {


    @SerializedName("totalResults")
    private String totalResults;
    @SerializedName("Response")
    private String Response;
    @SerializedName("Search")
    private List<Movie> Movies;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

    public List<Movie> getMovies() {
        return Movies;
    }

    public void setMovies(List<Movie> Search) {
        this.Movies = Search;
    }


}
