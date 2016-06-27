package com.jormelcn.coursera.semaa3.petsmodels.recyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jormelcn.coursera.semaa3.petsmodels.Pet;
import com.jormelcn.coursera.semaa3.petsmodels.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jormelcn on 29/05/16.
 */
public class PetDetailListAdapter extends RecyclerView.Adapter<PetDetailListAdapter.PetViewHolder>{

    ArrayList<Pet> pets;
    ArrayList<PetViewHolder> holders = new ArrayList<>();
    Context context;

    public interface OnEventListener{
        void onPictureClick(int petId);
        void onAddLike(int petId);
    }

    OnEventListener onEventListener = null;

    public PetDetailListAdapter(ArrayList<Pet> pets, OnEventListener onEventListener, Context context){
        super();
        this.pets = pets;
        this.onEventListener = onEventListener;
        this.context = context;
        /*for(int i = 0;i < pets.size(); i++){
            holders.add(null);
        }*/
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_pet_detail, parent, false);
        PetViewHolder petViewHolder = new PetViewHolder(v);
        return  petViewHolder;
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, final int position) {
        //holder.petPicture.setImageResource(pets.get(position).getPicture());
        Picasso.with(context).load(pets.get(position).getPicture()).into(holder.petPicture);
        holder.petRating.setText(String.valueOf(pets.get(position).getRating()));
        holder.petName.setText(pets.get(position).getName());

        holder.whiteBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEventListener.onAddLike(position);
            }
        });

        holder.petPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEventListener.onPictureClick(position);
                //PetsContainer.PET_PROFILE = pets.get(position);
                //profile.updateProfile();
                //viewPager.setCurrentItem(1);
            }
        });
        holders.add(position, holder);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public void setLikes(int petIndex, int likes){
        holders.get(petIndex).petRating.setText(String.valueOf(likes));
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
