package cs48.ucsb.edu.clubhop.Bundlers;

import android.os.Bundle;

import com.google.android.gms.maps.model.Marker;

import cs48.ucsb.edu.clubhop.FacebookEvent;

/**
 * Created by Joel on 2/14/2017.
 */

public class EventPageBundler {

    public Bundle makeBundle(Marker marker) {
        FacebookEvent event = (FacebookEvent) marker.getTag();
        Bundle bundle = new Bundle(5);
        String title = "An Event Title";
        bundle.putString("Title", event.getTitle());
        String eventType = "Private";
        bundle.putString("EventType", event.getType());
        String time = "1:00 - 2:00";
        bundle.putString("Time", event.getStartTime() + " - " + event.getEndTime());
        String location = "Somewhere location in a place above a tree";
        bundle.putString("Location", event.getLocation().getName());
        String desc = "Super long string Super long string Super long string Super long string Super long string Super long string Super long string ";
        bundle.putString("Description", event.getDescription());
        return bundle;
    }
}
