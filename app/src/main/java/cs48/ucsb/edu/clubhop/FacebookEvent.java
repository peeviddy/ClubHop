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
    private String type;
    private String startTime;
    private String endTime;
    private String pictureURL;

    FacebookEvent(JSONObject eventObject) {

        try {

            title = eventObject.getString("name");
            description = eventObject.getString("description");
            location = new FacebookLocation(eventObject.getJSONObject("place"));
            id = eventObject.getInt("id");
            type = eventObject.getString("type");
            startTime = eventObject.getString("start_time");
            endTime = eventObject.getString("end_time");
            pictureURL = eventObject.getJSONObject("picture").getJSONObject("data").getString("url");

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

    public String getType() {
        return type;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPictureURL() {
        return pictureURL;
    }
}
