package com.gifmyneeds.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ChildGifs implements Serializable {

    private String childId;
    private String category;
    private ArrayList<String> pathGif;

    public ChildGifs(String childId, String category, ArrayList<String> pathGif) {
        this.childId = childId;
        this.category = category;
        this.pathGif = pathGif;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getPathGif() {
        return pathGif;
    }

    public void setPathGif(ArrayList<String> pathGif) {
        this.pathGif = pathGif;
    }
}
