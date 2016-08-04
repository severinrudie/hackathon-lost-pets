package com.example.mgkan.hackathon_lost_pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int pos = getIntent().getIntExtra("POS",0);

        Toast.makeText(DetailActivity.this, ""+pos+ " pressed!", Toast.LENGTH_SHORT).show();

    }
}
