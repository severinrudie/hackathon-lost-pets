package com.example.mgkan.hackathon_lost_pets.rest;

import com.example.mgkan.hackathon_lost_pets.Model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mgkan on 2016-08-03.
 */
public interface ApiInterface {
  @GET()
  Call<PetResponse> getPets(@Query("$$api_token") String apiToken, @Query("animal_type") String animalType, @Query("$order") String sort);
}
