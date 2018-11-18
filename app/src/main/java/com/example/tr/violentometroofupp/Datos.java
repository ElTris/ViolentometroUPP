package com.example.tr.violentometroofupp;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class Datos extends AppCompatActivity {
    Animation slider,fades;
    LinearLayout btn1Edad,btn2Edad,btn3Edad,btn4Edad,btnHombre,btnMujer,Notas;
    Button btnsiguiente,btnsiguiente2,btnsiguiente3;
    TextView leyenda;
    String Edad="",Entidad="",Sexo="";
    String ORIENTACION,GENERO;
    Spinner estados,generos,orientacion;
    int contador=0;
    String[] Edos={
            "Aguascalientes",
            "Baja California",
            "Baja California Sur",
            "Campeche",
            "Chiapas",
            "Chihuahua",
            "Ciudad de México",
            "Coahuila",
            "Colima",
            "Durango",
            "Edo. México",
            "Guanajuato",
            "Guerrero",
            "Hidalgo",
            "Jalisco",
            "Michoacan",
            "Morelos",
            "Nayarit",
            "Nuevo León",
            "Oaxaca",
            "Puebla",
            "Querétaro",
            "Quintana Roo",
            "San Luis Potosí",
            "Sinaloa",
            "Sonora",
            "Tabasco",
            "Tlaxcala",
            "Tamaulipas",
            "Yucatán",
            "Zacatecas"
    };
    String[] geneross={
            "Femenino",
            "Masculino"
    };
    String[] Orienta={
      "Heterosexual",
      "Homosexual",
      "Bisexual"
    };
    String[] preg={
            "Por favor indica tu Sexo.",
            "Por favor indica tu Edad.",
            "Por favor indica tu Género.",
            "Por favor indica tu Orientación sexual.",
            "Entidad federativa."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);



        btn1Edad=findViewById(R.id.btnmenor16);
        btn2Edad=findViewById(R.id.btn17);
        btn3Edad=findViewById(R.id.btn26);
        btn4Edad=findViewById(R.id.mayor36);
        btnsiguiente2=findViewById(R.id.btnsiguiente2);
        btnsiguiente3=findViewById(R.id.btnsiguiente3);
        btnHombre=findViewById(R.id.btnhombre);
        btnMujer=findViewById(R.id.btnmujer);
        btnsiguiente=findViewById(R.id.btnsiguiente);
        Notas=findViewById(R.id.notas);
        leyenda=findViewById(R.id.pregs);
        //LISTADOS DE SPINNERS
        estados=findViewById(R.id.spinner);
        generos=findViewById(R.id.genero);
        orientacion=findViewById(R.id.orientacion);
        slider= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        fades=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(Datos.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(Datos.this);
        }
        builder.setTitle("¡Saber más!")
                .setMessage("¿Desea obtener más información sobre 'Violentómetro'? ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Datos.this,Sabiasque.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
            btn1Edad.setVisibility(View.GONE);
            btn2Edad.setVisibility(View.GONE);
            btn3Edad.setVisibility(View.GONE);
            btn4Edad.setVisibility(View.GONE);
            btnsiguiente.setVisibility(View.GONE);
            btnsiguiente2.setVisibility(View.GONE);
            btnsiguiente3.setVisibility(View.GONE);
            Notas.startAnimation(slider);
            leyenda.setText(preg[contador]);
            btnMujer.startAnimation(fades);
            btnHombre.setAnimation(fades);
            estados.setAdapter(new ArrayAdapter<String>(Datos.this, android.R.layout.simple_spinner_dropdown_item, Edos));
            generos.setAdapter(new ArrayAdapter<String>(Datos.this,android.R.layout.simple_spinner_dropdown_item,geneross));
            orientacion.setAdapter(new ArrayAdapter<String>(Datos.this,android.R.layout.simple_spinner_dropdown_item,Orienta));
            estados.setVisibility(View.GONE);
            generos.setVisibility(View.GONE);
            orientacion.setVisibility(View.GONE);
            /*
            * PRIMERA ELECCIÓN
            * */
        btnHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                btn1Edad.setVisibility(View.VISIBLE);
                btn2Edad.setVisibility(View.VISIBLE);
                btn3Edad.setVisibility(View.VISIBLE);
                btn4Edad.setVisibility(View.VISIBLE);
                btnHombre.setVisibility(View.GONE);
                btnMujer.setVisibility(View.GONE);
                Sexo="M";
            }
        });
        btnMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                btn1Edad.setVisibility(View.VISIBLE);
                btn2Edad.setVisibility(View.VISIBLE);
                btn3Edad.setVisibility(View.VISIBLE);
                btn4Edad.setVisibility(View.VISIBLE);
                btnHombre.setVisibility(View.GONE);
                btnMujer.setVisibility(View.GONE);
                Sexo="F";
            }
        });
        /**
        * FIN DE LA PRIMERA ELECCION
        **/
        btn1Edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                Edad="< 16";
                btn1Edad.setVisibility(View.GONE);
                btn2Edad.setVisibility(View.GONE);
                btn3Edad.setVisibility(View.GONE);
                btn4Edad.setVisibility(View.GONE);
                generos.setVisibility(View.VISIBLE);
                btnsiguiente2.setVisibility(View.VISIBLE);
            }
        });
        btn2Edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                Edad="17 - 25";
                btn1Edad.setVisibility(View.GONE);
                btn2Edad.setVisibility(View.GONE);
                btn3Edad.setVisibility(View.GONE);
                btn4Edad.setVisibility(View.GONE);
                generos.setVisibility(View.VISIBLE);
                btnsiguiente2.setVisibility(View.VISIBLE);
            }
        });
        btn3Edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                Edad="26 - 35";
                btn1Edad.setVisibility(View.GONE);
                btn2Edad.setVisibility(View.GONE);
                btn3Edad.setVisibility(View.GONE);
                btn4Edad.setVisibility(View.GONE);
                generos.setVisibility(View.VISIBLE);
                btnsiguiente2.setVisibility(View.VISIBLE);
            }
        });
        btn4Edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                Edad="36 >";
                btn1Edad.setVisibility(View.GONE);
                btn2Edad.setVisibility(View.GONE);
                btn3Edad.setVisibility(View.GONE);
                btn4Edad.setVisibility(View.GONE);
                generos.setVisibility(View.VISIBLE);
                btnsiguiente2.setVisibility(View.VISIBLE);
            }
        });
        /*
        *
        * FIN DE TERCERA ELECCIÓN*/
        generos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GENERO=(String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        orientacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ORIENTACION=(String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        estados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                Entidad=(String)adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });



        btnsiguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                generos.setVisibility(View.GONE);
                orientacion.setVisibility(View.VISIBLE);
                btnsiguiente2.setVisibility(View.GONE);
                btnsiguiente3.setVisibility(View.VISIBLE);
            }
        });


        btnsiguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notas.startAnimation(slider);
                contador++;
                leyenda.setText(preg[contador]);
                orientacion.setVisibility(View.GONE);
                estados.setVisibility(View.VISIBLE);
                btnsiguiente3.setVisibility(View.GONE);
                btnsiguiente.setVisibility(View.VISIBLE);
            }
        });



        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Datos.this,Questionsask.class);
                intent.putExtra("sexo",Sexo);
                intent.putExtra("edad",Edad);
                intent.putExtra("genero",GENERO);
                intent.putExtra("orientacion",ORIENTACION);
                intent.putExtra("entidad",Entidad);
                startActivity(intent);
               finish();
            }
        });


    }
}