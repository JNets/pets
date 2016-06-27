package com.jormelcn.coursera.semaa3.petsmodels.activity;

//import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jormelcn.coursera.semaa3.petsmodels.PageAdapter;
import com.jormelcn.coursera.semaa3.petsmodels.Pet;
import com.jormelcn.coursera.semaa3.petsmodels.Presenter.Presenter;
import com.jormelcn.coursera.semaa3.petsmodels.R;
import com.jormelcn.coursera.semaa3.petsmodels.fragment.PicturesListFragment;
import com.jormelcn.coursera.semaa3.petsmodels.fragment.ProfileFragment;

import java.util.ArrayList;

public class PetsPictures extends AppCompatActivity implements PicturesListFragment.OnEventsListener, Presenter.MyView{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PicturesListFragment picturesListFragment;
    ProfileFragment profileFragment;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_list);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.dog_paw);

        picturesListFragment = PicturesListFragment.newInstance(this);
        profileFragment = ProfileFragment.newInstance();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(picturesListFragment);
        fragments.add(profileFragment);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        presenter = new Presenter(this);
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
                intent = new Intent(this, DeveloperContact.class);
                startActivity(intent);
                break;
            case R.id.about_option:
                intent = new Intent(this,DeveloperBio.class);
                startActivity(intent);
                break;
            case R.id.lastLikes_option:
                //intent = new Intent(this,RecentLikes.class);
                //startActivity(intent);
                break;
            case R.id.initDb_option:
                //profileFragment.updateProfile(PetsContainer.get(1), PetsContainer.PETS);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPictureSelected(int pictureId) {

    }

    @Override
    public void onAddLike(int petId) {

    }

    @Override
    public void mostrarPetList(ArrayList<Pet> pets) {
        picturesListFragment.setPetsList(pets);
    }
}
