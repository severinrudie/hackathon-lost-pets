package com.example.mgkan.hackathon_lost_pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.koushikdutta.ion.Ion;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int pos = getIntent().getIntExtra("POS",0);

        Pet pet = PetListActivity.pets.get(pos);
        ImageView photo = (ImageView) findViewById(R.id.detailPhoto);

        String url = pet.getImage();

        Ion.with(photo)
                .placeholder(R.color.colorPrimary)
                .error(R.color.colorAccent)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .load(url);


        String[] splitDate = pet.getDate().split("-");
        splitDate[2] = splitDate[2].split("T")[0];

        String month = monthConstructor(splitDate[1]);
        String day = splitDate[2];
        String year = splitDate[0];
        String formattedDate = month + " " + day + ", " + year;

//        for (String bit : splitDate) {
//            Log.d("SEVTEST ", "Chunk: " + bit);
//        }

//        breed.setText(pet.getAnimalBreed());
//        date.setText(formattedDate);
//        gender.setText(pet.getAnimalGender());

    }

    private String monthConstructor(String month) {
        String result = "";
        switch (month) {
            case "01": result = "January";
                break;
            case "02": result = "February";
                break;
            case "03": result = "March";
                break;
            case "04": result = "April";
                break;
            case "05": result = "May";
                break;
            case "06": result = "June";
                break;
            case "07": result = "July";
                break;
            case "08": result = "August";
                break;
            case "09": result = "September";
                break;
            case "10": result = "October";
                break;
            case "11": result = "November";
                break;
            case "12": result = "December";
                break;
        }
        return result;
    }
}
