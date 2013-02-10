package com.moviesearch;

import android.app.Activity;
import android.os.Bundle;

public class MovieDetailsActivity extends Activity {

    private String selectedMovieId;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedMovieId = getIntent().getStringExtra(getString(R.string.SELECTED_MOVIE_ID));
    }
}