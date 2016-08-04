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
//  @GET("murn-chih.json")
//  Call<List<Pet>> getPets(@Query("$$app_token") String apiToken, @Query("animal_type") String animalType,
//                          @Query("$order") String sort);


  @GET("murn-chih.json")
  Call<List<Pet>> getPets(@Query("$$app_token") String apiToken, @Query("animal_type") String animalType,
                          @Query("Record_Type") String recordType, @Query("$order") String sort);
}


//GET /resource/murn-chih.json?$$app_token=GAuG06jfO7zdOLS1s0OktESQU HTTP/1.1
//        Host: data.kingcounty.gov
//        animal_type: Dog
//        Record_Type: FOUND
//        $order: date DESC