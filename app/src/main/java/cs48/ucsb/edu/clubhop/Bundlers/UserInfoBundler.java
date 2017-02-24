package cs48.ucsb.edu.clubhop.Bundlers;

import android.os.Bundle;

import cs48.ucsb.edu.clubhop.User;

/**
 * Created by Joel on 2/17/2017.
 */

public class UserInfoBundler {

    public Bundle makeBundle(User user) {
        Bundle bundle = new Bundle();
        bundle.putInt("UserID", user.getID());
        bundle.putString("Name", user.getName());
        return bundle;
    }
}
