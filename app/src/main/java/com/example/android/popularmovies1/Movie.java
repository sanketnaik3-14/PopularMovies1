package com.example.android.popularmovies1;

/**
 * Created by sanket on 21/07/17.
 */

public class Movie {

    private String mTitle;
    private String mReleaseDate;
    private String mImageUrl;
    private Double mRating;
    private String mPlot;

    public Movie()
    {

    }

    public Movie(String title, String releaseDate, String imageUrl, Double rating, String plot)
    {
        mTitle = title;
        mReleaseDate = releaseDate;
        mImageUrl = imageUrl;
        mRating = rating;
        mPlot = plot;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public Double getmRating() {
        return mRating;
    }

    public void setmRating(Double mRating) {
        this.mRating = mRating;
    }

    public String getmPlot() {
        return mPlot;
    }

    public void setmPlot(String mPlot) {
        this.mPlot = mPlot;
    }
}
