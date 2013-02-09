package com.renttracker;

import android.graphics.drawable.Drawable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLReaderService {

    public JSONObject readJSON(URL url) throws IOException, JSONException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        return new JSONObject((stringBuilder.toString()));
    }

    public Drawable getDrawableFromURL(String url) throws IOException {
        return Drawable.createFromStream((InputStream)new URL(url).getContent(), url);
    }

}
