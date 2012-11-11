package com.gesoftware.familyweighttracker;

import java.text.SimpleDateFormat;
import java.util.List;

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
		
		List<Weight> weights = weightsDatasource.getAllWeightsForPerson(personId);
		int numEntries = weightsDatasource.getNumberOfWeightsForPerson(personId);
		GraphViewData[] data = new GraphViewData[numEntries]; 
		
		for (int i = 0; i < numEntries; i++) {
			data[i] = new GraphViewData(weights.get(i).getDateAsLong(), weights.get(i).getWeight());
		}
		// init example series data  
		GraphViewSeries weightSeries = new GraphViewSeries(data);  
		  
		//GraphView graphView = new LineGraphView(appContext, "Weight Graph");  
		GraphView graphView = new LineGraphView(appContext, "Weight Graph") {  
			   @Override  
			   protected String formatLabel(double value, boolean isValueX) {  
			      if (isValueX) {  
			         // convert unix time to human time  
			         return new SimpleDateFormat("dd-MMM-yy HH:mm:ss").format(value);  
			      } else return super.formatLabel(value, isValueX); // let the y-value be normal-formatted  
			   }  
			};
		
		graphView.addSeries(weightSeries); // data  
		
		graphView.setScalable(true); 
		  
		FrameLayout graphLayout = (FrameLayout) layout.findViewById(R.id.graphFrame);  
		graphLayout.addView(graphView); 
		
		return layout;
		
		
	}

}
