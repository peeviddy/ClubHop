package cs48.ucsb.edu.clubhop.User;

/**
 * A listener that will be notified when the model changes.
 */
// Maybe refactor this into just a general listener?
public interface UserEventsModelListener {
    public void onEventsCreated();
    public void onMarkersCreated();
    public void onUserChanged();
}
