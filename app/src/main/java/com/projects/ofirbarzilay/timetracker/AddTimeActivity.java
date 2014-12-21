package com.projects.ofirbarzilay.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class AddTimeActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_time);
    }
    public void onSave(View view){
        EditText timeView = (EditText) findViewById(R.id.time_view);
        EditText notesView = (EditText) findViewById(R.id.notes_view);

        String time = timeView.getText().toString();
        String notes = notesView.getText().toString();

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("time", time);
        i.putExtra("notes", notes);
        this.setResult(RESULT_OK, i);
        finish();
    }

    public void onCancel(View view) {
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
        // we will use finish in order to remove this activity from the back stack
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_time, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
