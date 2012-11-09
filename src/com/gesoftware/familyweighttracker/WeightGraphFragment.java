package com.gesoftware.familyweighttracker;

import com.gesoftware.familyweighttracker.data.Weight;
import com.gesoftware.familyweighttracker.data.WeightsDataSource;
import com.gesoftware.familyweighttracker.R;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class WeightGraphFragment extends Fragment {

	protected Context appContext;
	protected WeightsDataSource weightsDatasource;
	protected ArrayAdapter<Weight> mAdapter;
	protected Object mActionMode;
	public int mSelectedItem = -1;
	private long personId;
	
	public WeightGraphFragment(Context appContext, long id) {
		this.appContext = appContext;
		this.personId = id;
		
		weightsDatasource = new WeightsDataSource(appContext);
		weightsDatasource.open();
				
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.graph_fragment, container, false);
	}

}
