package com.searchandfound.snf.Utils;

import com.searchandfound.snf.Interfaces.SearchandFoundService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by #Chris on 18.08.2016.
 */
public class APIBuilder {

    /* public used paramenters */
    public static int COUNT = 10;

    /* private section */
    private static APIBuilder instance = null;
    private static SearchandFoundService service = null;

    private static int MODE = APIBuilder.PROD;
    private static final int PROD = 3;



    private static final String PRODUCTION_SCHEMA = "http";
    private static final String PRODUCTION_HOST = "snfandroid.comli.com";




    protected APIBuilder() {
        /* Exists only to defeat instantiation */
    }

    public static APIBuilder getInstance() {
        if (instance == null) {
            instance = new APIBuilder();
        }
        return instance;
    }

    public SearchandFoundService getService() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIBuilder.getBase())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            /*// Accepting unsafe(no CA) Connection to dev.geocha.com
            if(MODE == API.DEV){

                retrofit.client().setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

            }*/
            service = retrofit.create(SearchandFoundService.class);
        }
        return service;
    }


    public static String getBase() {
        switch (APIBuilder.MODE){
            case (APIBuilder.PROD): return PRODUCTION_SCHEMA+ "://" + PRODUCTION_HOST;
            default: return PRODUCTION_SCHEMA+ "://" + PRODUCTION_HOST;
        }
    }



}

