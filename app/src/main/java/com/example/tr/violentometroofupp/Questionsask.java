package com.example.tr.violentometroofupp;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
public class Questionsask extends AppCompatActivity {




    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    int v1[]=new int[26];
    int c1=0,c2=0,c3=0,RESULTADO=0;
    int contV1=0;
    int conta=0;
    String edad,entidad,sexo,ORIENTACION,GENERO;
    TextView pregubtasMestra,tituloTip,numero;
    Animation hoja,pulsante,moveLeft;
    LinearLayout notass;
    Typeface quicksand;
    String tipografia="fuentes/letra3.ttf";
    ImageButton aceptar,cancelar,regresarask;

    /** Inicialización del arreglo que contiene las preguntas
     * con las cuales el usuario deverá llenar su información
     *
     * */

    String[]  preguntas={
            "¿Has recibido bromas hirientes?",
            "¿Eres víctima de chantaje?",
            "¿Te mienten o engañan?",
            "¿Te ignoran o aplican la ley del hielo?",
            "¿Te celan?",
            "¿Te culpan por cualquier cosa?",
            "¿Descalifican tus opiniones, comentarios o acciones?",
            "¿Te ridiculiza y/u ofende?",
            "¿Te ha humillado en público?",
            "¿Te intimida o amenaza?",
            "¿Busca controlar o prohibirte amistades, familiares, dinero, lugares, celular, vestimenta, etc.?",
            "¿Ha roto o destruido alguno de tus objetos personales?",
            "¿Ha intentado o te ha manoseado sin consentimiento?",
            "¿Has sido objeto de caricias agresivas?",
            "¿Te ha golpeado “jugando”?",
            "¿Te pellizca o araña?",
            "¿Te ha jaloneado y/o empujado?",
            "¿Te ha golpeado?",
            "¿Has recibido una patada?",
            "¿Te ha intentado aislar o encerrar?",
            "¿Alguna vez te ha amenazado de muerte?",
            "¿Te ha forzado a tener relaciones sexuales?",
            "¿Ha abusado sexualmente de ti?",
            "¿Has sido víctima de violación?",
            "¿Has sufrido alguna mutilación?",
            "¿Ha intentado quitarte la vida?"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionsask);
        /***Asignación de las variables para algunos elementos  del xml*/
        notass=(LinearLayout)findViewById(R.id.notas);
        aceptar=(ImageButton) findViewById(R.id.btnSI);
        cancelar=(ImageButton)findViewById(R.id.btnNO);
        regresarask=(ImageButton)findViewById(R.id.aksanterior);
        pregubtasMestra=(TextView)findViewById(R.id.nopreguntas);
        numero=(TextView) findViewById(R.id.nohoja);
        tituloTip=(TextView) findViewById(R.id.tituloTest);

        /**Asignación de la tipografia a sus respectivas variables*/
        hoja= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        pulsante=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        moveLeft=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
        this.quicksand=Typeface.createFromAsset(getAssets(),tipografia);
        tituloTip.setTypeface(quicksand);
        pregubtasMestra.setTypeface(quicksand);
        pregubtasMestra.setTypeface(quicksand);
        pregubtasMestra.setTextColor(getResources().getColor(R.color.tipsC));
        pregubtasMestra.setText(preguntas[conta]);
        numero.setText((conta+1)+" de 26");
        Bundle recuperacion=getIntent().getExtras();
        sexo=recuperacion.getString("sexo");
        edad=recuperacion.getString("edad");
        GENERO=recuperacion.getString("genero");
        ORIENTACION=recuperacion.getString("orientacion");
        entidad=recuperacion.getString("entidad");

