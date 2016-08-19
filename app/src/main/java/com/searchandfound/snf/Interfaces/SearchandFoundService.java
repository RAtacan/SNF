package com.searchandfound.snf.Interfaces;

/**
 * Created by #Chris on 18.08.2016.
 */

import com.searchandfound.snf.Models.AuthenticationResponse;
import com.searchandfound.snf.Models.EmailResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface SearchandFoundService {


    @GET("/api/v1/emailCheck")
    Call<EmailResponse> checkMail(@Query("email") String email);

    @GET("/api/v1/auth")
    Call<AuthenticationResponse> authenticate(@Query("email") String email, @Query("pw") String password);

}
