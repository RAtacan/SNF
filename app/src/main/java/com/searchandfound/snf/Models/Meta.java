package com.searchandfound.snf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by #Chris on 19.08.2016.
 */
public class Meta {

    @SerializedName("code")
    @Expose
    int code;

    @SerializedName("message")
    @Expose
    String message;

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
