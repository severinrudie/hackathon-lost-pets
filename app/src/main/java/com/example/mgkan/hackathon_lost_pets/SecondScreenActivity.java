package com.example.mgkan.hackathon_lost_pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        final View lostMyPet = (Button) findViewById(R.id.petProfileButton);
        final View foundAPet = (Button) findViewById(R.id.petInfoButton);
    }
}
