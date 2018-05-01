package com.example.apurva.eventsonsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView mytext;

    Sensor sensor;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytext=findViewById(R.id.mytext);

        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);//to get all the sensor ref

        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);//to select a particular sensor

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);//to register with event

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        mytext.setText("X:"+event.values[0]+" \nY: "+event.values[1]+"\nZ: "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
