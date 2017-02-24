package cs48.ucsb.edu.clubhop.Handlers;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class FilterHandler {

    public void setUp(Spinner filterMenu, final Context context) {
        filterMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //Toast.makeText(context, parentView.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();
                if (parentView.getItemAtPosition(position).equals("All"))
                    Toast.makeText(context, "Showing all events", Toast.LENGTH_LONG).show();
                else if (parentView.getItemAtPosition(position).equals("Today") )
                    Toast.makeText(context, "Showing events happening today",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(context, "I have no idea what you pressed",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}
