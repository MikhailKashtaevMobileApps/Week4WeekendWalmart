package com.example.mike.week4weekendwalmart.ui.main;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.week4weekendwalmart.R;
import com.example.mike.week4weekendwalmart.weather.model.Temp;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    List<Temp> weatherData;

    public WeatherAdapter( List<Temp> weatherData ){
        this.weatherData = weatherData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.recycler_view_temp_cell, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Temp t = this.weatherData.get(i);

        viewHolder.time.setText(String.format("%s:00", String.valueOf(t.getTime())));
        viewHolder.temp.setText(String.format("%s°", String.valueOf(t.getDeg())));

        // Set Image
        Drawable d = null;
        switch ( t.getSky() ){
            case 0:
                // Clear
                d = viewHolder.itemView.getContext().getResources().getDrawable(R.drawable.ic_wb_sunny_black_24dp);
                break;
            case 1:
                d = viewHolder.itemView.getContext().getResources().getDrawable(R.drawable.ic_sun_black);
                break;
            case 2:
                d = viewHolder.itemView.getContext().getResources().getDrawable(R.drawable.ic_cloud_black_24dp);
                break;
        }
        if ( d != null ){
            viewHolder.weatherDisplay.setImageDrawable( d );
        }

    }

    @Override
    public int getItemCount() {
        return weatherData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        ImageView weatherDisplay;
        TextView temp;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            time = itemView.findViewById( R.id.tvTime );
            weatherDisplay = itemView.findViewById( R.id.weatherDisplay );
            temp = itemView.findViewById( R.id.deg );
        }
    }
}
