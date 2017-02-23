package cs48.ucsb.edu.clubhop;

/**
 * Created by Joel on 2/17/2017.
 */

public class User {

    private int userID;
    private String name;

    public User(int _userID, String _name) {
        userID = _userID;
        name = _name;
    }

    public int getID() {
        return userID;
    }

    public String getName() {
        return name;
    }
}
