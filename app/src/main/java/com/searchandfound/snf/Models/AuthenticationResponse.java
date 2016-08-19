package com.searchandfound.snf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by #Chris on 19.08.2016.
 */
public class AuthenticationResponse {

    @SerializedName("data")
    @Expose
    Authentication auth;

    @SerializedName("meta")
    @Expose
    Meta meta;

    public Authentication getAuth(){
        return auth;
    }
    public Meta getMeta(){
        return meta;
    }


}
