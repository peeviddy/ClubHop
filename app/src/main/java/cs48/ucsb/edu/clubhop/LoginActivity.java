package cs48.ucsb.edu.clubhop;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    LoginButton loginButton;
    JSONArray content;
    TextView textView;
    CallbackManager callbackManager;


    final private int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_events");
        textView = (TextView) findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        final Intent intent = new Intent(this, MapsActivity.class);

        checkPermission();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                final AccessToken token = AccessToken.getCurrentAccessToken();

                GraphRequest request = GraphRequest.newMeRequest(
                        token,
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try {
                                    content = response.getJSONObject().getJSONObject("events").getJSONArray("data");
                                    UserEventsModel.getInstance().loadJSON(content);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //textView.setText( response.getRawResponse() );
                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "name, events"); // literally wont give us events
                request.setParameters(parameters);
                request.executeAsync();

                //ASSUMING USER ID CAN BE STORED AS A STRING
                //User user = new User("123PLACEHOLDER", "John Doe");
                //Bundle userBundle = new UserInfoBundler().makeBundle(user);
                startActivity(intent);
                //startActivity(intent, userBundle);
            }

            @Override
            public void onCancel() {
                textView.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                textView.setText("Login Error");
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void testButton(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
