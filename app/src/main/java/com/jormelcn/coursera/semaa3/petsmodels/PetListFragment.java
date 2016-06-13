package com.jormelcn.coursera.semaa3.petsmodels;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jormelcn on 5/06/16.
 */
public class PetListFragment extends Fragment {

    private ViewPager viewPager;
    private PetsDetailFragment petsDetailFragment;
    private BaseDatos db;

    public static PetListFragment newInstance(ViewPager viewPager, PetsDetailFragment petsDetailFragment) {

        Bundle args = new Bundle();
        PetListFragment fragment = new PetListFragment();
        fragment.setArguments(args);
        fragment.viewPager = viewPager;
        fragment.petsDetailFragment = petsDetailFragment;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        db = new BaseDatos(getContext());
        View view = inflater.inflate(R.layout.pet_list_fragment, container, false);
        RecyclerView petList = (RecyclerView) view.findViewById(R.id.petList);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);

        PetAdaptator petAdaptator = new PetAdaptator(db.getPets(), viewPager, petsDetailFragment);
        petList.setAdapter(petAdaptator);
        return view;
    }

}
