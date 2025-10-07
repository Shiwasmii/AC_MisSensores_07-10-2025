package com.example.sensores;

public class SensorInfo {
    public final String nombre;
    public final String fabricante;
    public final int version;
    public final float potenciaMa;

    public SensorInfo(String nombre, String fabricante, int version, float potenciaMa) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.version = version;
        this.potenciaMa = potenciaMa;
    }
}


