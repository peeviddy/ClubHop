package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import cs48.ucsb.edu.clubhop.MarkerOptions.MarkerOptionsFactory;

/**
 * A class that holds all of the FacebookEvents pertaining to a certain User.
 * <p>
 * This class is implemented as a singleton with a static instance, allowing
 * any of the other classes in the project to access the Model's data.
 */

public class UserEventsModel {

    /**
     * Represents the user that these events pertain to.
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

    /**
     * The list of ALL markers for ALL received events
     */
    private ArrayList<Marker> eventMarkers;

    private ArrayList<FacebookEvent> displayedEvents;
    private ArrayList<Marker> displayedMarkers;

    /**
     * The singleton instance of the model.
     */
    private static UserEventsModel instance;

    /**
     * Private constructor that initializes listeners and events to be default ArrayLists.
     */
    private UserEventsModel() {
        listeners = new ArrayList<>();
        events = new ArrayList<>();
        eventMarkers = new ArrayList<>();
        displayedEvents = new ArrayList<>();
        displayedMarkers = new ArrayList<>();
    }

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
     * Gets User's id for the name
     */
    public User getUser() {
        return user;
    }

    /**
     * Takes in a JSONArray of events, turns them into FacebookEvents, and then adds them to the Model.
     *
     * @param eventArray
     */

    public void addEvents(JSONArray eventArray) { // we need a function that can add to the model
        // specifically for adding not_replied events
        Date rightNow = new Date();
        for (int i = 0; i < eventArray.length(); ++i) {
            try {
                FacebookEvent e = new FacebookEvent();
                e.loadJSONObject( eventArray.getJSONObject(i) );
                if (    ( e.getLocation()!=null )//&&
                        /*( e.getEndTime().after(rightNow) || e.getStartTime().after(rightNow) )*/)
                    events.add(e);
            } catch (JSONException e1) {
                e1.printStackTrace();
                //return;
            }
        }
        notifyEventListeners();
    }
    
    /*
    public void loadJSONArray(JSONArray eventArray) {
        for (int i = 0; i < eventArray.length(); ++i) {
            try {
                FacebookEvent e = new FacebookEvent();
                e.loadJSONObject(eventArray.getJSONObject(i));
                if (e.getLocation() != null)
                    events.add(e);
            } catch (JSONException e1) {
                e1.printStackTrace();
                //return;
            }
        }
        notifyEventListeners();
    }
    */



    public void initializeMarkers(GoogleMap map) {
        if (events.size() == 0) {
            System.out.println("No events");
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!displayedMarkers.isEmpty())
            map.clear();
        eventMarkers = new ArrayList<>();
        for (int i = 0; i < events.size(); ++i) {
            eventMarkers.add(map.addMarker(new MarkerOptionsFactory().getOptions(events.get(i))));
            eventMarkers.get(i).setTag(events.get(i));
        }
        displayedMarkers = eventMarkers;
        displayedEvents = events;
        notifyMarkerListeners();
    }

    public void generateTheseMarkers(GoogleMap map, ArrayList<FacebookEvent> theseEvents) {
        if (theseEvents.size() == 0) {
            System.out.println("No events");
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            return;
        }
        map.clear();
        displayedMarkers = new ArrayList<>();
        displayedEvents = theseEvents;
        for (int i = 0; i < theseEvents.size(); ++i) {
            displayedMarkers.add(map.addMarker(new MarkerOptionsFactory().getOptions(theseEvents.get(i))));
            displayedMarkers.get(i).setTag(theseEvents.get(i));
        }
        notifyMarkerListeners();
    }

    /**
     * Returns a single event from within the Model
     *
     * @param index The index for the desired FacebookEvent.
     * @return FacebookEvent at the given index inside of the Model.
     */
    public FacebookEvent getEvent(int index) {
        return events.get(index);
    }

    public ArrayList<FacebookEvent> getEvents() {
        return events;
    }

    public Marker getEventMarker(int index) {
        return eventMarkers.get(index);
    }

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
    public void addListener(UserEventsModelListener listener) {
        this.listeners.add(listener);
    }

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
