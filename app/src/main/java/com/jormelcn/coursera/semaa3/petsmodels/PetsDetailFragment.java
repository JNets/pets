package com.jormelcn.coursera.semaa3.petsmodels;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jormelcn on 5/06/16.
 */
public class PetsDetailFragment extends Fragment implements ProfileUpdater {


    View view;
    RecyclerView petGrid;
    FrameLayout profileCard;
    TextView profileName;
    ImageView profilePicture;
    TextView profileRating;
    ArrayList<Pet> dummyArray;
    PetAdapterGrid petAdaptator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.pet_detail_fragment, container, false);
        petGrid = (RecyclerView) view.findViewById(R.id.petGrid);
        FrameLayout profileHolder = (FrameLayout) view.findViewById(R.id.petProfileCard);
        profileCard = (FrameLayout) inflater.inflate(R.layout.pet_card, profileHolder);

        profileCard.setPadding(0, 0, 0, 0);
        //profileCard.setCardElevation(10);

        profileName = (TextView) profileCard.findViewById(R.id.petName);
        if(profileName != null){
            profileName.setText(PetsContainer.PET_PROFILE.getName());
        }
        profilePicture = (ImageView) profileCard.findViewById(R.id.petPicture);
        if(profilePicture != null){
            profilePicture.setImageResource(PetsContainer.PET_PROFILE.getPicture());
        }

        profileRating = (TextView) profileCard.findViewById(R.id.petRating);
        if(profileRating != null){
            profileRating.setText(String.valueOf(PetsContainer.PET_PROFILE.getRating()));
        }

        ImageView whiteBone = (ImageView) profileCard.findViewById(R.id.whiteBone);
        if(whiteBone != null){
            whiteBone.setImageResource(R.drawable.dog_bone);
        }

        ImageView orangeBone = (ImageView) profileCard.findViewById(R.id.orangeBone);
        if(orangeBone != null) {
            orangeBone.setImageResource(R.drawable.dog_bone_orange);
        }

        StaggeredGridLayoutManager slm = new StaggeredGridLayoutManager(3,1);
        petGrid.setLayoutManager(slm);

        dummyArray = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            dummyArray.add(PetsContainer.PET_PROFILE);
        }

        petAdaptator = new PetAdapterGrid(PetsContainer.PET_PROFILE, 50);
        petGrid.setAdapter(petAdaptator);

        return view;
    }

    @Override
    public void updateProfile() {
        profileName.setText(PetsContainer.PET_PROFILE.getName());
        profilePicture.setImageResource(PetsContainer.PET_PROFILE.getPicture());
        profileRating.setText(String.valueOf(PetsContainer.PET_PROFILE.getRating()));
        petAdaptator.updatePet(PetsContainer.PET_PROFILE);
        petAdaptator.notifyDataSetChanged();
        profilePicture.setMinimumHeight(200);
    }
}
