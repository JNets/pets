package com.jormelcn.coursera.semaa3.petsmodels;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class LikesActivity extends AppCompatActivity {

    Toolbar toolbar;
    private BaseDatos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        RecyclerView petList = (RecyclerView) findViewById(R.id.petList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);

        db = new BaseDatos(this);
        PetAdaptator2 petAdaptator = new PetAdaptator2(db.getPetsLikes());
        petList.setAdapter(petAdaptator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto_option:
                intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.about_option:
                intent = new Intent(this,BioActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
