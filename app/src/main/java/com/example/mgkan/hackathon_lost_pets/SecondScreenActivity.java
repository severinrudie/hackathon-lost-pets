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
import com.example.mgkan.hackathon_lost_pets.Database.DBHelper;
import com.example.mgkan.hackathon_lost_pets.Model.Pet;

import java.util.List;


public class SecondScreenActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_like_main);

        // TODO: SEV db test code
        //DBHelper helper = DBHelper.getInstance(this);

//        Pet pet = new Pet("a", "b", "2016-05-12T00:00:00", "d", "e","a", "b", "c", "d", "e","a", 1, "c", "d", "e");

//        helper.dropAllTables();
        //helper.createDbIfNotExists();
//        List<Pet> pets = helper.getPetListFromDb();
//        helper.insertPetIntoDb(pet);
        // TODO: SEV db test code

        mContext = this;

        final Button lostMyPet = (Button) findViewById(R.id.lostPetButton);
        final Button foundAPet = (Button) findViewById(R.id.foundPetButton);

        Animation pullLeft = AnimationUtils.loadAnimation(mContext, R.anim.pull_left_second);
        lostMyPet.startAnimation(pullLeft);
        foundAPet.startAnimation(pullLeft);

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
                AlertDialog diaBox = AskFoundPet();
                diaBox.show();
            }
        });

    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        final View lostMyPet = (Button) findViewById(R.id.lostPetButton);
        final View foundAPet = (Button) findViewById(R.id.foundPetButton);
        Animation pushLeft = AnimationUtils.loadAnimation(mContext, R.anim.push_out_left);
        lostMyPet.startAnimation(pushLeft);
        foundAPet.startAnimation(pushLeft);
        overridePendingTransition(0, 0);
    }
    private AlertDialog AskOptionHome() {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Search Pets")
                .setMessage("Would you like to look for a dog or a cat?")
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

    private AlertDialog AskFoundPet() {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
          //set message, title, and icon
          .setTitle("Found A Pet")
          .setMessage("Did you find a dog or a cat?")
          .setIcon(R.drawable.ic_adb)

          .setPositiveButton("Cat", new DialogInterface.OnClickListener() {

              public void onClick(DialogInterface dialog, int whichButton) {

                  Intent intent = new Intent();
                  intent.setAction(Intent.ACTION_VIEW);
                  intent.addCategory(Intent.CATEGORY_BROWSABLE);
                  intent.setData(Uri.parse("http://www.kingcounty.gov/depts/regional-animal-services/lost-and-found/FOUND/submitCat.aspx"));
                  startActivity(intent);
              }

          })

          .setNegativeButton("Dog", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {

                  Intent intent = new Intent();
                  intent.setAction(Intent.ACTION_VIEW);
                  intent.addCategory(Intent.CATEGORY_BROWSABLE);
                  intent.setData(Uri.parse("http://www.kingcounty.gov/depts/regional-animal-services/lost-and-found/FOUND/submitDog.aspx"));
                  startActivity(intent);

              }
          })
          .create();
        return myQuittingDialogBox;

    }
}
