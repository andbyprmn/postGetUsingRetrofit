package com.artikulpi.pgloaderretrofit.io;

import android.content.Context;
import android.widget.Toast;

import com.artikulpi.pgloaderretrofit.R;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by abProgrammer on 4/13/15.
 */
public class RestCallback<T> implements Callback<T> {

    private final Context mContext;

    public RestCallback(Context context) {
        mContext = context;
    }

    @Override
    public void success(T o, Response response) {
    }

    @Override
    public void failure(RetrofitError error) {
        if(error.getKind() == RetrofitError.Kind.NETWORK) {
            Toast.makeText(mContext, mContext.getString(R.string.error_message_no_connection), Toast.LENGTH_SHORT).show();
        }
    }
}