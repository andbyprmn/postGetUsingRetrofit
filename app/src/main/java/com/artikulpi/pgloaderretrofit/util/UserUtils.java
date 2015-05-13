package com.artikulpi.pgloaderretrofit.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.artikulpi.pgloaderretrofit.model.UserData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abProgrammer on 4/13/15.
 */
public class UserUtils {

    private static final String ARG_RATES = "rates";
    private static final String ARG_USERNAME = "username";
    private static final String ARG_EMAIL = "email";
    private static final String ARG_PHONE = "phone";

    private final Context mContext;
    private final SharedPreferences mPrefs;

    public UserUtils(Context context) {
        mContext = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void saveRates(List<UserData> rates) {
        SharedPreferences.Editor editor = mPrefs.edit();

        Gson gson = new Gson();
        String jsonRates = gson.toJson(rates);
        editor.putString(ARG_RATES, jsonRates);

        editor.commit();

    }

    public ArrayList<UserData> getRates() {

        List<UserData> rates;

        if(mPrefs.contains(ARG_RATES)) {

            String jsonRates = mPrefs.getString(ARG_RATES, null);

            Gson gson = new Gson();
            UserData[] rateItems = gson.fromJson(jsonRates, UserData[].class);

            rates = Arrays.asList(rateItems);
            rates = new ArrayList<UserData>(rates);

        } else {
            return null;
        }

        return (ArrayList<UserData>) rates;
    }

    public void removeRates() {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.remove(ARG_RATES);
        editor.commit();
    }

    public String getUsername() {
        return mPrefs.getString(ARG_USERNAME, "");
    }

    public String getEmail() {
        return mPrefs.getString(ARG_EMAIL, "");
    }

    public String getPhone() {
        return mPrefs.getString(ARG_PHONE, "");
    }

    public UserData getUserData() {
        UserData data = new UserData();
        data.setUsername(getUsername());
        data.setEmail(getEmail());
        data.setPhone(getPhone());
        return data;
    }

    public void clear() {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.remove(ARG_USERNAME);
        editor.remove(ARG_EMAIL);
        editor.remove(ARG_PHONE);
        editor.clear();
        editor.commit();
    }

    public void saveUserData(UserData user) {
        SharedPreferences.Editor edit = mPrefs.edit();
        edit.putString(ARG_USERNAME, user.getUsername());
        edit.putString(ARG_EMAIL, user.getEmail());
        edit.putString(ARG_PHONE, user.getPhone());
        edit.commit();
    }
}
