package com.projects.ofirbarzilay.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.projects.ofirbarzilay.timetracker.adatpters.TimeRecord;
import com.projects.ofirbarzilay.timetracker.adatpters.TimeTrackerAdapter;


public class MainActivity extends ActionBarActivity {

    private TimeTrackerAdapter timeTrackerAdapter;
    public static final int TIME_ENTRY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.times_list);
        timeTrackerAdapter = new TimeTrackerAdapter();
        listView.setAdapter(timeTrackerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_time_menu_item) {
            Intent i = new Intent(this, AddTimeActivity.class);

            startActivityForResult(i, TIME_ENTRY_REQUEST_CODE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TIME_ENTRY_REQUEST_CODE && (resultCode == RESULT_OK)){
            String time = data.getStringExtra("time");
            String notes = data.getStringExtra("notes");
            TimeRecord timeRecord = new TimeRecord(time, notes);
            timeTrackerAdapter.addTimeRecord(timeRecord);
            timeTrackerAdapter.notifyDataSetChanged();
        }
    }
}
