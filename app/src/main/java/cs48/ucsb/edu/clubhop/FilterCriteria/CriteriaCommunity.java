package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.Facebook.FacebookEvent;

/**
 * Created by Joel on 3/1/2017.
 */

public class CriteriaCommunity implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> communityEvents = new ArrayList<FacebookEvent>();

        for(FacebookEvent event : events) {
            if(event.getType().equals("community")){
                communityEvents.add(event);
            }
        }
        return communityEvents;
    }
}
