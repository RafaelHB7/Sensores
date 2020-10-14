package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    List<Sensor> sensorList;
    ListView listView;
    SensorAdapter sensorAdapter;

    ArrayList<MeuSensor> mSensores = new ArrayList<MeuSensor>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor s: sensorList) {
            sensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
            MeuSensor meuSensor = new MeuSensor(s);
            mSensores.add(meuSensor);
        }

        sensorAdapter = new SensorAdapter(this, R.layout.sensor, mSensores);

        listView.setAdapter(sensorAdapter);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (MeuSensor s: mSensores) {
            if (s.getSensor() == event.sensor) {
                s.setValor(event.values[0]);
            }
        }
        sensorAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}