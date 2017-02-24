package cs48.ucsb.edu.clubhop;

import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class EventPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        TextView titleView = (TextView) findViewById(R.id.title_view);
        titleView.setText(getIntent().getExtras().getString("Title"));
        TextView timeView = (TextView) findViewById(R.id.time_view);
        timeView.setText(getIntent().getExtras().getString("Time"));
        TextView statusView = (TextView) findViewById(R.id.status_view);
        statusView.setText(getIntent().getExtras().getString("EventType"));
        TextView locationView = (TextView) findViewById(R.id.location_view);
        locationView.setText(getIntent().getExtras().getString("Location"));
        TextView descView = (TextView) findViewById(R.id.desc_view);
        descView.setText(getIntent().getExtras().getString("Description"));
        descView.setMovementMethod( new ScrollingMovementMethod() );
    }
}
