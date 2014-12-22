package com.projects.ofirbarzilay.timetracker.adatpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projects.ofirbarzilay.timetracker.R;

import java.util.ArrayList;

/**
 * Created by Ofir.Barzilay on 19/12/2014.
 */
public class TimeTrackerAdapter extends BaseAdapter {

    private ArrayList<TimeRecord> times = new ArrayList<TimeRecord>();

    public TimeTrackerAdapter() {
//        times.add(new TimeRecord(
//                "38:23", "Feeling good!"));
//        times.add(new TimeRecord(
//                "49:01", "Tired. Needed more caffeine"));
//        times.add(new TimeRecord(
//                "26:21", "I’m rocking it!"));
//        times.add(new TimeRecord(
//                "29:42", "Lost some time on the hills, but pretty good."));
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        return times.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater =
                    LayoutInflater.from(parent.getContext());
            view = inflater.inflate(
                    R.layout.time_list_item, parent, false);
        }
        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);
        TextView notesTextView = (TextView) view.findViewById(R.id.notes_view);

        TimeRecord time = times.get(position);
        timeTextView.setText(time.getTime());
        notesTextView.setText(time.getNotes());
        return view;
    }

    public void addTimeRecord(TimeRecord timeRecord) {
        times.add(timeRecord);
    }
}
