package cs48.ucsb.edu.clubhop;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A Location contains coordinates and a name.
 */

public class FacebookLocation {

	/**
	 * The name of the Location.
	 */
    private String name;

	/**
	 * The latitude of the Location.
	 */
    private double latitude;

	/**
	 * The longitude of the Location
	 */
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

	/**
	 * @return name of the location.
	 */
    public String getName() {
        return name;
    }

	/**
	 * @return latitude of the location.
	 */
    public double getLatitude() {
        return latitude;
    }

	/**
	 * @return longitude of the location.
	 */
    public double getLongitude() {
        return longitude;
    }
}
