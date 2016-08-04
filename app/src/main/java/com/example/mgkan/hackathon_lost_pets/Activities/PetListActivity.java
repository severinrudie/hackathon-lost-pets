package com.example.mgkan.hackathon_lost_pets.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mgkan.hackathon_lost_pets.Adapters.PetListAdapter;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.R;
import com.example.mgkan.hackathon_lost_pets.rest.ApiClient;
import com.example.mgkan.hackathon_lost_pets.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends AppCompatActivity {
    private final static String API_KEY = "GAuG06jfO7zdOLS1s0OktESQU";
    private final static String sort = "date DESC";
    List<Pet> mPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        ApiInterface apiService =
          ApiClient.getClient().create(ApiInterface.class);

        RecyclerView rvPets = (RecyclerView) findViewById(R.id.recyclerView_petList_petListActivity);
        // TODO: get list of pets
//         mPets = some list of pets
        PetListAdapter adapter = new PetListAdapter(this, mPets);
        rvPets.setAdapter(adapter);
        rvPets.setLayoutManager(new LinearLayoutManager(this));
    }


}



