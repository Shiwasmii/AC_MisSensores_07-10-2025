package com.example.sensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerSensores;
    private SensorManager gestorSensores;
    private SensorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerSensores = findViewById(R.id.recyclerSensores);


        gestorSensores = (SensorManager) getSystemService(SENSOR_SERVICE);

        recyclerSensores.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new SensorAdapter();
        recyclerSensores.setAdapter(adapter);


        CargarSensores();


    }

    private void CargarSensores() {
        List<Sensor> lista = gestorSensores.getSensorList(Sensor.TYPE_ALL);
        List<SensorInfo> detalleSensores = new ArrayList<>();

        for (Sensor sensor : lista) {
            SensorInfo info = new SensorInfo(
                    sensor.getName(),
                    sensor.getVendor(),
                    sensor.getVersion(),
                    sensor.getPower()
            );
            detalleSensores.add(info);
        }

        adapter.setItems(detalleSensores);
    }
}