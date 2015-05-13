package com.artikulpi.pgloaderretrofit.io;

import com.artikulpi.pgloaderretrofit.Config;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by abProgrammer on 4/9/15.
 */
public class RestUser {
    public static Api REST_USER;

    static {
        setupRestClient();
    }


    public RestUser() {
    }

    public static Api get() {
        return REST_USER;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Config.SERVER_NAME)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();

        REST_USER = restAdapter.create(Api.class);
    }

}
