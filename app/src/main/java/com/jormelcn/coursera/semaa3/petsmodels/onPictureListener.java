package com.jormelcn.coursera.semaa3.petsmodels;

import android.view.View;

/**
 * Created by jormelcn on 6/06/16.
 */
public class onPictureListener implements View.OnClickListener {

    private Pet pet;

    public onPictureListener(Pet pet){
        this.pet = pet;
    }

    @Override
    public void onClick(View v) {
        PetsContainer.PET_PROFILE = pet;
    }
}
