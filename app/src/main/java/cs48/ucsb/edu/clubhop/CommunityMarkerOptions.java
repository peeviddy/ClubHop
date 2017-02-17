package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Joel on 2/17/2017.
 */

public class CommunityMarkerOptions extends AbstractMarkerOptions {

    @Override
    MarkerOptions generate(LatLng latLng) {
        return new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
    }
}