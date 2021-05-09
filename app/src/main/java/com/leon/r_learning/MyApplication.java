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
    public static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    public static final long MIN_TIME_BW_UPDATES = 10000;
    public static final long FASTEST_INTERVAL = 5;
    public static final int GPS_CODE = 1231;
    public static final int REQUEST_NETWORK_CODE = 1232;
    public static final int REQUEST_WIFI_CODE = 1233;
    public static final int CAMERA_REQUEST = 1888;
    public static final int GALLERY_REQUEST = 1889;
    public static final int CAMERA = 1446;
    public static final int REPORT = 1445;
    public static final int NAVIGATION = 1903;
    public static final int DESCRIPTION = 1909;
    public static final int TOAST_TEXT_SIZE = 20;
    public static final int CARRIER_PRIVILEGE_STATUS = 901;
    public static final int READ_PHONE_STATE = 911;
    public static Bitmap bitmapSelectedImage;
    public static int POSITION = -1;
    public static String fileName;
    public static boolean focusOnEditText = false;
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
