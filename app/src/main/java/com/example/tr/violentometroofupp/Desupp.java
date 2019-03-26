package com.example.tr.violentometroofupp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Desupp extends AppCompatActivity {
    /** Declaración de las imagenes que en este caso serán utilizados en forma de botones devido a sus propiedades*/
    ImageView facebook,gmail,twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desupp);

        /** Asignación de elementos de los recursos xml*/
        facebook=findViewById(R.id.face);
        gmail=findViewById(R.id.gmail);
        twitter=findViewById(R.id.twitter);

        /** Al presionar la imagen te envia a un activity en facebook*/
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/UPPachuca/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        /** Al presionar la imagen te envia a un activity en gmail*/
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendEmail();
            }
        });


        /** Al presionar la imagen te envia a un activity en twitter*/
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://twitter.com/UPPachuca");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }


    /** Método para el envio de mensajes por medio de gmail*/
    protected void sendEmail() {
        String[] TO = {"upp@upp.edu.mx"}; //aquí pon el correo
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
            Toast.makeText(Desupp.this, "", Toast.LENGTH_SHORT).show();
        }
    }
}
