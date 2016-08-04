package com.example.mgkan.hackathon_lost_pets.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.R;

import java.util.List;

/**
 * Created by erikrudie on 8/3/16.
 */
public class PetListAdapter extends
        RecyclerView.Adapter<PetListAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {

//   DEFINE VIEWS

        public ViewHolder(View itemView) {
            super(itemView);

//            INSTANTIATE VIEWS, ADD TO VIEWHOLDER

        }
    }


    private List<Pet> mPets;
    private Context mContext;

    public PetListAdapter(Context context, List<Pet> pets) {
        mPets = pets;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public PetListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

//        TODO: update layout with new xml
        View contactView = inflater.inflate(R.layout.MATTSLIST, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PetListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Pet pet = mPets.get(position);

        // TODO: set view contents
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPets.size();
    }



}

