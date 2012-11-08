package com.gesoftware.weights.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gesoftware.weights.R;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class WeightsCursorAdapter extends CursorAdapter {

	public WeightsCursorAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
		
	}

	public WeightsCursorAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView tvDateTime = (TextView) view.findViewById(R.id.column1);
		TextView tvWeight = (TextView) view.findViewById(R.id.column2);
		
        Date dateTime = new Date(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_WEIGHTS_TIMESTAMP)));
        tvDateTime.setText(new SimpleDateFormat("dd-MMM-yy HH:mm:ss").format(dateTime));
        
        tvWeight.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WEIGHTS_WEIGHT)));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = li.inflate(R.layout.weights_row, parent, false);
        return v;
	}

}
