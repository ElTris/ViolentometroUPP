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

        titulo=findViewById(R.id.tituloSabiasque);
        sabias=findViewById(R.id.textqueEs);
        imageViolentometro=findViewById(R.id.imageviolentometro);

        this.Quicksand=Typeface.createFromAsset(getAssets(),tipografica);

        fades= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        titulo.setTypeface(Quicksand);
        sabias.setTypeface(Quicksand);

        imageViolentometro.startAnimation(fades);
        titulo.startAnimation(fades);
        sabias.startAnimation(fades);



    }
}
