package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.FacebookEvent;

/**
 * Created by Joel on 3/1/2017.
 */

public class CriteriaToday implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> todayEvents = new ArrayList<FacebookEvent>();

        // TODO: 3/1/2017 fix implementation when times are formatted correctly
        for(FacebookEvent event : events) {
            if(true){
                todayEvents.add(event);
            }
        }
        return todayEvents;
    }
}
