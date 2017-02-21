package cs48.ucsb.edu.clubhop;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class DrawerHandler {

    public void addDrawerItems(ListView mDrawerList,
                               ArrayAdapter<String> mAdapter,
                               Context context) {
        mDrawerList.setAdapter(mAdapter);

        // Perform action on nav button click
        //mDrawerList.setOnItemClickListener();
    }

    public void setUp(ActionBarDrawerToggle mDrawerToggle,
                      DrawerLayout mDrawerLayout,
                      MapsActivity mapsActivity) {
        mDrawerToggle = new ActionBarDrawerToggle(mapsActivity, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                /*super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()*/
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {/*
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()*/
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }
}
