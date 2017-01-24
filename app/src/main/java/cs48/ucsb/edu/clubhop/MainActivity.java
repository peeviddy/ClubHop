package cs48.ucsb.edu.clubhop;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;

    TextView textView;
    CallbackManager callbackManager;

    Intent intent = new Intent(this, MapsActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        textView = (TextView) findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textView.setText("Hello, "/* + Profile.getCurrentProfile().getFirstName()*/);
                //setText for if you logout successfully too???






                startActivity(intent);
            }

            @Override
            public void onCancel() {
                textView.setText( "Login Cancelled" );
            }

            @Override
            public void onError(FacebookException error) {
                textView.setText( "Login Error" );
            }
        });

    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void testButton(View view){
        startActivity(intent);
    }
}
