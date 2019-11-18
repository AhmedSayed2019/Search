package services;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class ChangeLanguage {



    public static void loadLanguage(Context mContext){
        SharedPreferences preferences = mContext.getSharedPreferences("Settings" , Activity.MODE_PRIVATE);
        String language = preferences.getString("My_Lang" ,"EN") ;

        setLocale(mContext,language);
    }
    public static void  setLocale(Context mContext, String lang){
        Locale locale =new Locale(lang);
        locale.setDefault(locale);
        Configuration config =new Configuration();
        config.locale = locale ;
        mContext.getResources().updateConfiguration(config ,mContext.getResources().getDisplayMetrics());
        //save data to shared prefrence
        SharedPreferences.Editor editor = mContext.getSharedPreferences("Settings",Context.MODE_PRIVATE).edit();
        editor.putString("My_Lang" , lang);
        editor.apply();
    }


    public static String getLanguage(Context mContext){
        SharedPreferences preferences = mContext.getSharedPreferences("Settings" , Activity.MODE_PRIVATE);

        return preferences.getString("My_Lang" ,"");
    }




}
