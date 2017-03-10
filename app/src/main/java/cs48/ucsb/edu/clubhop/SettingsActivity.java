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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView standardButton = (ImageView) findViewById(R.id.standardButton);
        standardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsModel.getInstance().setCurrentStyleID(R.raw.standard_style);
                Toast.makeText(SettingsActivity.this,
                        "Style type is standard",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView nightButton = (ImageView) findViewById(R.id.nightButton);
        nightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsModel.getInstance().setCurrentStyleID(R.raw.night_style);
                Toast.makeText(SettingsActivity.this,
                        "Style type is night",
                        Toast.LENGTH_SHORT).show();
            }
        });

        SettingsModel.getInstance().addListener(new SettingsModelListener() {
            @Override
            public void onStyleChange() {

            }
        });
    }
}
