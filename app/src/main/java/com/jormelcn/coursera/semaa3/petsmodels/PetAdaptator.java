package com.jormelcn.coursera.semaa3.petsmodels;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jormelcn on 29/05/16.
 */
public class PetAdaptator extends RecyclerView.Adapter<PetAdaptator.PetViewHolder>{

    ArrayList<Pet> pets;
    ViewPager viewPager;
    PetsDetailFragment petsDetailFragment;

    public PetAdaptator(ArrayList<Pet> pets, ViewPager viewPager, PetsDetailFragment petsDetailFragment){
        super();
        this.pets = pets;
        this.viewPager = viewPager;
        this.petsDetailFragment = petsDetailFragment;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, final int position) {
        holder.petPicture.setImageResource(pets.get(position).getPicture());
        holder.petRating.setText(String.valueOf(pets.get(position).getRating()));
        holder.petName.setText(pets.get(position).getName());

        holder.whiteBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pets.get(position).addLike();
                holder.petRating.setText(String.valueOf(pets.get(position).getRating()));
                //BaseDatos db = new BaseDatos(viewPager.getContext());
                //db.addLike(position);
            }
        });

        holder.petPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PetsContainer.PET_PROFILE = pets.get(position);
                petsDetailFragment.updateProfile();
                viewPager.setCurrentItem(1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder{
        ImageView petPicture;
        TextView petName;
        TextView  petRating;
        ImageView whiteBone;

        public PetViewHolder(View itemView) {
            super(itemView);
            whiteBone = (ImageView) itemView.findViewById(R.id.whiteBone);
            petPicture = (ImageView) itemView.findViewById(R.id.petPicture);
            petName = (TextView) itemView.findViewById(R.id.petName);
            petRating = (TextView) itemView.findViewById(R.id.petRating);
        }
    }
}
