package lk.luna.muvindu.ticketingapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import lk.luna.muvindu.ticketingapp.R;

public class MainUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_ui);





    }



    /**
     * View current journey of the customer
     * correspond to view journey button
     * @param view
     */
    public void viewCurrent_Journey(View view) {
        Intent myIntent = new Intent(this, viewJourney.class);
       // myIntent.putExtra("key", value); //Optional parameter
        this.startActivity(myIntent);
    }
}
