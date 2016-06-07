package com.jormelcn.coursera.semaa3.petsmodels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jormelcn on 29/05/16.
 */
public class PetAdaptator extends RecyclerView.Adapter<PetAdaptator.PetViewHolder>{

    ArrayList<Pet> pets;
    boolean type;

    public PetAdaptator(ArrayList<Pet> pets, boolean type){
        super();
        this.pets = pets;
        this.type = type;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        pets.get(position).setHolder(holder, type);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder{
        ImageView petPicture;
        ImageView whiteBone;
        TextView petName;
        TextView  petRating;
        ImageView orangeBone;

        public PetViewHolder(View itemView) {
            super(itemView);
            petPicture = (ImageView) itemView.findViewById(R.id.petPicture);
            whiteBone = (ImageView) itemView.findViewById(R.id.whiteBone);
            petName = (TextView) itemView.findViewById(R.id.petName);
            petRating = (TextView) itemView.findViewById(R.id.petRating);
            orangeBone = (ImageView) itemView.findViewById(R.id.orangeBone);
        }
    }
}
