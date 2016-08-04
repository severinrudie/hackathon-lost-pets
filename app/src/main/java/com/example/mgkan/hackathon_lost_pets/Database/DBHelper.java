package com.example.mgkan.hackathon_lost_pets.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erikrudie on 7/23/16.
 */

/*
All SQL queries are made from this class
 */

//    REMINDER: NICKNAMES ARE STORED W/O APOSTRASCES OR QUOTATION MARKS

public class DBHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String DATABASE_NAME = "LOST_PETS_DB";
    private static final int DATABASE_VERSION = 1;

    private static DBHelper DB;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    public static DBHelper getInstance(Context context) {
        if (DB == null) {
            DB = new DBHelper(context);
        }
        return DB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        for (String string : SC.create_tables) {
//            db.execSQL(string);
//        }
//        for (String[] sArray : SC.nodeDetails) {
//            insertNodeDetails(sArray[0], sArray[1], sArray[2], sArray[3]);
//        }
//        for (ChoiceData data : SC.choiceDetails) {
//            int[] i = data.getInts();
//            insertChoiceDetails(data.getText(), i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7]);
//        }
//        for (String[] sArray : SC.popupDetails) {
//            insertPopupDetails(sArray[0], sArray[1], sArray[2], sArray[3], sArray[4], sArray[5]);
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropAllTables();
        this.onCreate(db);
    }

    public void dropAllTables() {
        SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + SC.TABLE_PETS);
    }

//    this.animalId = animalId;
//    this.animalType = animalType;
//    this.date = date;
//    this.dateType = dateType;
//    this.color = color;
//    this.image = image;
//    this.city = city;
//    this.name = name;
//    this.animalGender = animalGender;
//    this.animalBreed = animalBreed;
//    this.link = link;
//    this.zip = zip;
//    this.address = address;
//    this.memo = memo;
//    this.currentLocation = currentLocation;

    // This method returns the character ID of the inserted row after inserting character details
    public void insertPetIntoDb(Pet pet) {
        String id = pet.getAnimalId();
        String type = pet.getAnimalType();
        String date = pet.getDate();
        String dateType = pet.getDateType();
        String color = pet.getColor();
        String image = pet.getImage();
        String city = pet.getCity();
        String name = pet.getName();
        String gender = pet.getAnimalGender();
        String breed = pet.getAnimalBreed();
        String link = pet.getLink();
        int zip = pet.getZip();
        String address = pet.getAddress();
        String memo = pet.getMemo();
        String location = pet.getCurrentLocation();

        String sql = "INSERT INTO " + SC.TABLE_PETS + " (" + SC.ID + ", " + SC.TYPE + ", " + SC.DATE + ", "
                + SC.DATE_TYPE + ", " + SC.COLOR + ", " + SC.IMAGE + ", " + SC.CITY + ", " + SC.NAME + ", "
                + SC.GENDER + ", " + SC.BREED + ", " + SC.LINK + ", " + SC.ZIP + ", " + SC.ADDRESS + ", "
                + SC.MEMO + ", " + SC.LOCATION + ") VALUES ('" + id + "', '" + type + "', '"
                + date + "', '" + dateType + "', '" + color + "', '"  + image + "', '" + city + "', '"
                + name + "', '" + gender + "', '" + breed + "', '" + link + "', '" + zip + "', '"
                + address + "', '" + memo + "', '" + location + "');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }


    public String cleanTextForDb(String string) {
        string = string.replace("'", "''");
        string = string.replace("\"", "\\\"");
        return string;
    }


}
