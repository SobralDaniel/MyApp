package com.example.nbacademy.myapp;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nbacademy on 13/03/2018.
 */
public class DeleteAdapter extends ArrayAdapter<String> {

    public DeleteAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public DeleteAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.delete_trip, null);
        }

        String p = getItem(position);

        if (p != null) {
            final TextView name = (TextView) v.findViewById(R.id.labelTrip);
            final ImageView deleteTrip = (ImageView) v.findViewById(R.id.buttonDelete);

            if (name != null) {
                name.setText(p);
            }

            if (deleteTrip != null) {
                deleteTrip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        name.setAlpha(0);
                        deleteTrip.setAlpha(0);
                    }
                });
            }
        }
        return v;
    }
}
