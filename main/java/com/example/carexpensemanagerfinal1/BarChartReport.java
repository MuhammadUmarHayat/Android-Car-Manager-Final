package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.os.Bundle;

import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartReport extends AppCompatActivity {
    ArrayList barEnteries;
    BarChart chart;
    BarData barData;
    BarDataSet barDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart_report);


        chart = (BarChart) findViewById(R.id.chart);
        getEntries();
        barDataSet=new BarDataSet(barEnteries,"Data Set");
        barData=new BarData(barDataSet);
        chart.setData(barData);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLUE);
        barDataSet.setValueTextSize(12f);


    }
    private void getEntries()
    {
        barEnteries=new ArrayList<>();
        barEnteries.add(new BarEntry(1f,2f));
        barEnteries.add(new BarEntry(2f,4f));
        barEnteries.add(new BarEntry(3f,6f));
        barEnteries.add(new BarEntry(4f,8f));
        barEnteries.add(new BarEntry(5f,10f));


    }

}