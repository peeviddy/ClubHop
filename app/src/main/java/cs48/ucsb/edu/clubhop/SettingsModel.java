package cs48.ucsb.edu.clubhop;

import android.content.res.Resources;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by bryannaphan on 2/23/17.
 */

/**
 *  A class that holds all of the Settings chosen by a user.
 *
 *  This class is implemented as a singleton with a static instance, allowing
 *  any of the other classes in the project to access the Model's data.
 */

public class SettingsModel {

    private String styleType;
    //private MapsActivity mapsActivity;
    //private GoogleMap map;

    /**
     * A list of the listeners that are subscribed to the SettingsModel.
     */
    private ArrayList<SettingsModelListener> listeners;

    /**
     * The singleton instance of the model.
     */
    private static SettingsModel instance;

    /**
     * Private constructor that initializes listeners and events to be default ArrayLists.
     */
    private SettingsModel() {
        listeners = new ArrayList<>();
        styleType = "";
    }

    /**
     * @return If the instance is not created yet, it will be created.
     * Else, it returns the instance of the SettingsModel.
     */
    public static SettingsModel getInstance() {
        if (instance == null)
            instance = new SettingsModel();
        return instance;
    }

    /**
     * Subscribes a listener to this Model, which will be notified when the Model changes.
     *
     * @param listener A new listener that would like to subscribe to the model.
     */
    public void addListener(SettingsModelListener listener) {
        this.listeners.add(listener);
    }

    /*
    public void setMapsActivity(MapsActivity mapsActivity) {
        this.mapsActivity = mapsActivity;
    }
    */

    public void setStyleType(String styleType) {

        if (styleType != null) {
            this.styleType = styleType;
        } else {
            this.styleType = "standard";
        }

        notifyListeners();
    }

    public String getStyleType() {
        return styleType;
    }

    /**
     * Tells all of the subscribed listeners that the model has changed.
     */
    private void notifyListeners() {
        for (int i = 0; i < listeners.size(); ++i) {
            listeners.get(i).onStyleChange();
        }
    }

}
