package com.example.mgkan.hackathon_lost_pets.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by erikrudie on 8/3/16.
 */
public class Pet {
    @SerializedName("current_location")
    private String currentLocation;// current_location
    @SerializedName("animal_id")
    private String animalId;// animal_id  | the ID contains some letters
    @SerializedName("animal_breed")
    private String animalBreed;  //  animal_breed |
    @SerializedName("animal_type")
    private String animalType;  //  animal_type | 'Dog', 'Cat', 'Dead Bird', etc
    @SerializedName("date")
    private String date;  //  date | YYYY-MM-DD'T'tt:tt:tt.ttt
    //                   EG. 2016-08-03T00:00:00.000
    @SerializedName("date_type")
    private String dateType;  //  date_type | eg 'Received On'
    @SerializedName("animal_color")
    private String color;  //  color |
    @SerializedName("image")
    private String image;  //  image | stored using URLEncode/URLDecode
    @SerializedName("city")
    private String city;  // location_for_map_city |
    @SerializedName("animal_name")
    private String name;  // animal_name
    @SerializedName("animal_gender")
    private String animalGender;  // animal_gender | 'Female' 'Male'
    @SerializedName("link_description")
    private String link; // TODO: use URLEncoder and URLDecoder to maintain special characters
    @SerializedName("zip")
    private int zip;  // zip
    @SerializedName("obfuscated_address")
    private String address;  // location_for_map_address |
    @SerializedName("memo")
    private String memo;  //  memo | String broken up by <p></p>
    //    double[] coordinates;  //  link | location_for_map.coordinates |

    public Pet(String animalId, String animalType, String date, String dateType, String color,
               String image, String city, String name, String animalGender,
               String animalBreed, String link, int zip, String address, String memo, String currentLocation) {
        this.animalId = animalId;
//        this.coordinates = coordinates;
        this.animalType = animalType;
        this.date = date;
        this.dateType = dateType;
        this.color = color;
        this.image = image;
        this.city = city;
        this.name = name;
        this.animalGender = animalGender;
        this.animalBreed = animalBreed;
        this.link = link;
        this.zip = zip;
        this.address = address;
        this.memo = memo;
        this.currentLocation = currentLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }




}
