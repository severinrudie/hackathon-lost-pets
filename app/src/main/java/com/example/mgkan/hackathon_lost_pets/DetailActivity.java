package com.example.mgkan.hackathon_lost_pets;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;
import com.example.mgkan.hackathon_lost_pets.rest.NotFoundImageLoader;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.koushikdutta.ion.Ion;

import org.w3c.dom.Text;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    public String address, animalId;
    public HashMap<String, String> phoneNumber = new HashMap<>();
    Activity mActivity;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mActivity = this;

        getPhoneNumber();
        int pos = getIntent().getIntExtra("POS", 0);
        Pet currentAnimal = PetListActivity.pets.get(pos);
        address = currentAnimal.getCurrentLocation();
        animalId = currentAnimal.getAnimalId();

        Pet pet = PetListActivity.pets.get(pos);
        ImageView photo = (ImageView) findViewById(R.id.detailPhoto);

        String url = pet.getImage();

        Ion.with(photo)
                .placeholder(R.color.colorPrimary)
                .error(R.color.colorAccent)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .load(url)
                .withBitmapInfo()
                .setCallback(NotFoundImageLoader.handleNotFound(photo, this));

        String[] splitDate = pet.getDate().split("-");
        splitDate[2] = splitDate[2].split("T")[0];

        String month = monthConstructor(splitDate[1]);
        String day = splitDate[2];
        String year = splitDate[0];
        String formattedDate = month + " " + day + ", " + year;

        TextView name = (TextView) findViewById(R.id.dog_name);
        TextView breed = (TextView) findViewById(R.id.dog_breed);
        TextView date = (TextView) findViewById(R.id.dog_date_found);
        TextView gender = (TextView) findViewById(R.id.dog_gender);
        TextView color = (TextView) findViewById(R.id.dog_color);
        TextView area = (TextView) findViewById(R.id.dog_area);
        Button myPet = (Button) findViewById(R.id.myPetButton);

        if (!pet.getName().equals("null")) {
            name.setText(pet.getName());
        } else {
            name.setText("Unknown");
        }
        breed.setText(pet.getAnimalBreed());
        date.setText(formattedDate);
        gender.setText(pet.getAnimalGender());
        color.setText(pet.getColor());
        area.setText(pet.getCity());

        myPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog diaBox = showInfo();
                diaBox.show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private AlertDialog showInfo() {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Let's get your pet back!")
                .setMessage("Info you need to retrieve your pet.\n"
                        + "Address: " + address + "\n"
                        + "Phone: " + phoneNumber.get(address) + "\n"
                        + "Animal ID: " + animalId)
                .setIcon(R.drawable.ic_adb)
                .setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        makeCall();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }


//        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
//          //set message, title, and icon
//          .setTitle("Let's get your pet back!")
//          .setMessage("Info you need to retrieve your pet.\n\n"
//            + "Location: "+ address+"\n\n"
//            + "Phone: "+ phoneNumber.get(address)+"\n\n"
//            + "Animal ID: "+ animalId)
//          .setIcon(R.drawable.icon_profile_sm)
//
//          .create();
//        return myQuittingDialogBox;


//    }

    private void makeCall() {
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.get(address).replace("-","")));
        in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            verifyStoragePermissions(mActivity);
            return;
        }
        startActivity(in);
    }

    private HashMap<String, String> getPhoneNumber() {
        phoneNumber.put("Covington Petco 27111 167TH PL SE COVINGTON, WA 98042", "253-638-1064");
        phoneNumber.put("Crossroads #204 Petco 15600 NE 8TH ST BELLEVUE, WA 98008", "425-641-9333");
        phoneNumber.put("In Public Home", "206-296-2709");
        phoneNumber.put("In RASKC Foster Home", "206-296-7387");
        phoneNumber.put("King County Pet Adoption Center 21615 64TH AVE S KENT, WA 98032", "206-296-7388");
        phoneNumber.put("Kirkland Petco 12040 NE 85TH ST KIRKLAND, WA 98033", "425-889-8319");
        phoneNumber.put("Meowtropolitan", "206-632-2330");
        phoneNumber.put("Reber Ranch 28606 132ND AVE SE KENT, WA 98042", "253-630-3330");

        return phoneNumber;
    }

    private String monthConstructor(String month) {
        String result = "";
        switch (month) {
            case "01":
                result = "January";
                break;
            case "02":
                result = "February";
                break;
            case "03":
                result = "March";
                break;
            case "04":
                result = "April";
                break;
            case "05":
                result = "May";
                break;
            case "06":
                result = "June";
                break;
            case "07":
                result = "July";
                break;
            case "08":
                result = "August";
                break;
            case "09":
                result = "September";
                break;
            case "10":
                result = "October";
                break;
            case "11":
                result = "November";
                break;
            case "12":
                result = "December";
                break;
        }
        return result;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.d("Permissions", "We dont have them");
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity, new String[]{Manifest.permission.CALL_PHONE,
                            Manifest.permission.READ_PHONE_STATE}, 2);
        } else {
            Log.d("Permissions", "We have them");


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        makeCall();

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Detail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.mgkan.hackathon_lost_pets/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Detail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.mgkan.hackathon_lost_pets/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
