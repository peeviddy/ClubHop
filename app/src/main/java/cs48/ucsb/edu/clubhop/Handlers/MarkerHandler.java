package cs48.ucsb.edu.clubhop.Handlers;

import com.google.android.gms.maps.GoogleMap;

import cs48.ucsb.edu.clubhop.Facebook.FacebookEvent;
import cs48.ucsb.edu.clubhop.MarkerOptions.MarkerOptionsFactory;

/**
 * Created by Joel on 2/22/2017.
 */

public class MarkerHandler {
    public void create(GoogleMap mMap, FacebookEvent event){
        mMap.addMarker(new MarkerOptionsFactory().getOptions(event)).setTag(event);
    }
}
