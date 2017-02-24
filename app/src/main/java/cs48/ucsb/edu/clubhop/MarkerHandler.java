package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.vision.face.Face;

import cs48.ucsb.edu.clubhop.FacebookEvent;
import cs48.ucsb.edu.clubhop.MarkerOptionsFactory;

/**
 * Created by Joel on 2/22/2017.
 */

public class MarkerHandler {
    public void create(GoogleMap mMap, FacebookEvent event){
        mMap.addMarker(new MarkerOptionsFactory().getOptions(event)).setTag(event);
    }
}
