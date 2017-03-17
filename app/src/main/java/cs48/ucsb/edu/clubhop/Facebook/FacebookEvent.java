package cs48.ucsb.edu.clubhop.Facebook;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * An event that comes from Facebook. It contains many of the different fields that the user may desire.
 */

public class FacebookEvent {

    /**
     * The title of the Event.
     */
    private String title;

    /**
     * The description of the Event.
     */
    private String description;

    /**
     * The Facebook id of this Event.
     */
    int id;

    /**
     * The Location of the Event, which contains the coordinates of the Event and the name of the Location.
     */
    FacebookLocation location;

    /**
     * The type of the Event. The different types are public, private, community, and group.
     */
    private String type;

    /**
     * The time at which the Event begins.
     */
    private Date startTime;

    /**
     * The time at which the Event ends.
     */
    private Date endTime;

    /**
     * A URL pertaining to the picture that is set for the whole Event.
     */
    private String pictureURL;

    /**
     * User's RSVP status.
     */
    private String rsvp_status;

    /**
     * The constructor sets the Strings to empty Strings so that we don't try to access
     * a null String in the Map.
     */
    FacebookEvent() {
        title = "";
        description = "";
        id = 0;
        type = "";
		startTime = new Date(0);
		endTime = new Date(0);
        //String startTime = "";
        //String endTime = "";
        pictureURL = "";
        rsvp_status = "";
    }

    /**
     * Turns a JSONObject of an Event into a FacebookEvent.
     * @param eventObject The JSONObject containing all of the information of the Event.
     */
    public void loadJSONObject(JSONObject eventObject) { //sometimes one of the fields are null causing the crash we saw during 3/10 meeting
        try {

            title = eventObject.getString("name");
            description = eventObject.getString("description");
            location = new FacebookLocation(eventObject.getJSONObject("place"));
            id = eventObject.getInt("id");
            type = eventObject.getString("type");
            startTime = convertTime(eventObject.getString("start_time"));
            endTime = convertTime(eventObject.getString("end_time"));
            //endTime = eventObject.getString("end_time");
            pictureURL = eventObject.getJSONObject("picture").getJSONObject("data").getString("url");
            rsvp_status = eventObject.getString("rsvp_status");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Title of the event.
     */
    public String getTitle() {
        return checkForNull(title);
    }

    /**
     * @return Description of the event.
     */
    public String getDescription() {
        return checkForNull(description);
    }

    /**
     *
     * @return FacebookLocation of the Event.
     */
    public FacebookLocation getLocation() {
        return location;
    }

    /**
     *
     * @return Event's id.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return Event's type.
     */
    public String getType() {
        return checkForNull(type);
    }

    /**
     *
     * @return The time when the Event starts.
     */
    public Date getStartTime() {
		return startTime;
        //return checkForNull(startTime);
    }

    /**
     *
     * @return The time when the Event ends.
     */
    public Date getEndTime() {
		return endTime;
        //return checkForNull(endTime);
    }

    public String getRsvp_status(){
        return rsvp_status;
    }

	private Date convertTime(String stringTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
		try {
            return dateFormat.parse(checkForNull(stringTime));
        }
        catch (ParseException e) {
            e.printStackTrace();
            return new Date(0);
        }
	}

    /**
     *
     * @return The URL for the picture of the Event.
     */
    public String getPictureURL() {
        return checkForNull(pictureURL);
    }

    /**
     *
     * @param field A String that could contain something or be null.
     * @return The original String if it wasn't null. Otherwise, returns an empty String.
     */
    private String checkForNull(String field) {
        if (field == null)
            return "";
        return field;
    }
}
