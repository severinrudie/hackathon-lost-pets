package com.example.mgkan.hackathon_lost_pets;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;


public class SecondScreenActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        mContext = this;

        final View lostMyPet = (Button) findViewById(R.id.lostPetButton);
        final View foundAPet = (Button) findViewById(R.id.foundPetButton);

        Animation inLeft = AnimationUtils.loadAnimation(mContext, R.anim.pull_left_second);
        Animation inRight = AnimationUtils.loadAnimation(mContext, R.anim.pull_right_second);
        lostMyPet.startAnimation(inRight);
        foundAPet.startAnimation(inLeft);

        lostMyPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog diaBox = AskOptionHome();
                diaBox.show();
            }
        });
        foundAPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.kingcounty.gov/depts/regional-animal-services/lost-and-found/FOUND.aspx"));
                startActivity(intent);
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
