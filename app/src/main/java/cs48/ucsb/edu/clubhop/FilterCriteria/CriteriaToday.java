package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CancellationException;

import cs48.ucsb.edu.clubhop.FacebookEvent;

/**
 * Created by Joel on 3/1/2017.
 */

public class CriteriaToday implements Criteria {
    @Override
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events) {
        ArrayList<FacebookEvent> todayEvents = new ArrayList<FacebookEvent>();
        Date today = new Date();
        for(FacebookEvent event : events) {
            if( (event.getStartTime().getYear() == today.getYear())
                    && (event.getStartTime().getMonth() == today.getMonth())
                    && (event.getStartTime().getDate() == today.getDate()) ) {
                todayEvents.add(event);
            }
        }
        return todayEvents;
    }
}
