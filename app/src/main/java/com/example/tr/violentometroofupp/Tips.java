package com.example.tr.violentometroofupp;

import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class Tips extends AppCompatActivity {

    //private TextSwitcher tipsText;
    ImageView sig,reg;
    Animation move,moveleft;
    LinearLayout notaTip;
    Typeface quicksand;
    TextView consejos,tituloTip;
    String tipografia="fuentes/letra3.ttf";

    String[] QUOTES={
            "*Infórmate del tema \nAl principio puede parecerte inútil, pero te sorprenderías de la cantidad de personas que desconocen aspectos cruciales sobre la violencia familiar.\n" +
                    "\n" +
                    "Esa ignorancia puede transformarte en una víctima indefensa.\n" +
                    "\n" +
                    "Leer publicaciones en distintos sitios web o hablar con profesionales, puede ayudarte a identificar y prevenir situaciones de violencia.   [2]",



            "*Genera y fomenta un ámbito de respeto\n" +
                    "\n" +
                    "Como integrante de la pareja y de una familia, siempre debes comunicarte con respeto. No hay razón ni circunstancia que justifique un maltrato físico o psicológico.\n" +
                    "\n" +
                    "Ten presente que el respeto no solo implica hablar sin gritar por ejemplo, también significa saber aceptar las diferencias; ser tolerante frente a lo que no nos gusta, sin que eso implique que lo aceptemos a cualquier precio.  [2]",


            "*No consientas la violencia física\n" +
                    "\n" +
                    "Así sea una mera cachetada o un simple tirón de brazo, por ejemplo, nunca lo permitas. Si te ha ocurrido una vez, no permitas jamás que eso se repita.\n" +
                    "\n" +
                    "La decisión de alejarte del agresor o incluso de presentar una denuncia por agresión física es tuya, y si deseas dar una segunda oportunidad también estás en tu derecho. Pero no confundas las situaciones, y lo más importante no te confundas tú.   [2]",

            "*Plantea claramente tus posiciones\n" +
                    "\n" +
                    "La violencia física es la más evidente, pero la psicológica puede estar “camuflada” bajo diferentes formas y es mucho más frecuente de lo que se cree.\n" +
                    "\n" +
                    "Muchas veces puedes caer en el grupo de las personas que por temor a perder a alguien, optan por callar, por ser completamente sumisas.    [2]"
    };
    int indice=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        sig=(ImageView)findViewById(R.id.btnsiguiente);
        reg=(ImageView)findViewById(R.id.btnregresar);
        consejos=(TextView)findViewById(R.id.consejosT);
        tituloTip=(TextView) findViewById(R.id.tituloTips);

        move= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        moveleft=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);

        notaTip=(LinearLayout)findViewById(R.id.nota2);
        this.quicksand=Typeface.createFromAsset(getAssets(),tipografia);

        tituloTip.setTypeface(quicksand);
        consejos.setTextColor(getResources().getColor(R.color.tipsC));
        consejos.setTypeface(quicksand);
        consejos.setText(QUOTES[indice]);

        reg.setVisibility(View.GONE);

        sig.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(indice<QUOTES.length-1){
                    if( indice>=0){
                        reg.setVisibility(View.VISIBLE);
                    }
                    if(indice>1){
                        sig.setVisibility(View.GONE);
                    }
                    indice++;
                    consejos.startAnimation(move);
                    consejos.setText(QUOTES[indice]);
                    notaTip.startAnimation(move);
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                indice--;
                if(indice<2){
                    if( indice<=2){
                        sig.setVisibility(View.VISIBLE);
                    }
                    if(indice<1){
                        reg.setVisibility(View.GONE);
                    }

                    consejos.startAnimation(moveleft);
                    consejos.setText(QUOTES[indice]);
                    notaTip.startAnimation(moveleft);
                }
            }
        });



    }
}
