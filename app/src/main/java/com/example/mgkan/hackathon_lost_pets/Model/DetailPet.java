package com.example.mgkan.hackathon_lost_pets.Model;

/**
 * Created by erikrudie on 8/3/16.
 */
public class DetailPet extends ListPet {

    String recordType;  // record_type  | values are FOUND / LOST / ADOPTABLE
    String link; // TODO: use URLEncoder and URLDecoder to maintain special characters
    int zip;  // zip
    String address;  // location_for_map_address |
    String memo;  //  memo | String broken up by <p></p>

    public DetailPet(String animalId, Double[] coordinates, String animalType, String date,
                     String dateType, String color, String age, String image, String city,
                     String name, String recordType, String link, int zip, String address,
                     String memo) {
        super(animalId, coordinates, animalType, date, dateType, color, age, image, city, name);
        this.recordType = recordType;
        this.link = link;
        this.zip = zip;
        this.address = address;
        this.memo = memo;
    }
}
