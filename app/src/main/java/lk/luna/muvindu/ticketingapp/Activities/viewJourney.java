package lk.luna.muvindu.ticketingapp.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import lk.luna.muvindu.ticketingapp.R;

public class viewJourney extends AppCompatActivity {

    private TextView onBoard;
    private TextView nextStop;

    private TextView currentStop;
    private TextView previousStop;
    private LinearLayout next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journey);

        onBoard = (TextView) findViewById(R.id.onBoard);
        nextStop = (TextView) findViewById(R.id.nextStop);
        currentStop = (TextView) findViewById(R.id.currentStop);
        previousStop = (TextView) findViewById(R.id.previousStop);
        next = (LinearLayout) findViewById(R.id.nextLayout);

        setJourneyListener("1122");


    }


    /**
     * Initiate firebase db reference and eventListener for data updates
     *
     * @param accountID customer account ID
     */
    void setJourneyListener(String accountID) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(accountID);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = String.valueOf(dataSnapshot.getValue());
                onBoard.setText((String) dataSnapshot.child("start").getValue());
                next.setVisibility(View.VISIBLE);

                Log.e("xx1q", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("xx1q", "Failed to read value.", error.toException());
            }
        });
    }

}
