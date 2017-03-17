package cs48.ucsb.edu.clubhop.Bundlers;

import android.os.Bundle;

import com.google.android.gms.maps.model.Marker;

import java.text.DateFormatSymbols;
import java.util.Date;

import cs48.ucsb.edu.clubhop.User.FacebookEvent;

/**
 * Created by Joel on 2/14/2017.
 */

public class EventPageBundler {

    public Bundle makeBundle(Marker marker) {
        FacebookEvent event = (FacebookEvent) marker.getTag();
        Bundle bundle = new Bundle(5);
        bundle.putString("Title", event.getTitle());
        bundle.putString("EventType", event.getType());
        String start = (event.getStartTime().toString());
        if(event.getEndTime().equals(new Date(0))){
            bundle.putString("Time", start);
        }
        else{
            bundle.putString("Time", start + " - " + event.getEndTime().toString());
        }
        bundle.putInt("Date", event.getStartTime().getDate());
        bundle.putString("Month", new DateFormatSymbols().getShortMonths()[event.getStartTime().getMonth()]); //here we get an out-of-bounds exception sometimes
        bundle.putString("Location", event.getLocation().getName());
        bundle.putString("Description", event.getDescription());
        bundle.putString("PictureURL", event.getPictureURL());
        return bundle;
    }
}
