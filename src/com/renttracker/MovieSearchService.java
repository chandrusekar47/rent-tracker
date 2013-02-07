package com.renttracker;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

public class MovieSearchService {

    private final static String ROTTEN_TOMATO_API_KEY = "2zbvhp5vmxj6ry2ah8wsye7b";
    public final static String ROTTEN_TOMATO_URL = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" + ROTTEN_TOMATO_API_KEY;

    public List<Movie> searchMovieByName(String movieName) {

        return jsonOutput.toString();
    }

}
