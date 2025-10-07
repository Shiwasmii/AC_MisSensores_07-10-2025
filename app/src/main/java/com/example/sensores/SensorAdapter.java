package com.example.sensores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.SensorViewHolder> {

    private final List<SensorInfo> items = new ArrayList<>();

    public void setItems(List<SensorInfo> newItems) {
        items.clear();
        if (newItems != null) {
            items.addAll(newItems);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sensor, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        SensorInfo sensor = items.get(position);
        holder.txtName.setText(sensor.nombre);
        holder.txtVendor.setText("Fabricante: " + sensor.fabricante);
        holder.txtVersion.setText("Versión: " + sensor.version);
        holder.txtPower.setText("Consumo: " + sensor.potenciaMa + " mA");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class SensorViewHolder extends RecyclerView.ViewHolder {
        final TextView txtName;
        final TextView txtVendor;
        final TextView txtVersion;
        final TextView txtPower;

        SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtVendor = itemView.findViewById(R.id.txtVendor);
            txtVersion = itemView.findViewById(R.id.txtVersion);
            txtPower = itemView.findViewById(R.id.txtPower);
        }
    }
}


