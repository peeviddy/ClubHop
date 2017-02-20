package cs48.ucsb.edu.clubhop;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by patrick on 2/19/17.
 */

public class JSONWrapper {
    private JSONArray content;
    public JSONWrapper(){

        final AccessToken token = AccessToken.getCurrentAccessToken();
        //Set<String> permissions = token.getPermissions();
        //textView.setText( permissions.toString() );
        GraphRequest request = GraphRequest.newMeRequest(
                token,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            content = response.getJSONObject().getJSONObject("events").getJSONArray("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "events");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public String getContent(int index, String field ){
        try {
            return content.getJSONObject( index ).getString( field );
        } catch (JSONException e) {
            e.printStackTrace();
            return "getContent() Error!";
        }
    }
}
