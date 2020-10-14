package com.example.sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SensorAdapter extends ArrayAdapter<MeuSensor> {
    Context context;
    int resource;
    String valor = "0";

    public SensorAdapter(Context context, int resource, List<MeuSensor> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        TextView nome = convertView.findViewById(R.id.textViewNome);
        TextView tvValor = convertView.findViewById(R.id.textViewValor);

        MeuSensor meuSensor = getItem(position);

        nome.setText(meuSensor.sensor.getName());
        tvValor.setText(""+meuSensor.getValor());

        return convertView;
    }

    public void setValor(float valor){
        this.valor =  Float.toString(valor);
    }
}
