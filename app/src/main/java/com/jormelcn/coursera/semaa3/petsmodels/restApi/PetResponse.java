package com.jormelcn.coursera.semaa3.petsmodels.restApi;

import com.jormelcn.coursera.semaa3.petsmodels.Pet;

import java.util.ArrayList;

/**
 * Created by jormelcn on 26/06/16.
 */
public class PetResponse {
    ArrayList<Pet> pets;

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
