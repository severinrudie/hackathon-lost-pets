package com.example.mgkan.hackathon_lost_pets.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mgkan.hackathon_lost_pets.Adapters.PetListAdapter;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.R;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends AppCompatActivity {

    List<Pet> mPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        RecyclerView rvPets = (RecyclerView) findViewById(R.id.recyclerView_petList_petListActivity);
        // TODO: get list of pets
//         mPets = some list of pets
        PetListAdapter adapter = new PetListAdapter(this, mPets);
        rvPets.setAdapter(adapter);
        rvPets.setLayoutManager(new LinearLayoutManager(this));
    }
}



