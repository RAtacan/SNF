package com.searchandfound.snf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by #Chris on 20.08.2016.
 */
public class RegisterResponse {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    public Meta getMeta(){
        return meta;
    }
    public String getEmail(){
        return email;
    }

}
