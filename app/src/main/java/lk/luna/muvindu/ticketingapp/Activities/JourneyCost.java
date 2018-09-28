package lk.luna.muvindu.ticketingapp.Activities;


import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import lk.luna.muvindu.ticketingapp.Models.Journey;
import lk.luna.muvindu.ticketingapp.R;

public class JourneyCost extends AppCompatActivity {
public static Journey journey=new Journey();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey_cost);

        BusExit_Fragment fragment = BusExit_Fragment.newInstance("","");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("classified")
                .setValue("1111xxxxyysssxx12")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"sucess",Toast.LENGTH_LONG);
                        } else {
                            Toast.makeText(getApplicationContext(),"sucess",Toast.LENGTH_LONG);
                            Log.e("fire","bb");
                        }
                    }


                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"sucess",Toast.LENGTH_LONG);
                Log.e("fire",e.getMessage());
            }
        });
//        Log.e("fire","bb");
////
//        myRef.child("classified").child(adId).
//                addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        ClassifiedAd cAd = dataSnapshot.getValue(ClassifiedAd.class);
//                        displayAdForUpdate(cAd);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        Log.d(TAG, "Error trying to get classified ad for update " +
//                                ""+databaseError);
//                    }
//                });


        // myRef.child("classified").push()
        myRef=database.getReference("1233");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value =String.valueOf (dataSnapshot.getValue());
                journey.setOnBoard((String) dataSnapshot.child("start").getValue());
                journey.setRoute((String) dataSnapshot.child("route").getValue());
                journey.setRouteNo((String) dataSnapshot.child("routeNo").getValue());


                Log.e("xx", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("xx", "Failed to read value.", error.toException());
            }
        });





    }





}
