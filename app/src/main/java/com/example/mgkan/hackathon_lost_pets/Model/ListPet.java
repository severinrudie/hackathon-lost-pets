package com.example.mgkan.hackathon_lost_pets.Model;

/**
 * Created by erikrudie on 8/3/16.
 */
public class ListPet {

    String animalId;  // animal_id  | the ID contains some letters
    Double[] coordinates;  //  link | location_for_map.coordinates |
    String animalType;  //  animal_type | 'Dog', 'Cat', 'Dead Bird', etc
    String date;  //  date | YYYY-MM-DD'T'tt:tt:tt.ttt
    //                   EG. 2016-08-03T00:00:00.000
    String dateType;  //  date_type | eg 'Received On'
    String color;  //  color |
    String age;  //  age | eg 1 YEAR
    String image;  //  image | stored using URLEncode/URLDecode
    String city;  // location_for_map_city |
    String name;  // animal_name

    public ListPet(String animalId, Double[] coordinates, String animalType, String date,
                   String dateType, String color, String age, String image, String city,
                   String name) {
        this.animalId = animalId;
        this.coordinates = coordinates;
        this.animalType = animalType;
        this.date = date;
        this.dateType = dateType;
        this.color = color;
        this.age = age;
        this.image = image;
        this.city = city;
        this.name = name;
    }
}
