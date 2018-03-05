package com.example.widyabrigita.keeptrying;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.Context;

import java.util.Map;

/**
 * Created by BRI on 26/10/2016.
 */
public class SessionUser {
    public static final String PREFS_NAME_USER = "AOP_PREFS_USER";
    public static final String PREFS_KEY_USER = "AOP_PREFS_USER1";

    public SessionUser() {
        super();
    }

    public void setSession(Context context, String text) {
        SharedPreferences settings;
        Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME_USER, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(PREFS_KEY_USER, text); //3

        editor.commit(); //4
    }

    public String getSession(Context context) {
        SharedPreferences settings;
        String text;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME_USER, Context.MODE_PRIVATE);
        text = settings.getString(PREFS_KEY_USER, "");
        return text;
    }
}