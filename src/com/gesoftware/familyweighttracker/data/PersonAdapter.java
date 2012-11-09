package com.gesoftware.familyweighttracker.data;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gesoftware.familyweighttracker.R;

public class PersonAdapter extends ArrayAdapter {
	private int rowLayoutId;
	private ArrayList<Person> values;

	public PersonAdapter(Context context, int rowLayoutId, ArrayList<Person> values) {
		super(context, 0, values);
		this.values = values;
	}

	View.OnClickListener onViewClicked = new View.OnClickListener() {
	    @Override
	    public void onClick(View button) {
	        View listItem = (View)button.getParent();
	        ListView listView = (ListView) listItem.getParent();
	        
	    }
	};
	
	public Person getItem(int position) {
        return this.values.get(position);
    }

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(rowLayoutId, null);
            v.findViewById(R.id.btnView).setOnClickListener(onViewClicked);
        }
		
		Person item = getItem(position);
        if (item != null) {
        	TextView firstName = (TextView) v.findViewById(R.id.column1);
            firstName.setText(item.getFirstName());
            
        }
        v.setTag(item);
        return v;
        
	}

}
