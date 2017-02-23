package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Joel on 2/17/2017.
 */

public class Controller {
    private static UserEventsModel model = UserEventsModel.getInstance();
    //private static GoogleMap map;

    public static void setModel(UserEventsModel events) {
        model = events;
    }

    public static UserEventsModel getModel() {
        return model;
    }

    /*
    public static void setMap(GoogleMap wantedMap) {
        map = wantedMap;
    }

    public static GoogleMap getMap() {
        return map;
    }
    */

    /*
    public static void setupMap(GoogleMap map) {
        for (int i = 0; i < model.getSize(); ++i) {
            map.addMarker(new MarkerOptionsFactory().getOptions(model.getEvent(i)));
        }
    }
    */

}
