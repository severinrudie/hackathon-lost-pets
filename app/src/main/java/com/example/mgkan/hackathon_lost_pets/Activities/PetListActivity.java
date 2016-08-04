package com.example.mgkan.hackathon_lost_pets.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
    public static List<Pet> pets;

    public static final String DOG = "Dog";
    public static final String CAT = "Cat";
    private String type;
    private RecyclerView rvPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.search_name);
        setContentView(R.layout.activity_pet_list);

        verifyStoragePermissions(this);

//        getActionBar().setTitle("Refine search");

        handleIntent(getIntent());

        rvPets = (RecyclerView) findViewById(R.id.recyclerView_petList_petListActivity);

        type = getIntent().getStringExtra("TYPE");

        populateWithSearchedFoundAnimal(rvPets, type, "");

//        ImageView exitButton = (ImageView) findViewById(R.id.exitListCard);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                View listCard = findViewById(R.id.list_info_card);
//                listCard.setVisibility(View.GONE);
//            }
//        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.options_menu, menu);
//
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
//
//        return true;
//    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i("MATTTEST","onNewIntent called");
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        Log.i("MATTTEST","handleIntent called");


        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            populateWithSearchedFoundAnimal(rvPets,type,query);

        }

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

    private String generalizeSearchString(String search) {
        return "like '%25" + search + "%25'";
    }

    public void populateWithSearchedFoundAnimal(final RecyclerView rvPets, String animal, String search) {
        String apiToken = "GAuG06jfO7zdOLS1s0OktESQU";

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        if (search.trim().equals("")){
            search = animal;
        } else {
            search = generalizeSearchString(search);
        }

        Call<List<Pet>> call = apiService.getPetsWithSearch(apiToken, animal, "FOUND", "date DESC", search);

        pets = new ArrayList<>();

        call.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

                int statusCode = response.code();
                if (statusCode > 199 && statusCode < 300) {

//                    for (Pet pet : response.body()) {
//                        pets.add(pet);
//                    }
                    pets = (response.body());
                    PetListAdapter adapter = new PetListAdapter(getBaseContext(), pets);

                    if (rvPets.getAdapter() == null) {
                        rvPets.setAdapter(new AlphaInAnimationAdapter(adapter));
                        rvPets.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    } else {
                        rvPets.swapAdapter(new AlphaInAnimationAdapter(adapter), false);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                Log.d("SEVTEST: ", "Call response != 200 code");
                t.printStackTrace();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                populateWithSearchedFoundAnimal(rvPets, type, query);
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                populateWithSearchedFoundAnimal(rvPets, type, newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}



