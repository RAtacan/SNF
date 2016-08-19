package com.searchandfound.snf.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by #Chris on 19.08.2016.
 */
public class Prefs {



    public static void save(Context context,String key,String value){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();

        editor.putString(key,value);
        editor.commit();

    }
    public static String call(Context context,String key,String defaultVal){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getString(key,defaultVal);
    }


}
