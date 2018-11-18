package com.example.tr.violentometroofupp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Resultadostest extends AppCompatActivity {
    String ponderacion,sexo,edad,entidad;
    LinearLayout CARTA;
    TextView titulo,semaforo,resultados,semafo,semaforo2,semaforo3;
    Typeface tipografia;
    String Quicksand="fuentes/letra1.ttf";
    ImageView ayuda;
    Animation fadein,zoom;
    String GENERO,ORIENTACION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadostest);
        CARTA=findViewById(R.id.muestreo);
        titulo=findViewById(R.id.tiituloRESULTADO);
        semaforo=findViewById(R.id.semaforo1);
        semaforo2=findViewById(R.id.semaforo2);
        semaforo3=findViewById(R.id.semaforo3);
        resultados=findViewById(R.id.textoRES);
        semafo=findViewById(R.id.textosomaforo);
        ayuda=findViewById(R.id.imagenAyuda);

        this.tipografia=Typeface.createFromAsset(getAssets(),Quicksand);
        titulo.setTypeface(tipografia);
        semafo.setTypeface(tipografia);
        resultados.setTypeface(tipografia);
        titulo.setTextSize(22);
        resultados.setTextSize(22);
        ayuda.setVisibility(View.GONE);


        Bundle recuperacion=getIntent().getExtras();
        sexo=recuperacion.getString("sex");
        edad=recuperacion.getString("eda");
        GENERO=recuperacion.getString("GENER");
        ORIENTACION=recuperacion.getString("ORIENTACION");
        entidad=recuperacion.getString("enti");

        zoom=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        fadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        semaforo.setBackgroundColor(getResources().getColor(R.color.uno));
        semaforo2.setBackgroundColor(getResources().getColor(R.color.dos));
        semaforo3.setBackgroundColor(getResources().getColor(R.color.tres));

        if (recibirDatos()==0){
            resultados.setText("No hay violencia, mantente así.");
            ponderacion="No hay violencia, mantente así.";
            semafo.startAnimation(fadein);
            semaforo.setBackgroundColor(getResources().getColor(R.color.azul));
            semaforo2.setBackgroundColor(getResources().getColor(R.color.azul));
            semaforo3.setBackgroundColor(getResources().getColor(R.color.azul));
            Toast.makeText(this,"No hay violenicia",Toast.LENGTH_LONG).show();
        }
        if (recibirDatos()==1){
            resultados.setText("Ten cuidado, la violencia aumentará.");
            ponderacion="Ten cuidado, la violencia aumentará.";
            semafo.startAnimation(fadein);
            semaforo.startAnimation(zoom);
            Toast.makeText(this,"Usted se encuentra en color amarillo: Escala de violencia",Toast.LENGTH_LONG).show();

        }
        if(recibirDatos()==2){
            resultados.setText("¡Reacciona! no te dejes destruir.");
            ponderacion="¡Reacciona! no te dejes destruir.";
            semafo.startAnimation(fadein);
            semaforo2.startAnimation(zoom);
            ayuda.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Usted se encuentra en color naranja: Escala de violencia",Toast.LENGTH_LONG).show();
        }
        if(recibirDatos()==3){
            resultados.setText("Necesitas ayuda profesional.");
            ponderacion="Necesitas ayuda profesional.";
            semafo.startAnimation(fadein);
            semaforo3.startAnimation(zoom);
            ayuda.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Usted se encuentra en color rojo: Escala de violencia",Toast.LENGTH_LONG).show();
        }



                /*
                 * IMPLEMENTACION DEL THREAD
                 *
                 * */
                try {
                    Thread tr = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            enviarDatos(sexo,edad,GENERO,ORIENTACION,entidad,ponderacion);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                }
                            });
                        }
                    };
                    tr.start();
                }
                catch (Exception e){

                    Toast.makeText(getApplicationContext(),"Compruebe conexión a internet",Toast.LENGTH_SHORT).show();
                }


        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nueva= new Intent(Resultadostest.this,Ayuda.class);
                startActivity(nueva);
            }
        });




    }


    public int recibirDatos(){
        Bundle extras=getIntent().getExtras();
        int res=extras.getInt("resultados");
        return res;
    }



    public void enviarDatos(String sex,String ed,String genero,String orientacion,String ent,String ponderacion){
        String parametros="sexo="+sex+"&edad="+ed+"&genero="+genero+"&orientacion="+orientacion+"&entidad="+ent+"&ponderacion="+ponderacion;
        HttpURLConnection conexion= null;
        try{
            URL url= new URL("https://violentometroupp.000webhostapp.com/folder/insertar.php");
            conexion=(HttpURLConnection)url.openConnection();


            //Estableciendo metodo de envio
            conexion.setRequestMethod("POST");

            //Longitud de datos que se envian por el post
            conexion.setRequestProperty("Content-Lenght",""+Integer.toString(parametros.getBytes().length));

            //Comando para lla salida de datos
            conexion.setDoOutput(true);


            DataOutputStream wr=new DataOutputStream(conexion.getOutputStream());
            wr.writeBytes(parametros);
            wr.close();

            InputStream is= conexion.getInputStream();
        }
        catch (Exception e){}

    }



}
