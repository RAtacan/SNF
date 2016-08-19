package com.searchandfound.snf;

/**
 * Created by Ridvan on 18.08.2016.
 */
public class Entry {
    public String name;
    public int image;

    public Entry (String name, int image){
        this.name=name;
        this.image=image;
    }

    public String getName(){
        return name;
    }
    public int getImage(){
        return image;
    }
}
