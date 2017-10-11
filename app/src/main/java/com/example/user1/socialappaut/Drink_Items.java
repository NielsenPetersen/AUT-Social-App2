package com.example.user1.socialappaut;

/**
 * Created by User1 on 24/09/2017.
 */

public class Drink_Items {

    private String Image;
    private String Name;
    private String Price;

    public Drink_Items(){

    }

    public Drink_Items(String image, String name, String price){

        Image = image;
        Name = name;
        Price = price;

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


}
