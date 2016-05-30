package com.jormelcn.coursera.semaa3.petsmodels;

import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by jormelcn on 29/05/16.
 */
public class Pet implements Comparable<Pet>{
    private int picture;
    private String name;
    private int id;
    private int rating;
    private PetAdaptator.PetViewHolder holder;

    public static int[] lastRating = new int[5];

    public Pet(int picture, String name, int id){
        if(lastRating[0] == 0){
            for(int i = 0; i < 5; i++){
                lastRating[i] = i + 1;
            }
        }
        this.picture = picture;
        this.name = name;
        this.rating = 0;
    }

    public int getPicture() {
        return picture;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return  id;
    }

    public void setHolder(PetAdaptator.PetViewHolder holder) {
        this.holder = holder;
        this.holder.petPicture.setBackgroundResource(picture);
        this.holder.petRating.setText(String.valueOf(rating));
        this.holder.petName.setText(name);
        this.holder.orangeBone.setImageResource(R.drawable.dog_bone_orange);
        this.holder.whiteBone.setBackgroundResource(R.drawable.dog_bone);
        this.holder.whiteBone.setOnClickListener(new onLikeListener(this));
    }

    public void addLike(){
        rating++;
        for(int i = 4; i > 0; i--){
            lastRating[i] = lastRating[i-1];
        }
        lastRating[0] = id;

        holder.petRating.setText(String.valueOf(rating));
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Pet another) {
        if(this.rating >  another.rating)
            return 1;
        else if(this.rating < another.rating)
            return -1;
        return 0;
    }
}
