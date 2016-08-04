package com.example.mgkan.hackathon_lost_pets;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.koushikdutta.ion.builder.Builders;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  List<Pet> pets;
  private Context mContext;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mContext = this;

    final Button lostAndFound = (Button) findViewById(R.id.lostAndFoundButton);
    final Button petProfile = (Button) findViewById(R.id.petProfileButton);
    final Button petInfo = (Button) findViewById(R.id.petInfoButton);

    lostAndFound.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, SecondScreenActivity.class);

        Animation pushRight = AnimationUtils.loadAnimation(mContext, R.anim.push_out_right);

        petProfile.startAnimation(pushRight);
        petInfo.startAnimation(pushRight);
        lostAndFound.startAnimation(pushRight);
        startActivity(i);
        overridePendingTransition(0, 0);
      }


    });

    petInfo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, PetInfoActivity.class);
        startActivity(i);
        overridePendingTransition(0, 0);
        Animation pushRight = AnimationUtils.loadAnimation(mContext, R.anim.push_out_right);

        petProfile.startAnimation(pushRight);
        petInfo.startAnimation(pushRight);
        lostAndFound.startAnimation(pushRight);
      }
    });

    petProfile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, PetProfileActivity.class);
        startActivity(i);
        overridePendingTransition(0, 0);
        Animation pushRight = AnimationUtils.loadAnimation(mContext, R.anim.push_out_right);

        petProfile.startAnimation(pushRight);
        petInfo.startAnimation(pushRight);
        lostAndFound.startAnimation(pushRight);
      }
    });

  }
  @Override
  public void onResume() {
    super.onResume();
    final Button lostAndFound = (Button) findViewById(R.id.lostAndFoundButton);
    final Button petProfile = (Button) findViewById(R.id.petProfileButton);
    final Button petInfo = (Button) findViewById(R.id.petInfoButton);

    Animation pullRight = AnimationUtils.loadAnimation(mContext, R.anim.pull_right);

    petProfile.startAnimation(pullRight);
    petInfo.startAnimation(pullRight);
    lostAndFound.startAnimation(pullRight);
  }
}
