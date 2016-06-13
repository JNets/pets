package com.jormelcn.coursera.semaa3.petsmodels;

//import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class PetsList extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_list);

        BaseDatos db = new BaseDatos(this);
        ArrayList<Pet> pets = db.getPetsLikes();
        //db.addPets(PetsContainer.PETS);
        /*for(int i = 0; i < 5; i++) {
            db.addLike(1);
        }*/

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.dog_paw);


        PetsDetailFragment petsDetailFragment = new PetsDetailFragment();
        PetListFragment petListFragment = PetListFragment.newInstance(viewPager, petsDetailFragment);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(petListFragment);
        fragments.add(petsDetailFragment);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);
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
            case R.id.lastLikes_option:
                intent = new Intent(this,LikesActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
