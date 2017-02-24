package cs48.ucsb.edu.clubhop;

<<<<<<< HEAD
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

=======
>>>>>>> master
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.MarkerOptions.MarkerOptionsFactory;

/**
 *  A class that holds all of the FacebookEvents pertaining to a certain User.
 *
 *  This class is implemented as a singleton with a static instance, allowing
 *  any of the other classes in the project to access the Model's data.
 */

public class UserEventsModel {

    /**
     *  Represents the user that these events pertain to.
     */
    private User user;

    /**
     * A list of the listeners that are subscribed to the Model.
     */
    private ArrayList<UserEventsModelListener> listeners;

    /**
     * The list of events that pertain to the user.
     */
    private ArrayList<FacebookEvent> events;

    private ArrayList<Marker> eventMarkers;

    /**
     * The singleton instance of the model.
     */
    private static UserEventsModel instance;

    /**
     * @return If the instance is not created yet, it will be created. Else, it returns the instance of the UserEventSModel.
     */
    public static UserEventsModel getInstance() {
        if (instance == null)
            instance = new UserEventsModel();
        return instance;
    }


    /**
     * Sets the User that the Model pertains to based on the JSON that comes in, which should have the id and name of the User
     *
     * @param userJSON The JSONObject that has the information of the User (namely "id" and "name")
     */
    public void setUser(JSONObject userJSON) {
        try {
            user = new User(userJSON.getInt("id"), userJSON.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes in a JSONArray of events, turns them into FacebookEvents, and then adds them to the Model.
     * @param eventArray
     */
    public void loadJSONArray(JSONArray eventArray) {
        events = new ArrayList<>();
        for (int i = 0; i < eventArray.length(); ++i) {
            try {
                FacebookEvent e = new FacebookEvent();
                e.loadJSONObject(eventArray.getJSONObject(i));
                if (e.getLocation() != null)
                    events.add(e);
            } catch (JSONException e1) {
                e1.printStackTrace();
                return;
            }
        }
        notifyEventListeners();
    }

    /**
     * Private constructor that initializes listeners and events to be default ArrayLists.
     */
    private UserEventsModel() {
        listeners = new ArrayList<>();
        events = new ArrayList<>();
        eventMarkers = new ArrayList<>();
    }

    public void generateMarkers(GoogleMap map) {
        if (events.size() == 0) {
            System.out.println("No events");
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            return;
        }
        eventMarkers = new ArrayList<>();
        for (int i = 0; i < events.size(); ++i) {
            eventMarkers.add(map.addMarker(new MarkerOptionsFactory().getOptions(events.get(i))));
            eventMarkers.get(i).setTag(events.get(i));
        }
        notifyMarkerListeners();
    }

    /**
     * Returns a single event from within the Model
     * @param index The index for the desired FacebookEvent.
     * @return FacebookEvent at the given index inside of the Model.
     */
    public FacebookEvent getEvent(int index) {
        return events.get(index);
    }

    public Marker getEventMarker(int index) { return eventMarkers.get(index); }

    /**
     * @return The size of the list of FacebookEvents.
     */
    public int getSize() {
        return events.size();
    }

    /**
     * Subscribes a listener to this Model, which will be notified when the Model changes.
     *
     * @param listener A new listener that would like to subscribe to the model.
     */
    public void addListener(UserEventsModelListener listener) { this.listeners.add(listener); }

    /**
     * Tells all of the subscribed listeners that the model has changed.
     */
    private void notifyEventListeners() {
        for (int i = 0; i < listeners.size(); ++i) {
            listeners.get(i).onEventsCreated();
        }
    }

    private void notifyMarkerListeners() {
        for (int i = 0; i < listeners.size(); ++i) {
            listeners.get(i).onMarkersCreated();
        }
    }

}