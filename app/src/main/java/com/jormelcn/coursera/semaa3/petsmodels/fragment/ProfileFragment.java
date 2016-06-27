package com.jormelcn.coursera.semaa3.petsmodels.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jormelcn.coursera.semaa3.petsmodels.Pet;
import com.jormelcn.coursera.semaa3.petsmodels.recyclerViewAdapter.PetAdapterGrid;
import com.jormelcn.coursera.semaa3.petsmodels.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jormelcn on 5/06/16.
 */
public class ProfileFragment extends Fragment {


    View view;
    RecyclerView petGrid;
    FrameLayout profileCard;
    TextView profileName;
    ImageView profilePicture;
    TextView profileRating;
    PetAdapterGrid petAdaptator;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        fragment.petAdaptator = new PetAdapterGrid(new ArrayList<Pet>(), fragment.getActivity());
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        petGrid = (RecyclerView) view.findViewById(R.id.petGrid);
        FrameLayout profileHolder = (FrameLayout) view.findViewById(R.id.petProfileCard);

        profileCard = (FrameLayout) inflater.inflate(R.layout.card_view_pet_detail, profileHolder);
        profileCard.setPadding(0, 0, 0, 0);

        profileName = (TextView) profileCard.findViewById(R.id.petName);
        //profileName.setText(PetsContainer.PET_PROFILE.getName());

        profilePicture = (ImageView) profileCard.findViewById(R.id.petPicture);

        //profilePicture.setImageResource(PetsContainer.PET_PROFILE.getPicture());


        profileRating = (TextView) profileCard.findViewById(R.id.petRating);
        //profileRating.setText(String.valueOf(PetsContainer.PET_PROFILE.getRating()));


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
        petGrid.setAdapter(petAdaptator);

        return view;
    }

    public void updateProfile(Pet profile, ArrayList<Pet> pets) {
        profileName.setText(profile.getName());
        Picasso.with(getActivity()).load(profile.getPicture()).into(profilePicture);
        profilePicture.setMinimumHeight(200);
        profileRating.setText(String.valueOf(profile.getRating()));

        petAdaptator = new PetAdapterGrid(pets, getActivity());
        if(petGrid != null) {
            petGrid.setAdapter(petAdaptator);
        }
    }
}
