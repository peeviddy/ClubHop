package cs48.ucsb.edu.clubhop;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by patrick on 2/20/17.
 */

public class FacebookLocation {
    private String name;
    private double latitude;
    private double longitude;

    FacebookLocation(JSONObject placeObject) {
        try {
            name = placeObject.getString("name");

            JSONObject location = placeObject.getJSONObject("location");

            latitude = location.getDouble("latitude");
            longitude = location.getDouble("longitude");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
