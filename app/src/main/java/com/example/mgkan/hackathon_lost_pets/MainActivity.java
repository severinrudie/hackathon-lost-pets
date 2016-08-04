package com.example.mgkan.hackathon_lost_pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mgkan.hackathon_lost_pets.Adapters.PetListAdapter;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.Model.PetResponse;
import com.example.mgkan.hackathon_lost_pets.rest.ApiClient;
import com.example.mgkan.hackathon_lost_pets.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    Call<PetResponse> call = apiService.getPets(API_KEY,"Dog", sort);
    call.enqueue(new Callback<PetResponse>() {}
      @Override
      public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
        int statusCode = response.code();
        List<Pet> pets = response.body().getResults();
        recyclerView.setAdapter(new PetListAdapter(pets, R.layout.list_item_pet, context));
      }

      @Override
      public void onFailure(Call<PetResponse> call, Throwable t) {
        // Log error here since request failed
//        Log.e(TAG, t.toString());
      }
  }
}
