package com.example.mgkan.hackathon_lost_pets.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mgkan on 2016-08-03.
 */
public class ApiClient {
  public static final String BASE_URL = "https://data.kingcounty.gov/resource/murn-chih.json";
  private static Retrofit retrofit = null;


  public static Retrofit getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }
    return retrofit;
  }
}
