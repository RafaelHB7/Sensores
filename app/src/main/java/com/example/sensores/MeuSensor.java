package com.example.sensores;

import android.hardware.Sensor;

public class MeuSensor {
    Sensor sensor;
    float valor;

    public MeuSensor(Sensor sensor){
        this.sensor = sensor;
        valor = 0;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
