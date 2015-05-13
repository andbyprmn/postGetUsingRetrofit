package com.artikulpi.pgloaderretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.artikulpi.pgloaderretrofit.R;
import com.artikulpi.pgloaderretrofit.model.UserData;

import java.util.ArrayList;

/**
 * Created by abProgrammer on 4/13/15.
 */
public class UserAdapter extends ArrayAdapter<UserData> {

private LayoutInflater layoutInflater;
private ArrayList<UserData> listData;

public UserAdapter(Context context, ArrayList<UserData> listData) {
        super(context, R.layout.list_item, listData);

        this.listData = listData;
        layoutInflater = layoutInflater.from(context);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
        convertView = layoutInflater.inflate(R.layout.list_item, null);

        // Lookup view for data population
        holder = new ViewHolder();
        holder.name = (TextView) convertView.findViewById(R.id.userName);
        holder.email= (TextView) convertView.findViewById(R.id.userEmail);
        holder.phone = (TextView) convertView.findViewById(R.id.userPhone);

        convertView.setTag(holder);
        } else {
        holder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        holder.name.setText(listData.get(position).getUsername());
        holder.email.setText(listData.get(position).getEmail());
        holder.phone.setText(listData.get(position).getPhone());

        // Return the completed view to render on screen
        return convertView;

        }

static class ViewHolder {

    TextView name;
    TextView email;
    TextView phone;

}

}
