package com.leon.r_learning.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {

    public static String readFile(Context context, String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            StringBuilder out = new StringBuilder();
            String eachLine = bufferedReader.readLine();
            while (eachLine != null) {
                out.append(eachLine);
                eachLine = bufferedReader.readLine();
            }
            return out.toString();
        } catch (IOException e) {
            Log.e("Load Asset File", e.toString());
        }
        return null;
    }
}
