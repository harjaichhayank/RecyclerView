package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private ArrayList<ListProvider> arrayList;

    RecyclerAdapter(ArrayList<ListProvider> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerViewHolder recyclerViewHolder;
        if (viewType==TYPE_LIST){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
            recyclerViewHolder = new RecyclerViewHolder(view, viewType);
            return recyclerViewHolder;
        }
        else if (viewType==TYPE_HEAD){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_layout,parent,false);
            recyclerViewHolder = new RecyclerViewHolder(view, viewType);
            return recyclerViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        ListProvider listProvider;

        if (holder.view_type==TYPE_LIST){
            listProvider = arrayList.get(position -1);

            holder.MovieRatings.setText(listProvider.getRatings());
            holder.MovieNames.setText(listProvider.getName());
            holder.movieImage.setImageResource(listProvider.getImage_id());
        }
        else if(holder.view_type==TYPE_HEAD){
            holder.TextViewMovieImages.setText(R.string.Images);
            holder.TextViewMovieNames.setText(R.string.movieName);
            holder.TextViewMovieRatings.setText(R.string.Ratings);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size() + 1;
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        int view_type;

        //Variables for list
        ImageView movieImage;
        TextView MovieNames, MovieRatings;

        //Variables for Head Section
        TextView TextViewMovieImages, TextViewMovieNames, TextViewMovieRatings;

        RecyclerViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if (viewType==TYPE_LIST){
                movieImage = itemView.findViewById(R.id.movieImage);
                MovieNames = itemView.findViewById(R.id.movieName);
                MovieRatings = itemView.findViewById(R.id.movieRatings);
                view_type=1;
            }
            else if (viewType==TYPE_HEAD){
                TextViewMovieImages = itemView.findViewById(R.id.TextViewMovieImages);
                TextViewMovieNames = itemView.findViewById(R.id.TextViewMovieNames);
                TextViewMovieRatings = itemView.findViewById(R.id.TextViewMovieRatings);
                view_type=0;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return TYPE_HEAD;
        return TYPE_LIST;
    }
}
