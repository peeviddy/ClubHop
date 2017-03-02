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
        bundle.putString("Title", event.getTitle());
        bundle.putString("EventType", event.getType());
        bundle.putString("Time", event.getStartTime() + " - " + event.getEndTime());
        bundle.putString("Location", event.getLocation().getName());
        bundle.putString("Description", event.getDescription());
        bundle.putString("PictureURL", event.getPictureURL());
        return bundle;
    }
}
