package cs48.ucsb.edu.clubhop;

/**
 * Created by Joel on 2/17/2017.
 */

public class User {

    private String userID;
    private String name;

    public User(String _userID, String _name) {
        userID = _userID;
        name = _name;
    }

    public String getID() {
        return userID;
    }

    public String getName() {
        return name;
    }
}
