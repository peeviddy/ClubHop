package cs48.ucsb.edu.clubhop;

/**
 * Created by Joel on 2/17/2017.
 */

public class User {

    private int userID;
    private String name;

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public int getID() {
        return userID;
    }

    public String getName() {
        return name;
    }
}
