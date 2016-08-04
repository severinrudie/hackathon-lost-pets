package com.example.mgkan.hackathon_lost_pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.koushikdutta.ion.Ion;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int pos = getIntent().getIntExtra("POS",0);

        Toast.makeText(DetailActivity.this, ""+pos+ " pressed!", Toast.LENGTH_SHORT).show();

        Pet pet = PetListActivity.pets.get(pos);
        ImageView photo = (ImageView) findViewById(R.id.detailPhoto);

        String url = pet.getImage();

        Ion.with(photo)
                .placeholder(R.color.colorPrimary)
                .error(R.color.colorAccent)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .load(url);

    }
}
