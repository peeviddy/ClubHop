package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.model.MarkerOptions;

/**
 * App defined Marker object for storing a google maps marker
 */

public class Marker {

    /**
     * Sets the marker's options by the event, using the MarkerOptionsFactory
     *
     * @param event the event associated with the marker
     */
    public Marker(Event event) {
        //options = new MarkerOptionsFactory().getOptions(event);
    }

    private MarkerOptions options;

    public MarkerOptions getOptions() {
        return options;
    }


}
