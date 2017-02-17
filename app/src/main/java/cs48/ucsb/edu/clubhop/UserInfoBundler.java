package cs48.ucsb.edu.clubhop;

import android.os.Bundle;

/**
 * Created by Joel on 2/17/2017.
 */

public class UserInfoBundler {

    public Bundle makeBundle(String userId) {
        Bundle bundle = new Bundle();
        bundle.putString("UserID", userId);
        return bundle;
    }
}
