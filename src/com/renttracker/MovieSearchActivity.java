package com.renttracker;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class MovieSearchActivity extends Activity {

    private ArrayAdapter<String> arrayAdapter;
    private EditText searchTextBox;
    private ImageButton searchButton;
    private Activity activityContext;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviesearch);
        activityContext = this;
        searchButton = (ImageButton) findViewById(R.id.searchButton);
        searchTextBox = (EditText) findViewById(R.id.searchInput);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ((ListView)findViewById(R.id.resultsHolder)).setAdapter(arrayAdapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable text = searchTextBox.getText();
                new AsyncTask<String, Integer, String>() {
                    @Override
                    protected String doInBackground(String... strings) {
                        return "";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        Log.e("response : ", s);
                        try {
                            JSONArray jsonArray = new JSONObject(s).getJSONArray("movies");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                arrayAdapter.add(jsonArray.getJSONObject(i).getString("title"));
                            }
                            arrayAdapter.notifyDataSetInvalidated();
                        } catch (JSONException e) {
                            Log.e("Json parsing", "", e);
                        }
                    }
                }.execute(text.toString());
            }
        });
    }
}