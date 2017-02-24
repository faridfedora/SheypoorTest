package com.example.faridfedora.sheypoortest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.faridfedora.sheypoortest.Activity.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by faridfedora on 2/23/17.
 */

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewAdapter.MoviesViewHolder> {
    private List<MovieModel> movieModelList;
    private Context context;

    public MoviesRecyclerViewAdapter(Context context, List<MovieModel> movieModelList) {
        this.movieModelList=movieModelList;
        this.context=context;
    }

    @Override

    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        MoviesViewHolder moviesViewHolder=new MoviesViewHolder(view);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        MovieModel movieModel=movieModelList.get(position);
        String mediumImageUrl = movieModel.getImage().get("medium");

        Picasso.with(context).load(mediumImageUrl).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return movieModelList.size();
    }


    public class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public MoviesViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            MovieModel movieModel = movieModelList.get(getAdapterPosition());
//            Toast.makeText(context, ""+movieModel.getName(), Toast.LENGTH_SHORT).show();

            intent.putExtra("movieModel", movieModel);
            intent.putExtra("originalImage",movieModel.getImage().get("original"));
            intent.putExtra("rating",movieModel.getRating().get("average"));
            context.startActivity(intent);

        }
    }
}
