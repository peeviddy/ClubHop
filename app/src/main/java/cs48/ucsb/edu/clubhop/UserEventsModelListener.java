package cs48.ucsb.edu.clubhop;

/**
 * A listener that will be notified when the model changes.
 */
public interface UserEventsModelListener {
    // Maybe refactor this into just a general listener?
    public void onChange();
}
