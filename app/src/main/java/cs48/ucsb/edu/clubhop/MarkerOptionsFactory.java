package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Joel on 2/17/2017.
 */

public class MarkerOptionsFactory {

    public MarkerOptions getOptions(FacebookEvent event) {
        /*
        String type = event.getType();
        if (type.equals("public")) {
            return new PublicMarkerOptions().generate(event);
        } else if (type.equals("private")) {
            return new PrivateMarkerOptions().generate(event);
        } else if (type.equals("community")) {
            return new CommunityMarkerOptions().generate(event);
        } else if (type.equals("group")) {
            return new GroupMarkerOptions().generate(event);
        }
        else {*/
            return new MarkerOptions().position(new LatLng(event.getLocation().getLatitude(), event.getLocation().getLongitude()));
        //}
    }
}
