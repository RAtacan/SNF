package com.searchandfound.snf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by #Chris on 18.08.2016.
 */
public class EmailResponse {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public String getEmail(){

        return email;

    }
    public Meta getMeta(){
        return meta;
    }

}
