package com.example.mgkan.hackathon_lost_pets;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PetInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);

        final TextView aOne = (TextView) findViewById(R.id.arcticle_one);
        final TextView aTwo = (TextView) findViewById(R.id.article_two);
        final TextView aThree = (TextView) findViewById(R.id.article_three);

        aOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.petfinder.com/cats/lost-and-found-cats/lost-pet/"));
                startActivity(intent);
            }
        });
        aTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.seattle.gov/animal-shelter/events-and-resources/other-shelters"));
                startActivity(intent);
            }
        });
        aThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.seattle.gov/animal-shelter/lost-pets/lost-pet-prevention"));
                startActivity(intent);
            }
        });

    }
}
