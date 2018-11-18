package com.example.tr.violentometroofupp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Desarrolladores extends AppCompatActivity {
    ImageView cas,isl,tri,zav,upp;
    TextView referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrolladores);

        cas=findViewById(R.id.cast);
        isl=findViewById(R.id.isla);
        tri=findViewById(R.id.tris);
        zav=findViewById(R.id.zaval);
        upp=findViewById(R.id.upptargeta);
        referencia=findViewById(R.id.referencia);



        cas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev1.class);
                startActivity(intent);
            }
        });

        isl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev2.class);
                startActivity(intent);
            }
        });

        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev3.class);
                startActivity(intent);
            }
        });

        zav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev4.class);
                startActivity(intent);
            }
        });

        upp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Desupp.class);
                startActivity(intent);
            }
        });


        referencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Referencias.class);
                startActivity(intent);
            }
        });
    }
}
