package com.example.mgkan.hackathon_lost_pets;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;


public class SecondScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        final View lostMyPet = (Button) findViewById(R.id.petProfileButton);
        final View foundAPet = (Button) findViewById(R.id.petInfoButton);

        Button lostPet = (Button) findViewById(R.id.lostPetButton);
        lostPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog diaBox = AskOptionHome();
                diaBox.show();
            }
        });

    }

    private AlertDialog AskOptionHome() {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Search Pets")
                .setMessage("Would you like to look for a dog or cat?")
                .setIcon(R.drawable.ic_adb)

                .setPositiveButton("Cat", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                        Intent i = new Intent(SecondScreenActivity.this, PetListActivity.class);
                        i.putExtra("TYPE",PetListActivity.CAT);
                        startActivity(i);
                    }

                })

                .setNegativeButton("Dog", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i = new Intent(SecondScreenActivity.this, PetListActivity.class);
                        i.putExtra("TYPE",PetListActivity.DOG);
                        startActivity(i);

                    }
                })
                .create();
        return myQuittingDialogBox;

    }
}
