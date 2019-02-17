package com.example.testrssi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class MyAdapter extends ArrayAdapter<ScanResult> {
    private List<ScanResult> results;
//    int lastPosition;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    // Provide a suitable constructor (depends on the kind of dataset)

    MyAdapter(Context context, List<ScanResult> results) {
        super(context, R.layout.scan_result, results);
        this.results = results;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ScanResult dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ScanResultHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.scan_result, parent, false);
            viewHolder = new ScanResultHolder(convertView);
//            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ScanResultHolder) convertView.getTag();
//            result=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;

        viewHolder.setSsidView(results.get(position).SSID);
        viewHolder.setMacView(results.get(position).BSSID);
        viewHolder.setRssiView(results.get(position).level);
        // Return the completed view to render on screen
        return convertView;
    }

    public void setResults(List<ScanResult> results) {
        this.results = results;
    }
}