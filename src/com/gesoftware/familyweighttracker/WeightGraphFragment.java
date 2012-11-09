package com.gesoftware.familyweighttracker;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gesoftware.familyweighttracker.data.Weight;
import com.gesoftware.familyweighttracker.data.WeightsDataSource;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

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
		View layout = inflater.inflate(R.layout.weight_graph_fragment, container, false);
		
		// init example series data  
		GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {  
		      new GraphViewData(1, 2.0d)  
		      , new GraphViewData(2, 1.5d)  
		      , new GraphViewData(3, 2.5d)  
		      , new GraphViewData(4, 1.0d)  
		});  
		  
		GraphView graphView = new LineGraphView(appContext, "GraphViewDemo");  
		graphView.addSeries(exampleSeries); // data  
		  
		FrameLayout graphLayout = (FrameLayout) layout.findViewById(R.id.graphFrame);  
		graphLayout.addView(graphView); 
		
		return layout;
		
		
	}

}
