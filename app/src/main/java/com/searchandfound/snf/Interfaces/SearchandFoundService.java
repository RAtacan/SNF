package com.searchandfound.snf.Interfaces;

/**
 * Created by #Chris on 18.08.2016.
 */

import com.searchandfound.snf.Models.EmailRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface SearchandFoundService {


    @GET("/Api/v1/emailCheck")
    Call<EmailRequest> checkMail(@Query("email") String email);

}
