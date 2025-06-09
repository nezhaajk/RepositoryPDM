package com.ifsc.contaclick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class
MainActivity extends AppCompatActivity implements SensorEventListener {


    int i=0;
    SensorManager mSensorManager;
    Sensor sensor;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        tv=findViewById(R.id.textView);

        sensor=mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tv.setText(Float.toString(sensorEvent.values[0]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}



