package com.example.mgkan.hackathon_lost_pets.rest;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.Model.PetResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mgkan on 2016-08-03.
 */
public interface ApiInterface {

  @GET("murn-chih.json")
  Call<List<Pet>> getPetsWithSearch(@Query("$$app_token") String apiToken, @Query("animal_type") String animalType,
                          @Query("Record_Type") String recordType, @Query("$order") String sort,
                                    @Query("$q") String search);
}
