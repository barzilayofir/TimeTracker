package com.projects.ofirbarzilay.timetracker.adatpters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.projects.ofirbarzilay.timetracker.R;
import com.projects.ofirbarzilay.timetracker.helpers.TimeTrackerDatabaseHelper;

/**
 * Created by Ofir.Barzilay on 19/12/2014.
 */
public class TimeTrackerCursorAdapter extends CursorAdapter {


    public TimeTrackerCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);


    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);
        TextView notesTextView = (TextView) view.findViewById(R.id.notes_view);
        timeTextView.setText(cursor.getString(cursor.getColumnIndex(TimeTrackerDatabaseHelper.TIME_COLUMN)));
        notesTextView.setText(cursor.getString(cursor.getColumnIndex(TimeTrackerDatabaseHelper.NOTES_COLUMN)));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(
                R.layout.time_list_item, parent, false);
        return view;
    }

}
