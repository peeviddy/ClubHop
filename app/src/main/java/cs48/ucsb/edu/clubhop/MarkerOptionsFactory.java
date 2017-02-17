package cs48.ucsb.edu.clubhop;

import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Joel on 2/17/2017.
 */

public class MarkerOptionsFactory {

    /*Will create options based on type of event, can later change to take an arg of event type instead
    public MarkerOptions getOptions(Event event){
        *//* TODO: 2/17/2017 Obviously everything related to event objects is placeholder stuff and will need to be fixed

        EventType type = event.getType();
        if(type == publicEvent){
            return new PublicMarkerOptions().generate(event.getLoc());
        }
        else if(type == privateEvent){
            return new PrivateMarkerOptions().generate(event.getLoc());
        }
        else if(type == communityEvent){
            return new CommunityMarkerOptions().generate(event.getLoc());
        }
        else if(type == groupEvent){
            return new GroupMarkerOptions().generate(event.getLoc());
        }
        else {
            return new MarkerOptions().position(event.getLoc());
        }
    }*/
}
