package com.example.tr.violentometroofupp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Dev1 extends AppCompatActivity {

    ImageView facebook,twitter,gmail,instagram;
    TextView nombre,descripcion;
    Animation foto,boton,textos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dev1);


        facebook=findViewById(R.id.face);
        twitter=findViewById(R.id.twitter);
        gmail=findViewById(R.id.gmail);
        instagram=findViewById(R.id.instagram);
        nombre=findViewById(R.id.nombre);
        descripcion=findViewById(R.id.descripcion);


        boton= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        foto=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        textos=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        facebook.startAnimation(boton);
        twitter.startAnimation(boton);
        gmail.startAnimation(boton);
        instagram.startAnimation(boton);
        nombre.startAnimation(textos);
        descripcion.startAnimation(textos);


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/pabito.navidad?ref=br_rs");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://twitter.com/pablodcm179?s=08");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             sendEmail();
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/pablo_david_cm/?hl=en");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    protected void sendEmail() {
        String[] TO = {"castillo.morales.pablo.prog@gmail.com"}; //aquí pon el correo
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
// Esto podrás modificarlo si quieres, el asunto y el cuerpo del mensaje
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Escribe aquí tu mensaje");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Dev1.this, "", Toast.LENGTH_SHORT).show();
        }
    }
}
