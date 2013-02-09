package com.renttracker;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieSearchActivity extends Activity {

    private MovieListAdapter movieListAdapter;
    private EditText searchTextBox;
    private ImageButton searchButton;
    private Activity activityContext;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviesearch);
        activityContext = this;
        searchButton = (ImageButton) findViewById(R.id.searchButton);
        searchTextBox = (EditText) findViewById(R.id.searchInput);
        movieListAdapter = new MovieListAdapter(this, new ArrayList<Movie>());
        ((ListView) findViewById(R.id.resultsHolder)).setAdapter(movieListAdapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable text = searchTextBox.getText();
                new AsyncTask<String, Integer, List<Movie>>() {
                    @Override
                    protected List<Movie> doInBackground(String... strings) {
                        try {
                            return new MovieSearchService().searchMovieByName(strings[0]);
                        } catch (IOException e) {
                            Log.e("Exception", "", e);
                        } catch (JSONException e) {
                            Log.e("Exception", "", e);
                        }
                        return new ArrayList<Movie>();
                    }

                    @Override
                    protected void onPostExecute(List<Movie> movieList) {
                        movieListAdapter.clear();
                        for(Movie movie:movieList) {
                            movieListAdapter.add(movie);
                        }
                        movieListAdapter.sort();
                        movieListAdapter.notifyDataSetChanged();
                    }

                }.execute(text.toString());
            }
        });
    }
}