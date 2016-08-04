package com.example.mgkan.hackathon_lost_pets;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  List<Pet> pets;
  private Context mContext;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mContext = this;

    final View lostAndFound = (Button) findViewById(R.id.lostAndFoundButton);
    final View petProfile = (Button) findViewById(R.id.petProfileButton);
    final View kitty = (ImageView) findViewById(R.id.kitty);
    final View petInfo = (Button) findViewById(R.id.petInfoButton);
    final View title = (ImageView) findViewById(R.id.title);

    lostAndFound.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, SecondScreenActivity.class);

        Pair<View, String> pair1 = Pair.create(kitty, kitty.getTransitionName());
        Animation outLeft = AnimationUtils.loadAnimation(mContext, R.anim.push_out_left);
        Animation outRight = AnimationUtils.loadAnimation(mContext, R.anim.push_out_right);
        Animation pushDown = AnimationUtils.loadAnimation(mContext, R.anim.push_out_down);

        title.startAnimation(pushDown);
        petProfile.startAnimation(outLeft);
        petInfo.startAnimation(outLeft);
        lostAndFound.startAnimation(outRight);

          ActivityOptions options = ActivityOptions.
                  makeSceneTransitionAnimation(MainActivity.this, pair1);
          startActivity(i, options.toBundle());
      }


    });

  }
  @Override
  public void onResume() {
    super.onResume();
    final View lostAndFound = (Button) findViewById(R.id.lostAndFoundButton);
    final View petProfile = (Button) findViewById(R.id.petProfileButton);
    final View petInfo = (Button) findViewById(R.id.petInfoButton);
    final View title = (ImageView) findViewById(R.id.title);

    Animation inLeft = AnimationUtils.loadAnimation(mContext, R.anim.pull_left);
    Animation inRight = AnimationUtils.loadAnimation(mContext, R.anim.pull_right);
    Animation pullUp= AnimationUtils.loadAnimation(mContext, R.anim.pull_up);

    title.startAnimation(pullUp);
    petProfile.startAnimation(inLeft);
    petInfo.startAnimation(inLeft);
    lostAndFound.startAnimation(inRight);
  }
}
