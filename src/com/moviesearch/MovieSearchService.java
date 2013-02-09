package com.moviesearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MovieSearchService {

    private final static String ROTTEN_TOMATO_API_KEY = "2zbvhp5vmxj6ry2ah8wsye7b";
    public final static String ROTTEN_TOMATO_URL = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" + ROTTEN_TOMATO_API_KEY;

    public List<Movie> searchMovieByName(String movieName) throws IOException, JSONException {
        URL searchURL = new URL(ROTTEN_TOMATO_URL + "&q=" + URLEncoder.encode(movieName));
        JSONObject output = new URLReaderService().readJSON(searchURL);
        List<Movie> movieList = new ArrayList<Movie>();
        JSONArray movieJsonArray = output.getJSONArray("movies");
        for (int i = 0; i < movieJsonArray.length(); i++) {
            JSONObject movie = movieJsonArray.getJSONObject(i);
            movieList.add(new Movie(movie.getString("title"), movie.getJSONObject("ratings").getDouble("critics_score"), movie.get("year").toString(), movie.getJSONObject("posters").getString("thumbnail")));
        }
        return movieList;
    }

}
