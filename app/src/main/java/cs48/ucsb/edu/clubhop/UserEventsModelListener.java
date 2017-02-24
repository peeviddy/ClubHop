package cs48.ucsb.edu.clubhop;

/**
 * A listener that will be notified when the model changes.
 */
<<<<<<< HEAD:app/src/main/java/cs48/ucsb/edu/clubhop/ModelListener.java
// Maybe refactor this into just a general listener?
public interface ModelListener {
    public void onEventsCreated();
    public void onMarkersCreated();
=======
public interface UserEventsModelListener {
    // Maybe refactor this into just a general listener?
    public void onChange();
>>>>>>> master:app/src/main/java/cs48/ucsb/edu/clubhop/UserEventsModelListener.java
}
