package com.example.android.popularmovies1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sanket on 20/07/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesAdapterViewHolder>{

    private List<Movie> mMoviesList;
    Context mContext;
    private final MoviesAdapterOnClickHandler mClickHandler;

    public MoviesAdapter(Context context, MoviesAdapterOnClickHandler clickHandler,List<Movie> moviesList)
    {
        mContext = context;
        mClickHandler = clickHandler;
        mMoviesList = moviesList;

    }

    public interface MoviesAdapterOnClickHandler
    {
        void onClick(String title, String releaseDate, String imageUrl, Double rating, String plot);
    }

    public class MoviesAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public final ImageView mMoviesImageView;

        public MoviesAdapterViewHolder(View view)
        {
            super(view);
            mMoviesImageView = view.findViewById(R.id.iv_movie);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int adapterPosition = getAdapterPosition();
            Movie movie = mMoviesList.get(adapterPosition);
            String mTitle = movie.getmTitle();
            String mReleaseDate = movie.getmReleaseDate();
            String mImageUrl = movie.getmImageUrl();
            Double mRating = movie.getmRating();
            String mPlot = movie.getmPlot();

            mClickHandler.onClick(mTitle,mReleaseDate,mImageUrl,mRating,mPlot);

        }
    }

    @Override
    public MoviesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.movies_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new MoviesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapterViewHolder holder, int position) {

        Movie movie = mMoviesList.get(position);
        String imageName = movie.getmImageUrl();
        imageName = imageName.replace("/","");

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("image.tmdb.org")
                .appendPath("t")
                .appendPath("p")
                .appendPath("w185")
                .appendPath(imageName);

        String url = builder.build().toString();
        Picasso.with(mContext)
                .load(url)
                .into(holder.mMoviesImageView);

    }

    @Override
    public int getItemCount() {
        if(mMoviesList == null) {
            return 0;
        }
        return mMoviesList.size();

    }

    public void setMovieData(List<Movie> movieList) {
        mMoviesList = movieList;
        notifyDataSetChanged();
    }


}
