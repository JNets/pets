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
import java.util.Collections;

public class PetsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_list);

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //miActionBar.setTitle("Pets");
        //miActionBar.setLogo(R.drawable.animal_paw_print);
        //setSupportActionBar(miActionBar);

        Button starButton = (Button) findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goRating = new Intent(getApplicationContext(), PetsRating.class);
                goRating.putExtra("rating", Pet.lastRating);
                startActivity(goRating);
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


        PetAdaptator adaptator = new PetAdaptator(pets);

        RecyclerView petList = (RecyclerView) findViewById(R.id.petList);
        petList.setLayoutManager(llm);
        petList.setAdapter(adaptator);
    }
}
