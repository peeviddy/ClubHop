package cs48.ucsb.edu.clubhop;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

public class SettingsActivity extends AppCompatActivity {

    private String styleType;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView standardButton = (ImageView) findViewById(R.id.standardButton);
        standardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsModel.getInstance().setStyleType("standard");
                Toast.makeText(SettingsActivity.this,
                        "Standard Map Clicked",
                        Toast.LENGTH_SHORT).show();
                //Intent newMapsActivity = new Intent(SettingsActivity.this, MapsActivity.class);
                //SettingsActivity.this.startActivity(newMapsActivity);
            }
        });

        ImageView nightButton = (ImageView) findViewById(R.id.nightButton);
        nightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsModel.getInstance().setStyleType("night");
                Toast.makeText(SettingsActivity.this,
                        "Night Map Clicked",
                        Toast.LENGTH_SHORT).show();
                //Intent newMapsActivity = new Intent(SettingsActivity.this, MapsActivity.class);
                //newMapsActivity.putExtra("key", value); //Optional parameters
                //SettingsActivity.this.startActivity(newMapsActivity);
            }
        });

        SettingsModel.getInstance().addListener(new SettingsModelListener() {
            @Override
            public void onStyleChange() {
                /*Toast.makeText(SettingsActivity.this,
                        SettingsModel.getInstance().getStyleType(),
                        Toast.LENGTH_SHORT).show();*/
            }
        });
    }
}