        /**Verificar permisos para uso de internet durante el proceso de envio de datos*/
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(Questionsask.this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            }else{
                ActivityCompat.requestPermissions(Questionsask.this,new String[]{Manifest.permission.INTERNET}, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
        else{
        }
        regresarask.setVisibility(View.GONE);



        /**Inicio linea 118 ---> termina en linea ---> 183
         * Validación de las preguntas contestadas
         * */
        //---------------------------------------------------------------
        aceptar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(conta<=25){
                    if (conta>=0){
                        regresarask.setVisibility(View.VISIBLE);
                    }
                    v1[contV1]=1;
                    if (conta==25){
                        pregubtasMestra.setText(preguntas[(conta)]);
                    }
                    else {
                        pregubtasMestra.setText(preguntas[(conta+1)]);
                    }
                    notass.startAnimation(hoja);
                    aceptar.startAnimation(pulsante);
                    contV1++;
                    conta++;
                    if (conta+1>=26){
                        numero.setText("26 de 26");
                    }
                    else {
                        numero.setText((conta + 1) + " de 26");
                    }
                    if (conta==26){
                        for (int i=0; i<=10; i++){
                            if(v1[i]==1){
                                c1++;
                            }
                        }
                        for (int i=11; i<=20; i++){
                            if(v1[i]==1){
                                c2++;
                            }
                        }
                        for (int i=21; i<=25; i++){
                            if(v1[i]==1){
                                c3++;
                            }
                        }
                        if (c1>0){
                            RESULTADO=1;
                        }
                        if(c2>0){
                            RESULTADO=2;
                        }
                        if (c3>0){
                            RESULTADO=3;
                        }
                        if((c1+c2+c3)==0){
                            RESULTADO=0;
                        }
                        Intent vista = new Intent(Questionsask.this,Resultadostest.class);
                        vista.putExtra("resultados",RESULTADO);
                        vista.putExtra("sex",sexo);
                        vista.putExtra("eda",edad);
                        vista.putExtra("GENER",GENERO);
                        vista.putExtra("ORIENTACION",ORIENTACION);
                        vista.putExtra("enti",entidad);
                        startActivity(vista);
                        finish();
                    }
                }
            }
        });


        /**Al precionar el boton cancelar, el conteo de el rango incrementa para ser una puntuacion negativa.*/

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(conta<=25){
                    if (conta>=0){
                        regresarask.setVisibility(View.VISIBLE);
                    }
                    v1[contV1]=0;
                    if (conta==25){
                        pregubtasMestra.setText(preguntas[(conta)]);
                    }
                    else {
                        pregubtasMestra.setText(preguntas[(conta+1)]);
                    }
                    notass.startAnimation(hoja);
                    cancelar.startAnimation(pulsante);
                    conta++;
                    if (conta+1>=26){
                        numero.setText("26 de 26");
                    }
                    else {
                        numero.setText((conta + 1) + " de 26");
                    }
                    contV1++;
                    if (conta==26){
                        for (int i=0; i<=10; i++){
                            if(v1[i]==1){
                                c1++;
                            }
                        }
                        for (int i=11; i<=20; i++){
                            if(v1[i]==1){
                                c2++;
                            }
                        }
                        for (int i=21; i<=25; i++){
                            if(v1[i]==1){
                                c3++;
                            }
                        }
                        if (c1>0){
                            RESULTADO=1;
                        }
                        if(c2>0){
                            RESULTADO=2;
                        }
                        if (c3>0){
                            RESULTADO=3;
                        }
                        if((c1+c2+c3)==0){
                            RESULTADO=0;
                        }
                        Intent vista = new Intent(Questionsask.this,Resultadostest.class);
                        vista.putExtra("resultados",RESULTADO);
                        vista.putExtra("sex",sexo);
                        vista.putExtra("eda",edad);
                        vista.putExtra("GENER",GENERO);
                        vista.putExtra("ORIENTACION",ORIENTACION);
                        vista.putExtra("enti",entidad);
                        startActivity(vista);
                        finish();
                    }
                }
            }
        });
        regresarask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(conta>0){
                    if (conta==1){
                        regresarask.setVisibility(View.GONE);
                    }
                    contV1--;
                    notass.startAnimation(moveLeft);
                    regresarask.startAnimation(moveLeft);
                    conta--;
                    numero.setText((conta+1)+" de 26");
                    pregubtasMestra.setText(preguntas[conta]);
                }
            }
        });
    }


    /**Este Método sobreescrito nos permite obtener los permisos que el ususario esté de acuerdo aceptar*/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // El usuario acepto los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_SHORT).show();
                }else{
                    // Permiso denegado.
                    Toast.makeText(this, "No aceptó permisos", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}