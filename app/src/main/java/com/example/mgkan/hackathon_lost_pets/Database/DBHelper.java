package com.example.mgkan.hackathon_lost_pets.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.example.mgkan.hackathon_lost_pets.Model.Pet;

import java.lang.reflect.Array;
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
      // TODO: do... stuff... here?
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropAllTables();
        this.onCreate(db);
    }

    public void createDbIfNotExists() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SC.CREATE_TABLE);
    }

    public void dropAllTables() {
        SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + SC.TABLE_PETS);
    }



    // This method returns the character ID of the inserted row after inserting character details
    public void insertPetIntoDb(Pet pet) {
        String id = cleanTextForDb(pet.getAnimalId());
        String type = cleanTextForDb(pet.getAnimalType());
        String date = cleanTextForDb(pet.getDate());
        String dateType = cleanTextForDb(pet.getDateType());
        String color = cleanTextForDb(pet.getColor());
        String image = cleanTextForDb(pet.getImage());
        String city = cleanTextForDb(pet.getCity());
        String name = cleanTextForDb(pet.getName());
        String gender = cleanTextForDb(pet.getAnimalGender());
        String breed = cleanTextForDb(pet.getAnimalBreed());
        String link = cleanTextForDb(pet.getLink());
        int zip = pet.getZip();
        String address = cleanTextForDb(pet.getAddress());
        String memo = cleanTextForDb(pet.getMemo());
        String location = cleanTextForDb(pet.getCurrentLocation());
        int dayInt = pet.getDayInt();

        String sql = "INSERT INTO " + SC.TABLE_PETS + " (" + SC.ID + ", " + SC.TYPE + ", " + SC.DATE + ", "
                + SC.DATE_TYPE + ", " + SC.COLOR + ", " + SC.IMAGE + ", " + SC.CITY + ", " + SC.NAME + ", "
                + SC.GENDER + ", " + SC.BREED + ", " + SC.LINK + ", " + SC.ZIP + ", " + SC.ADDRESS + ", "
                + SC.MEMO + ", " + SC.LOCATION + ", " + SC.DAY_INT + ") VALUES ('" + id + "', '" + type + "', '"
                + date + "', '" + dateType + "', '" + color + "', '"  + image + "', '" + city + "', '"
                + name + "', '" + gender + "', '" + breed + "', '" + link + "', '" + zip + "', '"
                + address + "', '" + memo + "', '" + location + ", " + dayInt + "');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }


    public String cleanTextForDb(String string) {
        if (string != null) {
            string = string.replace("'", "''");
            string = string.replace("\"", "\\\"");
        }
        return string;
    }

//    public static final String ID = "animalId";
//    public static final String TYPE = "type";
//    public static final String DATE = "date";
//    public static final String DATE_TYPE = "dateType";
//    public static final String COLOR = "color";
//    public static final String IMAGE = "image";
//    public static final String CITY = "city";
//    public static final String NAME = "name";
//    public static final String GENDER = "gender";
//    public static final String BREED = "breed";
//    public static final String LINK = "link";
//    public static final String ZIP = "zip";
//    public static final String ADDRESS = "address";
//    public static final String MEMO = "memo";
//    public static final String LOCATION = "location";
    public List<Pet> getPetListFromDb(String dogCat) {
        String sql = "SELECT * FROM " + SC.TABLE_PETS +" WHERE " + SC.TYPE + " = '" + dogCat +"';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        List<Pet> pets = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(cursor.getColumnIndexOrThrow(SC.ID));
            String type = cursor.getString(cursor.getColumnIndexOrThrow(SC.TYPE));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(SC.DATE));
            String dateType = cursor.getString(cursor.getColumnIndexOrThrow(SC.DATE_TYPE));
            String color = cursor.getString(cursor.getColumnIndexOrThrow(SC.COLOR));
            String image = cursor.getString(cursor.getColumnIndexOrThrow(SC.IMAGE));
            String city = cursor.getString(cursor.getColumnIndexOrThrow(SC.CITY));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(SC.NAME));
            String gender = cursor.getString(cursor.getColumnIndexOrThrow(SC.GENDER));
            String breed = cursor.getString(cursor.getColumnIndexOrThrow(SC.BREED));
            String link = cursor.getString(cursor.getColumnIndexOrThrow(SC.LINK));
            int zip = cursor.getInt(cursor.getColumnIndexOrThrow(SC.ZIP));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(SC.ADDRESS));
            String memo = cursor.getString(cursor.getColumnIndexOrThrow(SC.MEMO));
            String location = cursor.getString(cursor.getColumnIndexOrThrow(SC.LOCATION));
            pets.add(new Pet(id, type, date, dateType, color, image, city, name, gender, breed, link, zip
            , address, memo, location));
            cursor.moveToNext();
        }
        return pets;
    }


}
