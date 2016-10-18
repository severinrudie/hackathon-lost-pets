package com.example.mgkan.hackathon_lost_pets;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mgkan.hackathon_lost_pets.Activities.PetListActivity;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;


public class SecondScreenActivity extends AppCompatActivity {
    private Context mContext;
    ButtonAnimationHandler animationHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_like_main);

        ImageView ivKitty = (ImageView) findViewById(R.id.kitty);
        Ion.with(ivKitty)
          .placeholder(R.drawable.kitty)
          .error(R.drawable.kitty)
          .load("faulty url")
          .withBitmapInfo();

        mContext = this;

        final Button lostMyPet = (Button) findViewById(R.id.lostPetButton);
        final Button foundAPet = (Button) findViewById(R.id.foundPetButton);
        List<Button> buttons = new ArrayList<>();
        buttons.add(lostMyPet);
        buttons.add(foundAPet);
        final LinearLayout buttonHolder = (LinearLayout) findViewById(R.id.buttonHolder);

        Animation pullLeft = AnimationUtils.loadAnimation(mContext, R.anim.pull_left_second);
        animationHandler = new ButtonAnimationHandler(buttons, this);
        animationHandler.setAnimation(pullLeft);
        animationHandler.execute();
//        lostMyPet.startAnimation(pullLeft);
//        foundAPet.startAnimation(pullLeft);
//        buttonHolder.startAnimation(pullLeft);

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
        final LinearLayout buttonHolder = (LinearLayout) findViewById(R.id.buttonHolder);
        Animation pushLeft = AnimationUtils.loadAnimation(mContext, R.anim.push_out_left);
        animationHandler.setAnimation(pushLeft);
        animationHandler.execute();
        overridePendingTransition(0, 0);
//        lostMyPet.startAnimation(pushLeft);
//        foundAPet.startAnimation(pushLeft);
//        buttonHolder.startAnimation(pushLeft);
    }



    private AlertDialog AskOptionHome() {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Search Pets")
                .setMessage("Would you like to look for a dog or a cat?")
                .setIcon(R.drawable.icon_profile_sm)

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
          .setIcon(R.drawable.icon_profile_sm)

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
