package cs48.ucsb.edu.clubhop;

import android.os.Bundle;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by Joel on 2/14/2017.
 */

public class EventPageBundler {

    public Bundle makeEventPageBundle(Marker marker) {
        Bundle bundle = new Bundle(5);
        String title = "Title";
        bundle.putString("Title", title);
        String eventType = "Private";
        bundle.putString("EventType", eventType);
        String time = "1:00 - 2:00";
        bundle.putString("Time", time);
        String location = "Somewhere location in a place above a tree";
        bundle.putString("Location", location);
        String desc = "Super long string Super long string Super long string Super long string Super long string Super long string Super long string ";
        bundle.putString("Description", desc);
        return bundle;
    }
}
