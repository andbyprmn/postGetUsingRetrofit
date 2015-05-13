package com.artikulpi.pgloaderretrofit.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.artikulpi.pgloaderretrofit.R;
import com.artikulpi.pgloaderretrofit.adapter.UserAdapter;
import com.artikulpi.pgloaderretrofit.io.RestCallback;
import com.artikulpi.pgloaderretrofit.io.RestUser;
import com.artikulpi.pgloaderretrofit.io.model.AddUserCallback;
import com.artikulpi.pgloaderretrofit.io.model.UserCallback;
import com.artikulpi.pgloaderretrofit.model.UserData;
import com.artikulpi.pgloaderretrofit.util.UserUtils;

import java.util.ArrayList;

import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private EditText inputUsername;
    private EditText inputEmail;
    private EditText inputPhone;

    private Button btnSubmit;
    private Button btnFetch;

    private ArrayList<UserData> userData;
    private ArrayAdapter<UserData> userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername = (EditText) findViewById(R.id.editName);
        inputEmail = (EditText) findViewById(R.id.editEmail);
        inputPhone = (EditText) findViewById(R.id.editPhone);

        btnSubmit = (Button) findViewById(R.id.button);
        btnFetch = (Button) findViewById(R.id.button2);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch();
            }
        });
    }

    private void submit() {

        final String userName = inputUsername.getText().toString();
        final String userEmail = inputEmail.getText().toString();
        final String userPhone = inputPhone.getText().toString();

        inputUsername.setEnabled(false);
        inputEmail.setEnabled(false);
        inputPhone.setEnabled(false);

        RestUser.get().userSubmit(userName, userEmail, userPhone, new RestCallback<AddUserCallback>(this) {
            @Override
            public void success(AddUserCallback userCallback, Response response) {
                super.success(userCallback, response);

                UserUtils userUtils = new UserUtils(getApplicationContext());
                userUtils.saveUserData(userCallback.getData());

            }

            @Override
            public void failure(RetrofitError error) {
                super.failure(error);
            }
        });


    }

    private void fetch() {

        RestUser.get().userFetch(new RestCallback<UserCallback>(this) {
            @Override
            public void success(UserCallback userCallback, Response response) {
                super.success(userCallback, response);

                userData = new ArrayList<UserData>();
                userAdapter = new UserAdapter(getApplicationContext(), userData);
                userData.addAll(userCallback.getData());

                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(userAdapter);
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void failure(RetrofitError error) {
                super.failure(error);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
