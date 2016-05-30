package com.jormelcn.coursera.semaa3.petsmodels;

import android.view.View;

/**
 * Created by jormelcn on 29/05/16.
 */
public class onLikeListener implements View.OnClickListener {

    Pet pet;

    public onLikeListener(Pet pet){
        this.pet = pet;
    }

    @Override
    public void onClick(View v) {
        pet.addLike();
    }
}
