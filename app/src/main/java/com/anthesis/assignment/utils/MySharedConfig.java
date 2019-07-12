package com.anthesis.assignment.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedConfig {
    private Context mContext;

    private final static String NAME = "com.anthesis.assignment";

    private SharedPreferences preferences;

    private final static String TOTAL = "totals";

    public MySharedConfig(Context mContext) {
        preferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor edit() {
        return preferences.edit();
    }

    public String getTotal() {
        return preferences.getString(TOTAL, "0");
    }
    public String setTotal(String device_id) {
        edit().putString(TOTAL,device_id).commit();
        return device_id;
    }

}
