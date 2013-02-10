package com.moviesearch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class MovieListAdapter extends ArrayAdapter<Movie> {

    private static final Double GOOD_MOVIE_THRESHOLD = 80.0;
    private static final Double AVERAGE_MOVIE_THRESHOLD = 60.0;

    private final Context context;
    private final List<Movie> values;
    private URLReaderService urlReaderService;

    private Comparator<Movie> movieComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie movie, Movie movie2) {
            return movie.compareTo(movie2);
        }
    };

    public MovieListAdapter(Context context, List<Movie> values) {
        super(context, R.layout.movieresultrow, values);
        this.context = context;
        this.values = values;
        this.urlReaderService = new URLReaderService();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            Movie currentMovie = values.get(position);
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View resultRow = layoutInflater.inflate(R.layout.movieresultrow, parent, false);
            ImageView imageView = (ImageView) resultRow.findViewById(R.id.previewImage);

            Typeface customTypeface = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.CUSTOM_FONT_NAME));

            TextView titleHolder = (TextView) resultRow.findViewById(R.id.title);
            TextView yearHolder = (TextView) resultRow.findViewById(R.id.year);
            TextView ratingHolder = (TextView) resultRow.findViewById(R.id.rating);
            imageView.setBackgroundDrawable(urlReaderService.getDrawableFromURL(currentMovie.getThumbnailUrl()));
            titleHolder.setText(currentMovie.getTitle());
            titleHolder.setTypeface(customTypeface);
            yearHolder.setText(currentMovie.getYearOfRelease());
            yearHolder.setTypeface(customTypeface);
            ratingHolder.setText(currentMovie.getFormattedRating());
            ratingHolder.setTypeface(customTypeface);

            if(currentMovie.getCriticRating() > MovieListAdapter.GOOD_MOVIE_THRESHOLD) {
                ratingHolder.setTextColor(Color.GREEN);
            } else if (currentMovie.getCriticRating() > MovieListAdapter.AVERAGE_MOVIE_THRESHOLD) {
                ratingHolder.setTextColor(Color.YELLOW);
            } else {
                ratingHolder.setTextColor(Color.RED);
            }

            convertView = resultRow;
        } catch (IOException ex) {
            Log.e("EXCEPTION ", "      ", ex);
        }
        return convertView;
    }

    public Movie getMovie(int index) {
        return this.values.get(index);
    }

    public void sort() {
        super.sort(movieComparator);
    }

}
