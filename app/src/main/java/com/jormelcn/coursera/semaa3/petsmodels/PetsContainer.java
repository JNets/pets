package com.jormelcn.coursera.semaa3.petsmodels;

import java.util.ArrayList;

/**
 * Created by jormelcn on 5/06/16.
 */
public class PetsContainer {

    public static ArrayList<Pet> PETS = new ArrayList<Pet>(){
        {
            add(new Pet(R.drawable.copito, "Copito", 1));
            add(new Pet(R.drawable.dominic, "Dominic", 2));
            add(new Pet(R.drawable.kirara, "Kirara", 3));
            add(new Pet(R.drawable.lucky, "Lucky", 4));
            add(new Pet(R.drawable.paco_y_pina, "Paco y Pina", 5));
            add(new Pet(R.drawable.patricio, "Patricio", 6));
            add(new Pet(R.drawable.scoth, "Scoth", 7));
            add(new Pet(R.drawable.snoopy, "Snoopy", 8));
            add(new Pet(R.drawable.toreto, "Toreto", 9));
        }
    };

    public static Pet PET_PROFILE = new Pet(R.drawable.copito, "Copito", 1);

    public static Pet get(int id){
        return PETS.get(id);
    }

    public static int size(){
        return PETS.size();
    }
}
