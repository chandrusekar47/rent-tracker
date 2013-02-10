package com.moviesearch;

public class Movie implements Comparable<Movie> {
    private String id;
    private String name;
    private Double criticRating;
    private String yearOfRelease;
    private String thumbnailUrl;

    public Movie(String id, String name, Double criticRating, String yearOfRelease, String thumbnailUrl) {
        this.id = id;
        this.name = name;
        this.criticRating = criticRating;
        this.yearOfRelease = yearOfRelease;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public Double getCriticRating() {
        return criticRating;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getFormattedRating() {
        return criticRating <= 0 ? "N/A" : criticRating.toString();
    }

    @Override
    public int compareTo(Movie movie) {
        return movie.getCriticRating().compareTo(this.criticRating);
    }
}
