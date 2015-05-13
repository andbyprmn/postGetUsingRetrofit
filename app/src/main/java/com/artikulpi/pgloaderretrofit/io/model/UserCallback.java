package com.artikulpi.pgloaderretrofit.io.model;

import com.artikulpi.pgloaderretrofit.model.UserData;

import java.util.ArrayList;

/**
 * Created by abProgrammer on 4/13/15.
 */
public class UserCallback extends BaseCallback {

    private ArrayList<UserData> data;

    public ArrayList<UserData> getData() {
        return data;
    }

    public void setData(ArrayList<UserData> data) {
        this.data = data;
    }

}
