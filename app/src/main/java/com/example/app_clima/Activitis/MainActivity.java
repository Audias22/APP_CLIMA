package com.example.app_clima.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_clima.Activitis.Adapter.HourlyAdapter;
import com.example.app_clima.Activitis.Domains.Hourly;
import com.example.app_clima.Activitis.Domains.TommorowActivity;
import com.example.app_clima.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initRecyclerView();
setVariable();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }

    private void setVariable() {
        TextView next7dayBtn=findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent( MainActivity.this, TommorowActivity.class)));
    }

    private void initRecyclerView() {

        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("11 am",28,"cloudy"));
        items.add(new Hourly("12 pm",30,"sun"));
        items.add(new Hourly("1 pm",29,"wind"));
        items.add(new Hourly("2 pm",28,"rainy"));
        items.add(new Hourly("3 pm",26,"storm"));


        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly=new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);

    }
}