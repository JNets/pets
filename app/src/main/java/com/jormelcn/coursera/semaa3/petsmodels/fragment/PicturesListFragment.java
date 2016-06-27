package com.jormelcn.coursera.semaa3.petsmodels.fragment;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jormelcn.coursera.semaa3.petsmodels.Pet;
import com.jormelcn.coursera.semaa3.petsmodels.R;
import com.jormelcn.coursera.semaa3.petsmodels.recyclerViewAdapter.PetDetailListAdapter;

import java.util.ArrayList;

/**
 * Created by jormelcn on 5/06/16.
 */
public class PicturesListFragment extends Fragment implements PetDetailListAdapter.OnEventListener{

    RecyclerView petList;
    PetDetailListAdapter petDetailListAdapter;

    @Override
    public void onPictureClick(int petId) {
        onEventsListener.onPictureSelected(petId);
    }

    @Override
    public void onAddLike(int petId) {
        onEventsListener.onAddLike(petId);
    }

    public interface OnEventsListener{
        void onPictureSelected(int petId);
        void onAddLike(int petId);
    }

    private OnEventsListener onEventsListener = null;

    public static PicturesListFragment newInstance(OnEventsListener onEventsListener) {

        PicturesListFragment fragment = new PicturesListFragment();
        fragment.onEventsListener = onEventsListener;
        fragment.petDetailListAdapter = new PetDetailListAdapter(new ArrayList<Pet>(), fragment, fragment.getActivity());
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pest_pictures, container, false);

        petList = (RecyclerView) view.findViewById(R.id.petList);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);
        petList.setAdapter(petDetailListAdapter);
        return view;
    }

    public void setPetsList(ArrayList<Pet> pets){
        petDetailListAdapter = new PetDetailListAdapter(pets, this, this.getActivity());
        if(petList != null) {
            petList.setAdapter(petDetailListAdapter);
        }
    }
}
