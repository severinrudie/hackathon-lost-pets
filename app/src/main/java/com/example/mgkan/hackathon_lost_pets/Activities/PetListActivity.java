package com.example.mgkan.hackathon_lost_pets.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mgkan.hackathon_lost_pets.Adapters.PetListAdapter;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.Model.PetResponse;
import com.example.mgkan.hackathon_lost_pets.R;
import com.example.mgkan.hackathon_lost_pets.rest.ApiClient;
import com.example.mgkan.hackathon_lost_pets.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PetListActivity extends AppCompatActivity {
    private final static String API_KEY = "GAuG06jfO7zdOLS1s0OktESQU";
    private final static String sort = "date DESC";
    List<Pet> pets;

    public final String DOG = "Dog";
    public final String CAT = "Cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

//        verifyStoragePermissions(this);

        final RecyclerView rvPets = (RecyclerView) findViewById(R.id.recyclerView_petList_petListActivity);

        populateWithFoundAnimal(rvPets, CAT);

//        ApiInterface apiService =
//                ApiClient.getClient().create(ApiInterface.class);

//        String apiToken = "GAuG06jfO7zdOLS1s0OktESQU";
//
//        Call<List<Pet>> call = apiService.getPets(apiToken, "Dog", "FOUND", "date DESC");
//
//        pets = new ArrayList<>();
//
//        call.enqueue(new Callback<List<Pet>>() {
//            @Override
//            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {
//
//                int statusCode = response.code();
//                if (statusCode > 199 && statusCode < 300) {
//
//                    for (Pet pet : response.body()) {
//                        pets.add(pet);
//                    }
//                    pets.addAll(response.body());
//                    PetListAdapter adapter = new PetListAdapter(getBaseContext(), pets);
//                    rvPets.setAdapter(adapter);
//                    rvPets.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Pet>> call, Throwable t) {
//                Log.d("SEVTEST: ", "Call response != 200 code");
//                t.printStackTrace();
//            }
//        });

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


    public void populateWithFoundAnimal(final RecyclerView rvPets, String animal) {
        String apiToken = "GAuG06jfO7zdOLS1s0OktESQU";

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Pet>> call = apiService.getPets(apiToken, animal, "FOUND", "date DESC");

        pets = new ArrayList<>();

        call.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

                int statusCode = response.code();
                if (statusCode > 199 && statusCode < 300) {

                    for (Pet pet : response.body()) {
                        pets.add(pet);
                    }
                    pets.addAll(response.body());
                    PetListAdapter adapter = new PetListAdapter(getBaseContext(), pets);
                    rvPets.setAdapter(new AlphaInAnimationAdapter(adapter));
                    rvPets.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                }
            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                Log.d("SEVTEST: ", "Call response != 200 code");
                t.printStackTrace();
            }
        });
    }

//    private static final int REQUEST_PERMISSIONS = 1;
//    private static String[] PERMISSIONS_INTERNET = {
//            Manifest.permission.INTERNET,
//    };
//
//    public static void verifyStoragePermissions(Activity activity) {
//        // Check if we have write permission
//        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.INTERNET);
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                    activity,
//                    PERMISSIONS_INTERNET,
//                    REQUEST_PERMISSIONS
//            );
//        }
//    }
//    }
}



