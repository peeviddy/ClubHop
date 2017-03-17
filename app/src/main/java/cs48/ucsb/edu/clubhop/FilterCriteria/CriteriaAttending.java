package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.User.FacebookEvent;

/**
 * Created by Patrick on 3/11/2017.
 */

public class CriteriaAttending implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> attendingEvents = new ArrayList<FacebookEvent>();

        for(FacebookEvent event : events) {
            if( event.getRsvp_status().equals("attending") ){
                attendingEvents.add(event);
            }
        }
        return attendingEvents;
    }
}
