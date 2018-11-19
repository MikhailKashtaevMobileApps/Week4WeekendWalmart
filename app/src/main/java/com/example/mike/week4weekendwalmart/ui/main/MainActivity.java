package com.example.mike.week4weekendwalmart.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mike.week4weekendwalmart.R;
import com.example.mike.week4weekendwalmart.ui.settings.SettingsActivity;
import com.example.mike.week4weekendwalmart.weather.WeatherGenerator;
import com.example.mike.week4weekendwalmart.weather.model.Temp;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView rvTodaysTemps;
    private RecyclerView rvTomorrowsTemps;
    private WeatherAdapter rvTodayAdapter;
    private WeatherAdapter rvTomorrowAdapter;
    private TextView tvSkies;
    private TextView tvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTodaysTemps = findViewById( R.id.rvTodaysTemps );
        rvTomorrowsTemps = findViewById( R.id.rvTomorrowsTemps );

        List<Temp> todaysTemps = WeatherGenerator.filterToday( WeatherGenerator.getWeather() );

        // Set now
        tvTemp = findViewById( R.id.tvTemp );
        tvSkies = findViewById( R.id.tvSkies );

        tvTemp.setText(String.format("%s°", String.valueOf( todaysTemps.get(0).getDeg() )));
        switch ( todaysTemps.get(0).getSky() ){
            case 0:
                tvSkies.setText( "Sunny" );
                break;
            case 1:
                tvSkies.setText( "Partly Cloudy" );
                break;
            case 2:
                tvSkies.setText( "Cloudy" );
                break;
        }


        setTodaysTemps( todaysTemps );
        setTomorrowsTemps( WeatherGenerator.getWeather() );

    }

    public void setTodaysTemps(List<Temp> ts){
        rvTodayAdapter = new WeatherAdapter( ts );
        rvTodaysTemps.setAdapter(rvTodayAdapter);
        rvTodaysTemps.setLayoutManager( new GridLayoutManager(this, 4){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    public void setTomorrowsTemps(List<Temp> ts){

        rvTomorrowAdapter = new WeatherAdapter( ts );
        rvTomorrowsTemps.setAdapter(rvTomorrowAdapter);
        rvTomorrowsTemps.setLayoutManager( new GridLayoutManager(this, 4){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    public void goSettings(View view) {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity( intent );
    }
}
