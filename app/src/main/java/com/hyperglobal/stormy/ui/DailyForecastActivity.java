package com.hyperglobal.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.hyperglobal.stormy.R;
import com.hyperglobal.stormy.adapters.DayAdapter;
import com.hyperglobal.stormy.weather.Day;

import java.util.Arrays;
import java.util.List;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent(); // get the intent that called this activity
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST); // get the parcelable array from MainActivity
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class); // copy this data to a new array...

        DayAdapter adapter  = new DayAdapter(this, mDays); // ... and pass this array, with the context, to the DayAdapter, which returns the views
        this.setListAdapter(adapter); // set the adapter for the list view to this new adapter

    }

}