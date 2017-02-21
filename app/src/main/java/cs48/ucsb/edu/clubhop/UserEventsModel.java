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
    private boolean isCreated = false;

    private OnChangeListener listener;

    //JSONArray events;
    private ArrayList<FacebookEvent> events = new ArrayList<>();

    private static UserEventsModel instance;

    public static UserEventsModel getInstance() {
        if (instance == null)
            instance = new UserEventsModel();
        return instance;
    }

    public void loadJSON(JSONArray eventArray) {
        for (int i = 0; i < eventArray.length(); ++i) {
            try {
                FacebookEvent e = new FacebookEvent(eventArray.getJSONObject(i));
                events.add(e);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
        listener.onChange();
    }

    private UserEventsModel() {

    }

    public interface OnChangeListener {
        void onChange();
    }

    public FacebookEvent getEvent(int index) {
        return events.get(index);
    }

    public int getSize() {
        return events.size();
    }

    public boolean isCreated() { return isCreated; }

    public void setOnChangeListener(OnChangeListener listener) { this.listener = listener; }
}