package com.artikulpi.pgloaderretrofit.io;

import com.artikulpi.pgloaderretrofit.io.model.AddUserCallback;
import com.artikulpi.pgloaderretrofit.io.model.UserCallback;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by abProgrammer on 4/9/15.
 */
public interface Api {

    @FormUrlEncoded
    @POST("/kipli/index.php/post")
    void userSubmit(@Field("username") String username, @Field("email") String email,
                    @Field("phone") String phone, RestCallback<AddUserCallback> restCallback);

    @GET("/kipli/index.php/fetch")
    void userFetch(RestCallback<UserCallback> callback);
}
