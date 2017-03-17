package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.Facebook.FacebookEvent;

/**
 * Created by Joel on 3/1/2017.
 */

public class CriteriaPublic implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> publicEvents = new ArrayList<FacebookEvent>();

        for(FacebookEvent event : events) {
            if(event.getType().equals("public")){
                publicEvents.add(event);
            }
        }
        return publicEvents;
    }
}
