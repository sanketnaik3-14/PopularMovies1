package com.example.android.popularmovies1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private ImageView movieImage;
    private TextView titleTextView;
    private TextView ratingTextView;
    private TextView releaseTextView;
    private TextView plotTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String releaseDate = intent.getStringExtra("releaseDate");
        String imageUrl = intent.getStringExtra("imageUrl");
        imageUrl = imageUrl.replace("/","");
        String rating = String.valueOf(intent.getDoubleExtra("rating", 0.0));
        String plot = intent.getStringExtra("plot");

        movieImage = (ImageView)findViewById(R.id.iv_details_image);
        titleTextView = (TextView)findViewById(R.id.tv_details_title);
        ratingTextView = (TextView)findViewById(R.id.tv_details_rating);
        releaseTextView = (TextView)findViewById(R.id.tv_details_release);
        plotTextView = (TextView)findViewById(R.id.tv_details_plot);



        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("image.tmdb.org")
                .appendPath("t")
                .appendPath("p")
                .appendPath("w185")
                .appendPath(imageUrl);

        String url = builder.build().toString();
        Picasso.with(this)
                .load(url)
                .into(movieImage);

        titleTextView.setText(title);
        ratingTextView.setText(rating);
        releaseTextView.setText(releaseDate);
        plotTextView.setText(plot);
    }
}
