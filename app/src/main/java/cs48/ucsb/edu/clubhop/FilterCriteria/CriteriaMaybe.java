package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.FacebookEvent;

/**
 * Created by Patrick on 3/11/2017.
 */

public class CriteriaMaybe implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> maybeEvents = new ArrayList<FacebookEvent>();

        for(FacebookEvent event : events) {
            if( event.getRsvp_status().equals("unsure") ){
                maybeEvents.add(event);
            }
        }
        return maybeEvents;
    }
}
