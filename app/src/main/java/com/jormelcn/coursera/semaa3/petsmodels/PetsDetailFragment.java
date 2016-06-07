package com.jormelcn.coursera.semaa3.petsmodels;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jormelcn on 5/06/16.
 */
public class PetsDetailFragment extends Fragment {


    View view;
    RecyclerView petGrid;
    ImageView profilePicture;
    TextView profileName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.pet_detail_fragment, container, false);
        petGrid = (RecyclerView) view.findViewById(R.id.petGrid);
        profilePicture = (ImageView) view.findViewById(R.id.petProfilePicture);
        profileName = (TextView) view.findViewById(R.id.petProfileName);
        profilePicture.setImageResource(PetsContainer.PET_PROFILE.getPicture());
        profileName.setText(PetsContainer.PET_PROFILE.getName());

        StaggeredGridLayoutManager slm = new StaggeredGridLayoutManager(3,1);
        petGrid.setLayoutManager(slm);

        PetAdaptator petAdaptator = new PetAdaptator(PetsContainer.PETS, false);
        petGrid.setAdapter(petAdaptator);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
