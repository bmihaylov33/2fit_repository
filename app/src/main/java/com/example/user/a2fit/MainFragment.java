package com.example.user.a2fit;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainFragment extends Fragment {

    User user = new User();
    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;

    private TextView textSensetive;

    private TextView textViewSteps;

    private TextView textViewCalories;

    private TextView name;
    private TextView age;
    private TextView weight;
    private TextView height;
    private TextView gender;

    private Button buttonResetS;
    private Button buttonResetC;

    private SensorManager sensorManager;

    private float previousY;
    private float currentY;
    private int numSteps;
    private int numCal;

    private SeekBar seekBar;
    private  int threshold; //Point at which we want to trigger a 'step'


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        user.load(getActivity());

        SharedPreferences prefs = this.getActivity().getSharedPreferences("PREFS", 0);

        name = (TextView) view.findViewById(R.id.name_text);
        name.setText(prefs.getString("name", user.getName()));

//        age = (TextView) view.findViewById(R.id.age_text);
//        age.setText(prefs.getString("age", user.getAge()));
//
//        weight = (TextView) view.findViewById(R.id.weight_text);
//        weight.setText(prefs.getString("weight", user.getWeight()));
//
//        height = (TextView) view.findViewById(R.id.height_text);
//        height.setText(prefs.getString("height", user.getHeight()));
//
//        gender = (TextView) view.findViewById(R.id.gender_text);
//        gender.setText(prefs.getString("gender", user.getGender()));

//        textViewX = (TextView) view.findViewById(R.id.textViewX);
//        textViewY = (TextView) view.findViewById(R.id.textViewY);
//        textViewZ = (TextView) view.findViewById(R.id.textViewZ);

        textViewSteps = (TextView) view.findViewById(R.id.textSteps);
        textViewCalories = (TextView) view.findViewById(R.id.textCalories);
        //textSensetive = (TextView) view.findViewById(R.id.textSensetive);

        buttonResetS = (Button) view.findViewById(R.id.buttonRessetS);
        buttonResetC = (Button) view.findViewById(R.id.buttonRessetC);


        // seekBar = (SeekBar) view.findViewById(R.id.seekBar);

        //seekBar.setProgress(7);
        //seekBar.setOnSeekBarChangeListener(seekBarListener);
        threshold = 7;
        //textSensetive.setText(String.valueOf(threshold));

        //Initialize Values
        previousY = 0;
        currentY = 0;
        numSteps = 0;
        numCal = 0;

        //Enable the listener
        enableAccelerometerListening();

        buttonResetS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numSteps = 0;
                textViewSteps.setText(String.valueOf(numSteps));
            }
        });

        buttonResetC.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numCal = 0;
                textViewCalories.setText(String.valueOf(numCal));
            }
        });


        return view;
    }

    private void enableAccelerometerListening() {
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener sensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            currentY = y;

            //if step is taken
            if(Math.abs(currentY-previousY)>threshold) {
                numSteps++;
                countCalories();
                textViewSteps.setText(String.valueOf(numSteps));
            }

            //Display the values
//            textViewX.setText(String.valueOf(x));
//            textViewY.setText(String.valueOf(y));
//            textViewZ.setText(String.valueOf(z));

            //Store the previous Y
            previousY = y;
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

//    public SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
//        @Override
//        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//            //Change the treshold
//            threshold = seekBar.getProgress();
//            //Write to the TextView
//            textSensetive.setText(String.valueOf(threshold));
//        }
//
//        @Override
//        public void onStartTrackingTouch(SeekBar seekBar) {
//
//        }
//
//        @Override
//        public void onStopTrackingTouch(SeekBar seekBar) {
//
//        }
//    };

    public void countCalories() {
        int  weightC = Integer.valueOf(user.getWeight());
        double calpm = weightC/0.5;
        calpm = calpm * 0.5;
        double calp = calpm / 1400;

        numCal = (int) (numSteps * calp);
        Log.d("Calories", "in:" + numCal);
        Log.d("Calories", "in:" + calpm);

        textViewCalories.setText(String.valueOf(numCal));
    }

}
