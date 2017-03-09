package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.FacebookEvent;

/**
 * Created by Joel on 3/1/2017.
 */

public class CriteriaGroup implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> groupEvents = new ArrayList<FacebookEvent>();

        for(FacebookEvent event : events) {
            if(event.getType().equals("group")){
                groupEvents.add(event);
            }
        }
        return groupEvents;
    }
}
