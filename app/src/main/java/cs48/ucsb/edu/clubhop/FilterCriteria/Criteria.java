package cs48.ucsb.edu.clubhop.FilterCriteria;

import java.util.ArrayList;

import cs48.ucsb.edu.clubhop.FacebookEvent;


/**
 * Created by Joel on 3/1/2017.
 */

public interface Criteria {
    public ArrayList<FacebookEvent> meetCriteria(ArrayList<FacebookEvent> events);
}
