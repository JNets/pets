package com.jormelcn.coursera.semaa3.petsmodels.recyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jormelcn.coursera.semaa3.petsmodels.Pet;
import com.jormelcn.coursera.semaa3.petsmodels.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jormelcn on 12/06/16.
 */
public class PetAdapterGrid extends RecyclerView.Adapter<PetAdapterGrid.GridViewHolder> {

    private ArrayList<Pet> pets;
    private Context context;
    public PetAdapterGrid(ArrayList<Pet> pets, Context context){
        this.pets = pets;
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_pet_likes,parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {

        //holder.petPicture.setImageResource(pets.get(position).getPicture());
        Picasso.with(context).load(pets.get(position).getPicture()).into(holder.petPicture);
        holder.petRating.setText(String.valueOf(pets.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder{

        ImageView petPicture;
        TextView  petRating;

        public GridViewHolder(View itemView) {
            super(itemView);
            petPicture = (ImageView) itemView.findViewById(R.id.petPicture);
            petRating = (TextView) itemView.findViewById(R.id.petRating);
        }
    }
}
