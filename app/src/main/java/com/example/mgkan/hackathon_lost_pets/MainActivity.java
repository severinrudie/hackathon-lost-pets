package com.example.mgkan.hackathon_lost_pets;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mgkan.hackathon_lost_pets.Database.DBHelper;
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

    verifyStoragePermissions(this);
//
//    DBHelper helper = DBHelper.getInstance(this);
//    SQLiteDatabase db = helper.getWritableDatabase();
//    helper.onCreate(db);

//    helper.dropAllTables(db);

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


  private static final int REQUEST_PERMISSIONS = 1;
  private static String[] PERMISSIONS_INTERNET = {
          Manifest.permission.INTERNET,
  };

  public static void verifyStoragePermissions(Activity activity) {
    // Check if we have write permission
    int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.INTERNET);

    if (permission != PackageManager.PERMISSION_GRANTED) {
      // We don't have permission so prompt the user
      ActivityCompat.requestPermissions(
              activity,
              PERMISSIONS_INTERNET,
              REQUEST_PERMISSIONS
      );
    }
  }
}
