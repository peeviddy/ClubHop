package cs48.ucsb.edu.clubhop;

/**
 * A listener that will be notified when the model changes.
 */
public interface ModelListener {
  // Maybe refactor this into just a general listener?
  public interface ModelListener {
      public void onChange();
}
