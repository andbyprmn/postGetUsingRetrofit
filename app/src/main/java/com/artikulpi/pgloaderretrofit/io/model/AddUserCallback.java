package com.artikulpi.pgloaderretrofit.io.model;

import com.artikulpi.pgloaderretrofit.model.UserData;

/**
 * Created by abProgrammer on 4/15/15.
 */
public class AddUserCallback extends BaseCallback {

    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

}
