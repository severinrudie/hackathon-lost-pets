package com.example.mgkan.hackathon_lost_pets.Database;

/**
 * Created by erikrudie on 8/4/16.
 */

// String Constants
public class SC {

    private SC() {
        // all variables are static
    }

    public static final String TABLE_PETS = "table_pets";

    public static final String ID = "animalId";
    public static final String TYPE = "type";
    public static final String DATE = "date";
    public static final String DATE_TYPE = "dateType";
    public static final String COLOR = "color";
    public static final String IMAGE = "image";
    public static final String CITY = "city";
    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String BREED = "breed";
    public static final String LINK = "link";
    public static final String ZIP = "zip";
    public static final String ADDRESS = "address";
    public static final String MEMO = "memo";
    public static final String LOCATION = "location";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_PETS + " (" +
                    ID + " text, " +
                    TYPE + " text, " +
                    DATE + " text, " +
                    DATE_TYPE + " text, " +
                    COLOR + " text, " +
                    CITY + " text, " +
                    IMAGE + " text, " +
                    NAME + " text, " +
                    GENDER + " text, " +
                    BREED + " text, " +
                    LINK + " text, " +
                    ZIP + " integer, " +
                    ADDRESS + " text, " +
                    MEMO + " text, " +
                    LOCATION + " text " +
                    ");" +
                    "";




}
