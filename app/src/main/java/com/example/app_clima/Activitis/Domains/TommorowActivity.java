package com.example.app_clima.Activitis.Domains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_clima.Activitis.Adapter.TommorowAdapter;
import com.example.app_clima.Activitis.MainActivity;
import com.example.app_clima.R;

import java.util.ArrayList;

public class TommorowActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterTommorow;
    private RecyclerView recyclerView;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tommorow);

    initRecyclerView();
    setVariable();

}

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.back_btn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(TommorowActivity.this, MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<TommorowDomain> items=new ArrayList<>();

        items.add(new TommorowDomain("martes","storm","Storm",28,10));
        items.add(new TommorowDomain("miercoles","cloudy","Rainy_sunny",26,11));
        items.add(new TommorowDomain("jueves","cloudy_3","Cloudy",25,13));
        items.add(new TommorowDomain("viernes","cloudy_sunny","Cloudy-Sunny",27,11));
        items.add(new TommorowDomain("sabado","sun","Sunny",29,14));
        items.add(new TommorowDomain("domingo","rainy","Rainy",28,12));

        recyclerView= findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommorow=new TommorowAdapter(items);
        recyclerView.setAdapter(adapterTommorow);

    }
}
