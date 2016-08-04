package com.example.mgkan.hackathon_lost_pets.Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.widget.Toast;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.R;
import com.koushikdutta.ion.Ion;

import java.util.List;

/**
 * Created by erikrudie on 8/3/16.
 */
public class PetListAdapter extends
        RecyclerView.Adapter<PetListAdapter.ViewHolder> {



    private List<Pet> mPets;
    private Context mContext;

    public PetListAdapter(Context context, List<Pet> pets) {
        mPets = pets;
        mContext = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        ImageView photo;
        TextView name;
        TextView breed;
        TextView date;
        TextView gender;
        View view;


        public ViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.list_item_card);
            photo = (ImageView) itemView.findViewById(R.id.list_item_image);
            name = (TextView) itemView.findViewById(R.id.list_item_name);
            breed = (TextView) itemView.findViewById(R.id.list_item_breed);
            date = (TextView) itemView.findViewById(R.id.list_item_date);
            gender = (TextView) itemView.findViewById(R.id.list_item_gender);

            view = itemView;

        }
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public PetListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PetListAdapter.ViewHolder holder, int position) {
        Pet pet = mPets.get(position);

        String url = pet.getImage();

        Ion.with(holder.photo)
                .placeholder(R.color.colorPrimary)
                .error(R.color.colorAccent)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .load(url);

        if (pet.getName() != null) {
            holder.name.setText(pet.getName());
        } else {
            holder.name.setVisibility(View.GONE);
        }

        holder.breed.setText(pet.getAnimalBreed());
        holder.date.setText(pet.getDate());
        holder.gender.setText(pet.getAnimalGender());

        final String id = pet.getAnimalId();

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getContext(),TODO: DETAIL VIEW ACTIVITY NAME);
//
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.putExtra("id",id);
//                mContext.startActivity(i);
                Toast.makeText(mContext, "Pet with id: "+id+" has been pressed!", Toast.LENGTH_LONG).show();
            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPets.size();
    }



}

