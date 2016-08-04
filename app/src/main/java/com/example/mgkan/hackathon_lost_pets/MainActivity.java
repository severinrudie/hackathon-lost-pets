package com.example.mgkan.hackathon_lost_pets;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mgkan.hackathon_lost_pets.Adapters.PetListAdapter;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.Model.PetResponse;
import com.example.mgkan.hackathon_lost_pets.rest.ApiClient;
import com.example.mgkan.hackathon_lost_pets.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  List<Pet> pets;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    final View lostAndFound = (Button) findViewById(R.id.lostAndFoundButton);
    final View petProfile = (Button) findViewById(R.id.petProfileButton);
    final View kitty = (ImageView) findViewById(R.id.kitty);

<<<<<<< HEAD
    lostAndFound.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, SecondScreenActivity.class);
=======
    Call<List<Pet>> call = apiService.getPets(apiToken, "FOUND", "Dog", "date DESC");

    Log.d("Url: ", call.request().url().toString());
>>>>>>> ffc5d91522cc245564d92865fd6d3a75051165c3

//        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, kitty,
//                kitty.getTransitionName())
//                .toBundle();

<<<<<<< HEAD
        Pair<View, String> pair1 = Pair.create(kitty, kitty.getTransitionName());
//        Pair<View, String> pair2 = Pair.create(petProfile, petProfile.getTransitionName());
//        Pair<View, String> pair3 = Pair.create(lostAndFound, lostAndFound.getTransitionName());
        ActivityOptions options = ActivityOptions.
                makeSceneTransitionAnimation(MainActivity.this, pair1);
        startActivity(i, options.toBundle());

=======
    Log.d("Here: ", " something");

    call.enqueue(new Callback<List<Pet>>() {
      @Override
      public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

        Log.d("Here: ", " something2");
        Log.d("Response Code: ", "" + response.code());

        int statusCode = response.code();
        if (statusCode > 199 && statusCode < 300) {
          Log.d("SEVTEST: ", response.body().toString());

          Log.d("Brad TEST: ", "This Works!!!");
          for (Pet pet : response.body()) {

            Log.d("Brad's Dog: ", "=>" + pet.getAddress());
            pets.add(pet);
          }
          //pets.addAll(response.body().getResults());
        }
      }

      @Override
      public void onFailure(Call<List<Pet>> call, Throwable t) {
        // Log error here since request failed
//        Log.e(TAG, t.toString());
        Log.d("SEVTEST: ", "Call response != 200 code");
        t.printStackTrace();
>>>>>>> ffc5d91522cc245564d92865fd6d3a75051165c3
      }
    });

  }
}
