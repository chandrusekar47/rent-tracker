package com.renttracker;

public class Movie {
    private String name;
    private String directorName;
    private String yearOfRelease;
    private String thumbnailUrl;

    public Movie(String name, String directorName, String yearOfRelease, String thumbnailUrl) {
        this.name = name;
        this.directorName = directorName;
        this.yearOfRelease = yearOfRelease;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getName() {
        return name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
