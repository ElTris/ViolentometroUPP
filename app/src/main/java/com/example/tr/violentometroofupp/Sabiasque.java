package com.example.tr.violentometroofupp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Sabiasque extends AppCompatActivity {

    TextView titulo,sabias;
    ImageView imageViolentometro;
    Typeface Quicksand;
    String tipografica="fuentes/letra3.ttf";
    Animation fades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabiasque);
        /**Asignar los elementos del xml a las variables*/
        titulo=findViewById(R.id.tituloSabiasque);
        sabias=findViewById(R.id.textqueEs);
        imageViolentometro=findViewById(R.id.imageviolentometro);
        /**Asignar la tipografia a la variable de tipo Typeface*/
        this.Quicksand=Typeface.createFromAsset(getAssets(),tipografica);
        /**Cargar la animación a la variable fades*/
        fades= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        /** Cargar la tipografia a los textview */
        titulo.setTypeface(Quicksand);
        sabias.setTypeface(Quicksand);

        /**Cargar la imagenes con animaciones*/
        imageViolentometro.startAnimation(fades);
        titulo.startAnimation(fades);
        sabias.startAnimation(fades);



    }
}
