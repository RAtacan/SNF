package com.searchandfound.snf.Interfaces;

/**
 * Created by #Chris on 18.08.2016.
 */

import com.searchandfound.snf.Models.AuthenticationResponse;
import com.searchandfound.snf.Models.EmailResponse;
import com.searchandfound.snf.Models.RegisterResponse;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface SearchandFoundService {


    @GET("checkMail.php")
    Call<EmailResponse> checkMail(@Query("email") String email);

    @GET("login.php")
    Call<AuthenticationResponse> authenticate(@Query("email") String email, @Query("pw") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("email") String email);

}
