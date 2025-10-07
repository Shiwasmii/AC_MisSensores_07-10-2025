package com.example.sensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaSensores;
    private Button btnActualizar;
    private SensorManager gestorSensores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaSensores = findViewById(R.id.listaSensores);
        btnActualizar = findViewById(R.id.btnActualizar);

        //Llamar al servicio de sensores
        gestorSensores = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Metodo que carga la lista de los sensores
        CargarSensores();


    }

    private void CargarSensores() {
        List<Sensor> lista = gestorSensores.getSensorList(Sensor.TYPE_ALL);
        List<String> nombreSensores = new ArrayList<>();

        for(Sensor sensor : lista){
            nombreSensores.add(sensor.getName());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                nombreSensores
        );

        listaSensores.setAdapter(adaptador);
    }
}