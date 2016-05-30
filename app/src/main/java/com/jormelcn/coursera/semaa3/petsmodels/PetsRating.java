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
        PetAdaptator adaptator = new PetAdaptator(pets);



        RecyclerView ratingList = (RecyclerView) findViewById(R.id.petRatingList);
        ratingList.setLayoutManager(llm);
        ratingList.setAdapter(adaptator);

        Bundle extras = getIntent().getExtras();

        int [] rating = extras.getIntArray("rating");

    }
}
