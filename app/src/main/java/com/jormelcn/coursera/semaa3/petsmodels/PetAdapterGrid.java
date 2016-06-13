package com.jormelcn.coursera.semaa3.petsmodels;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jormelcn on 12/06/16.
 */
public class PetAdapterGrid extends RecyclerView.Adapter<PetAdapterGrid.GridViewHolder> {

    private Pet pet;
    private int size;

    public PetAdapterGrid(Pet pet, int size){
        this.pet = pet;
        this.size = size;
    }

    public void updatePet(Pet pet){
        this.pet = pet;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card_grid,parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {

        holder.petPicture.setImageResource(pet.getPicture());
        holder.petRating.setText(String.valueOf(pet.getRating()));
    }

    @Override
    public int getItemCount() {
        return size;
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
