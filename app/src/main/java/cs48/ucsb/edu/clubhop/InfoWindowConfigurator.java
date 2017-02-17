package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by Joel on 2/17/2017.
 */

public class InfoWindowConfigurator {
    public void config(Marker marker) {
        String title = "An Awesome Event";
        String desc = "I'm and event description and I'm describing things WUBABLUBADUBDUB";
        marker.setTitle(title);
        marker.setSnippet(desc);
    }
}
