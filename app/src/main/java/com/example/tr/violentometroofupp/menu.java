package com.example.tr.violentometroofupp;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Type;

import static maes.tech.intentanim.CustomIntent.customType;

public class menu extends AppCompatActivity {


    private int timer=1500;
    TextView textos,titulo;
    LinearLayout btn1,btn2,btn3,btn4;
    Typeface quicksand;
    String tipografia="fuentes/letra3.ttf";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /**Declaración de algunas variables con sus respectivos elementos dentro del xml*/
        textos=(TextView)findViewById(R.id.txtpresentation);
        titulo=(TextView)findViewById(R.id.titulo);
        btn1= (LinearLayout) findViewById(R.id.preguntas);
        btn2= (LinearLayout) findViewById(R.id.tips);
        btn3= (LinearLayout) findViewById(R.id.btnAyuda);
        btn4= (LinearLayout) findViewById(R.id.acercade);
        /**Asignar la tipografia a ciertos elementos del xml*/
        this.quicksand= Typeface.createFromAsset(getAssets(),tipografia);
        final Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        textos.setTypeface(quicksand);
        titulo.setTypeface(quicksand);
        /***Iniciar las animaciónes al cargar el view*/
        textos.startAnimation(animation);
        titulo.startAnimation(animation);
        btn1.startAnimation(animation);
        btn2.startAnimation(animation);
        btn3.startAnimation(animation);
        btn4.startAnimation(animation);

        /**Clase que permite tomar las medidas de una pantalla */
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; // ancho absoluto en pixels
        int height = metrics.heightPixels; // alto absoluto en pixels
        if (height<=800 || width<=480){
            Toast.makeText(this,"Pantalla no compatible.",Toast.LENGTH_SHORT).show();
            finish();
        }
        if (height>=2000 || width>=1500){
            Toast.makeText(this,"Pantalla no compatible.",Toast.LENGTH_SHORT).show();
            finish();
        }

        /**Envia a el layout Datos*/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this,Datos.class));
                customType(menu.this,"bottom-to-up");
            }
        });
        /**Envia a el layout Tips*/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this,Tips.class));
                customType(menu.this,"up-to-bottom");
            }
        });
        /**Envia a el Ayuda*/
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this,Ayuda.class));
                customType(menu.this,"up-to-bottom");
            }
        });
        /**Envia a el Desarrolladores*/
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(menu.this,Desarrolladores.class));
                customType(menu.this,"bottom-to-up");

            }
        });
    }
}