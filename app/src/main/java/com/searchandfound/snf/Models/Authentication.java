package com.searchandfound.snf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by #Chris on 19.08.2016.
 */
public class Authentication {

    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("username")
    @Expose
    String username;

    @SerializedName("plz")
    @Expose
    String location;

    @SerializedName("auth_token")
    @Expose
    String authToken;

    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getLocation(){
        return location;
    }
    public String getAuthToken(){
        return authToken;
    }

}
