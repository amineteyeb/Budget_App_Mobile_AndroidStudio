package com.example.mobilebudget.Activity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mobilebudget.databinding.ActivityGestionFacturesBinding;

import com.example.mobilebudget.R;

import java.util.ArrayList;
import java.util.List;

public class GestionFactures extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGestionFacturesBinding binding;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_gestion_factures);
       AnyChartView anyChartView = findViewById(R.id.pie);


       Cartesian cartesian = AnyChart.column();

       List<DataEntry> data = new ArrayList<>();
       data.add(new ValueDataEntry("Rouge", 80540));
       data.add(new ValueDataEntry("Foundation", 94190));
       data.add(new ValueDataEntry("Mascara", 102610));
       data.add(new ValueDataEntry("Lip gloss", 110430));
       data.add(new ValueDataEntry("Lipstick", 128000));
       data.add(new ValueDataEntry("Nail polish", 143760));
       data.add(new ValueDataEntry("Eyebrow pencil", 170670));
       data.add(new ValueDataEntry("Eyeliner", 213210));
       data.add(new ValueDataEntry("Eyeshadows", 249980));

       Column column = cartesian.column(data);

       column.tooltip()
               .titleFormat("{%X}")
               .position(Position.CENTER_BOTTOM)
               .anchor(Anchor.CENTER_BOTTOM)
               .offsetX(0d)
               .offsetY(5d)
               .format("${%Value}{groupsSeparator: }");

       cartesian.animation(true);
       cartesian.title("Top 10 Cosmetic Products by Revenue");

       cartesian.yScale().minimum(0d);

       cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

       cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
       cartesian.interactivity().hoverMode(HoverMode.BY_X);

       cartesian.xAxis(0).title("Product");
       cartesian.yAxis(0).title("Revenue");

       anyChartView.setChart(cartesian);
       cartesian.draw(true);
   }


}