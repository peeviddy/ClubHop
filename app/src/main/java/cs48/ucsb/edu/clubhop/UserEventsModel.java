package cs48.ucsb.edu.clubhop;

import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by patrick on 2/20/17.
 */

public class UserEventsModel {

    private User user;
    private boolean isCreated = false;

    //private ModelListener listener;
    private ArrayList<ModelListener> listeners = new ArrayList<>();

    //JSONArray events;
    private ArrayList<FacebookEvent> events = new ArrayList<>();

    private static UserEventsModel instance;

    public static UserEventsModel getInstance() {
        if (instance == null)
            instance = new UserEventsModel();
        return instance;
    }

    public void setUser(JSONObject userJSON) {
        try {
            user = new User(userJSON.getInt("id"), userJSON.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadJSONArray(JSONArray eventArray) {
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
        notifyListeners();
    }

    private UserEventsModel() {

    }


    public FacebookEvent getEvent(int index) {
        return events.get(index);
    }

    public int getSize() {
        return events.size();
    }

    public boolean isCreated() { return isCreated; }

    public void addListener(ModelListener listener) { this.listeners.add(listener); }

    private void notifyListeners() {
        for (int i = 0; i < listeners.size(); ++i) {
            listeners.get(i).onChange();
        }
    }


}