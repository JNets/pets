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
        this.id = id;
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

    public void setHolder(PetAdaptator.PetViewHolder holder, boolean type) {
        this.holder = holder;
        this.holder.petPicture.setImageResource(picture);
        this.holder.petRating.setText(String.valueOf(rating));
        this.holder.orangeBone.setImageResource(R.drawable.dog_bone_orange);
        if(type) {
            this.holder.petName.setText(name);
            this.holder.whiteBone.setImageResource(R.drawable.dog_bone);
            this.holder.whiteBone.setOnClickListener(new onLikeListener(this));
            this.holder.petPicture.setOnClickListener(new onPictureListener(this));
        }
        else {
            //this.holder.petPicture.setHeight( Math.round(this.holder.petPicture.getWidth() * 0.7f));
            //this.holder.petPicture.setHeight( 20);

            this.holder.whiteBone.setVisibility(View.INVISIBLE);
        }
    }

    public void addLike(){
        rating++;
        int i;
        for(i = 0; i < 4; i++){
            if(lastRating[i] == id)
                break;
        }

        for(int j = i; j > 0; j--){
            lastRating[j] = lastRating[j-1];
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
