package com.example.retea.upbid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.retea.upbid.MainActivity.itemList;

/**
 * Created by retea on 04-May-18.
 */


public class Utils {



    public Utils() {
    }

    public static void saveDataList(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(itemList);
        editor.putString("item list", json);
        editor.apply();
    }

    public static void loadDataList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("item list", null);
        Type type = new TypeToken<ArrayList<Item>>() {
        }.getType();
        itemList = gson.fromJson(json, type);

        if (itemList == null) {
            itemList = new ArrayList<Item>();
        }

    }
}

