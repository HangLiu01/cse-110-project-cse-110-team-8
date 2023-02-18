package edu.ucsd.cse110.cse110group8_compass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.Manifest;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("BACK IN MAIN");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        }

        LocationService locationService = new LocationService(this);
        LiveData<Pair<Double, Double>> userCoordinates;
        userCoordinates = locationService.getLocation();

        OrientationService orientationService = new OrientationService(this);
        LiveData<Float> azimuth = orientationService.getOrientation();

        DisplayCircle displayCircle = new DisplayCircle(findViewById(R.id.compass));

        Pin northPin = new Pin();
        northPin.longitude = 135.0000;
        northPin.latitude = 90.0000;



        Float azimuthFloat;

        /*final Observer<Float> nameObserver = new Observer<Float>() {
            @Override
            public void onChanged(@Nullable final Float azimuthValue) {
                azimuthFloat = azimuthValue;
            }
        };*/

        //azimuth.observe(this, new Observer<Float>() {
        //    @Override
        //    public void onChanged(Float value) {
                // Get the data from the LiveData object here
         //       if(findViewById(R.id.friend_pin) != null ) {
         //           displayCircle.rotatePin(findViewById(R.id.friend_pin), northPin, value);
         //       }

                //Log.d("LiveDataValue", String.valueOf(value));
        //    }
       // });

        //azimuth.observe(this, observer -> {
       //     azimuthFloat = observer;
       // });


        displayCircle.setUserPin(userCoordinates);
        displayCircle.rotatePin(findViewById(R.id.friend_pin), northPin, azimuth, this);
        displayCircle.rotatePin(findViewById(R.id.friend_pin), northPin, azimuth, this);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Intent intent = getIntent();
            System.out.println("IN HERE");
            String name = intent.getStringExtra("label");
            String latit = intent.getStringExtra("latitude");
            String longit = intent.getStringExtra("longitude");
            System.out.println("fromintent: " + name + latit + longit);
            TextView textView = (TextView) findViewById(R.id.Parent);
            textView.setText(name + ": " + latit + ", " + longit);
            System.out.println("FINISHED");

            Pin pinOne = new Pin();
            pinOne.longitude = Double.valueOf(longit);
            pinOne.latitude = Double.valueOf(latit);

            System.out.println("long:" + pinOne.longitude);
            System.out.println("latitude:" +    pinOne.latitude);

            displayCircle.rotatePin(findViewById(R.id.parent_pin), pinOne, azimuth, this);

        }


//        ImageView pin1 = new ImageView(this);
//        pin1.setImageResource(R.drawable.pindrop);
//
//        ConstraintLayout compassLayout = (ConstraintLayout) findViewById(R.id.compass);
//
//        ConstraintSet c = new ConstraintSet();
//        c.clone(compassLayout);
//        c.constrainCircle(pin1.getId(), R.id.compass, 40, 90);
//        c.applyTo(compassLayout); // Apply back our ConstraintSet on ConstraintLayout.
//
//        compassLayout.addView(pin1);

    }
    
    public void onEnterLocationClick(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
    
    public void onChangeLabelClick(View view) {
        Intent intent = new Intent(this, LabelActivity.class);
        startActivity(intent);
    }

}
