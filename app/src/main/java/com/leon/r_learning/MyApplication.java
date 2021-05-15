package com.leon.r_learning;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;

import androidx.multidex.MultiDex;

import es.dmoral.toasty.Toasty;


public class MyApplication extends Application {
    public static final String FONT_NAME = "font/iranian_sans.ttf";
    public static final int TOAST_TEXT_SIZE = 20;
    public static final int LESSON_NUMBER = 3;
    public static final int COURSE_NUMBER = 4;
    public static final int[][] SECTION_NUMBER = {{4}, {3}, {4, 4}};
    public static final String[] COURSES = {
            "Key Concepts",
            "Cyber Attacks",
            "Privacy"
    };
    public static final String[][] LESSONS = {
            {"Passwords"},
            {"Viruses"},
            {"GDPR", "VPN"}
    };

    public static String SEPARATOR = "<<-->>";

    static Context appContext;

    public static Context getContext() {
        return appContext;
    }

    public static String getDBName() {
        return "MyDatabase";
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        appContext = getApplicationContext();
        Toasty.Config.getInstance()
                .tintIcon(true).setToastTypeface(Typeface.createFromAsset(appContext.getAssets(),
                MyApplication.FONT_NAME))
                .setTextSize(TOAST_TEXT_SIZE)
                .allowQueue(true).apply();
        super.onCreate();
    }
}
