package com.jormelcn.coursera.semaa3.petsmodels;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jormelcn on 5/06/16.
 */
public class PetsDetailFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.pet_detail_fragment, container, false);
        RecyclerView petGrid = (RecyclerView) view.findViewById(R.id.petGrid);
        ImageView profilePicture = (ImageView) view.findViewById(R.id.petProfilePicture);
        TextView profileName = (TextView) view.findViewById(R.id.petProfileName);

        profilePicture.setImageResource(PetsContainer.PET_PROFILE.getPicture());
        profileName.setText(PetsContainer.PET_PROFILE.getName());

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        petGrid.setLayoutManager(glm);

        PetAdaptator petAdaptator = new PetAdaptator(PetsContainer.PETS, false);
        petGrid.setAdapter(petAdaptator);

        return view;
    }
}
