package com.example.recyclerview;

public class ListProvider {
    private int image_id;
    private String name, ratings;

    ListProvider(int image_id,String name, String ratings){
        this.image_id = image_id;
        this.name = name;
        this.ratings = ratings;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getName() {
        return name;
    }

    public String getRatings() {
        return ratings;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
}
