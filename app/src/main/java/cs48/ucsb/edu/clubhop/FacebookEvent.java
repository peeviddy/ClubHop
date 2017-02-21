package cs48.ucsb.edu.clubhop;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by patrick on 2/20/17.
 */

public class FacebookEvent {
    //private JSONObject jsonObject;
    private String title;
    private String description;
    int id;
    FacebookLocation location;

    FacebookEvent(JSONObject eventObject) {

        try {
            //this.jsonObject = jsonObject;
            // title = json.getTitle();
            title = eventObject.getString("name");

            // description = json.getDescription();
            description = eventObject.getString("description");

            // location = json.getLocation();
            location = new FacebookLocation(eventObject.getJSONObject("place"));

            id = eventObject.getInt("id");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public FacebookLocation getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }
}
