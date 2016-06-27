package com.jormelcn.coursera.semaa3.petsmodels;

import com.jormelcn.coursera.semaa3.petsmodels.recyclerViewAdapter.PetDetailListAdapter;

/**
 * Created by jormelcn on 29/05/16.
 */
public class Pet {

    private String id;
    private String name;
    private String picture;
    private int rating;

    public Pet(String id, String name, String picture, int rating){
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.rating = rating;
    }

    public String getPicture() {
        return picture;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return  id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
