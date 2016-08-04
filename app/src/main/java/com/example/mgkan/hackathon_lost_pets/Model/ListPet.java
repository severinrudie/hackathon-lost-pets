package com.example.mgkan.hackathon_lost_pets.Model;

/**
 * Created by erikrudie on 8/3/16.
 */
public class ListPet {


    String animalId;  // animal_id  | the ID contains some letters
//    double[] coordinates;  //  link | location_for_map.coordinates |
    String animalBreed;  //  animal_breed |
    String animalType;  //  animal_type | 'Dog', 'Cat', 'Dead Bird', etc
    String date;  //  date | YYYY-MM-DD'T'tt:tt:tt.ttt
    //                   EG. 2016-08-03T00:00:00.000
    String dateType;  //  date_type | eg 'Received On'
    String color;  //  color |
    String image;  //  image | stored using URLEncode/URLDecode
    String city;  // location_for_map_city |
    String name;  // animal_name
    String animalGender;  // animal_gender | 'Female' 'Male'

    public ListPet(String animalId, String animalType, String date, String dateType, String color,
                   String age, String image, String city, String name, String animalGender,
                   String animalBreed) {
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
    }
}
