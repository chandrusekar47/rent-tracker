package com.renttracker;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.Arrays;

public class MovieSearchActivity extends Activity {
    private ArrayAdapter<String> arrayAdapter;
    private AsyncTask<String, Integer, String> movieSearchAsyncTask;
    private EditText searchTextBox ;
    private ImageButton searchButton;
    private Activity activityContext;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviesearch);
        activityContext = this;
        searchButton = (ImageButton) findViewById(R.id.searchButton);
        searchTextBox =  (EditText) findViewById(R.id.searchInput);
        movieSearchAsyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                Log.e(MainActivity.class.getName(), "background " + Thread.currentThread().getName() + " ARGS: " + Arrays.deepToString(strings));
                return "DummyOutput";
            }

            @Override
            protected void onPreExecute() {
                Toast.makeText(activityContext, "preExecute ThreadName: " + Thread.currentThread().getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(activityContext, "postExecute ThreadName: " + Thread.currentThread().getName() + " result: "+s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        };

        final AsyncTask<String, Integer, String> secondAsyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                Log.e(MainActivity.class.getName(), "background " + Thread.currentThread().getName() + " ARGS: " + Arrays.deepToString(strings));
                return "DummyOutput";
            }

            @Override
            protected void onPreExecute() {
                Toast.makeText(activityContext, "preExecute ThreadName: " + Thread.currentThread().getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(activityContext, "postExecute ThreadName: " + Thread.currentThread().getName() + " result: "+s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        };

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable text = searchTextBox.getText();
                movieSearchAsyncTask.execute(text.toString());
                secondAsyncTask.execute(text.toString());
            }
        });
    }
}