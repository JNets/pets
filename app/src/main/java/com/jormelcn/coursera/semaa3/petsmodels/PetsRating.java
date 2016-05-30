package com.jormelcn.coursera.semaa3.petsmodels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PetsRating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_rating);

        Button upButton = (Button) findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goUp = new Intent(getApplicationContext(), PetsList.class);
                startActivity(goUp);
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet(R.drawable.copito, "Copito", 1));
        pets.add(new Pet(R.drawable.dominic, "Dominic", 2));
        pets.add(new Pet(R.drawable.kirara, "Kirara", 3));
        pets.add(new Pet(R.drawable.lucky, "Lucky", 4));
        pets.add(new Pet(R.drawable.paco_y_pina, "Paco y Pina", 5));
        pets.add(new Pet(R.drawable.patricio, "Patricio", 6));
        pets.add(new Pet(R.drawable.scoth, "Scoth", 7));
        pets.add(new Pet(R.drawable.snoopy, "Snoopy", 8));
        pets.add(new Pet(R.drawable.toreto, "Toreto", 9));

        ArrayList<Pet> lastPetRating = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        int [] rating = extras.getIntArray("rating");

        for(int i = 0; i < 5; i++) {
            lastPetRating.add(pets.get(rating[i - 1]));
        }

        PetAdaptator adaptator = new PetAdaptator(lastPetRating);
        RecyclerView ratingList = (RecyclerView) findViewById(R.id.petRatingList);
        ratingList.setLayoutManager(llm);
        ratingList.setAdapter(adaptator);
    }
}
