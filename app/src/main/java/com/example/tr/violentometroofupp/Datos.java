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

    /** Declaración de variables que contendran valores de animaciones*/
    Animation slider,fades;

    /** Declaración de Layout que serán utilizados como botones*/
    LinearLayout btn1Edad,btn2Edad,btn3Edad,btn4Edad,btnHombre,btnMujer,Notas;
    /** Declaracion de botones*/
    Button btnsiguiente,btnsiguiente2,btnsiguiente3;
    /** Decraración de Botones */
    TextView leyenda;
    /**Declaración  de variables que almacenarán los valores  de 'Edad'  'Entidad' 'Sexo'*/
    String Edad="",Entidad="",Sexo="";
    /** Declaración de variables que almacenan la
     * Orientacion sexua del usuario = 'ORIENTACION'--> nombre de variable
     * Genero de usuario = 'GENERO'--> nombre de variable
     * */
    String ORIENTACION,GENERO;

    /** Declaración de los elementos Spinner  estados,generos,orientacion para su posterior uso*/
    Spinner estados,generos,orientacion;

    /**NOTA : Contador es una variable indispensable
     * para el correcto funcionamiento de esta app
     * es encargado de ír mostrando los elementos correspondientes
     * según su valor
     * */
    int contador=0;

    /** Lista de estados que serán ingresados dentro  de un spinner*/
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

    /** Lista de generos que serán ingresados dentro de un spinner */
    String[] geneross={
            "Femenino",
            "Masculino"
    };

    /**Lista de orientacion sexual que serán ingresados dentro de un spinner */
    String[] Orienta={
      "Heterosexual",
      "Homosexual",
      "Bisexual"
    };

    /** Preguntas que se integrarán dentro de un textview para que el usuario
     * llene correctamente los campos requeridos
     * */
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
        /** Asignación de los botones  y otros elementos utiles dentro del Layout*/
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
        estados=findViewById(R.id.spinner);
        generos=findViewById(R.id.genero);
        orientacion=findViewById(R.id.orientacion);

        /** Asignación de animaciones*/
        slider= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        fades=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);


        /**
         * SE VALIDA LA VERSION Y SDK DE ANDROID PARA LANZAR UN ALERTDIALOG DEBIDO A QUE VERSIONES MENORES
         * A LA 5 'LOLLIPOP' NO NECESITA PERMISOS EXTRAS PARA PODER MOSTRAR MENSAJES  DE VALIDACIÓN
         * */
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
                        /***
                         * SI EN EL ALERT CLICKEAS ACEPTAR SE INICIARA UNA ACTIVIDAD
                         * */

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
            /** Ingresar dentro del Spinner la lista de estados*/
            ArrayAdapter<String> adapterestados=new ArrayAdapter(this,R.layout.adapteespinner_custom,Edos);
            estados.setAdapter(adapterestados);
            /**Ingresar dentro del Spinner la lista de generos*/
            ArrayAdapter<String> adaptergeneros=new ArrayAdapter(this,R.layout.adapteespinner_custom,geneross);
            generos.setAdapter(adaptergeneros);
            /**Ingresar dentro del Spinner la lista de generos*/
            ArrayAdapter<String> adapterorientacion=new ArrayAdapter(this,R.layout.adapteespinner_custom,Orienta);
            orientacion.setAdapter(adapterorientacion);

            estados.setVisibility(View.GONE);
            generos.setVisibility(View.GONE);
            orientacion.setVisibility(View.GONE);
            /***
            * PRIMERA ELECCIÓN ("SEXO SERÁ IGUAL A MUJER SÍ EL BOTÓN ES PRESIONADO")
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


        /***
         * SEGUNDA ELECCIÓN ("SEXO SERÁ IGUAL A MUJER SÍ EL BOTÓN ES PRECIONADO")
         * */
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
        * FIN DE LA SEGUNDA ELECCION
        **/

        /**
         * SELECCION DE EDAD AL PRECIONAR BOTON "btn1Edad" DENTRO DEL "activity_datos.xml" (SI ES MENOR A 16 AÑOS DE EDAD)
         * * */
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

        /**
         * SELECCION DE EDAD AL PRECIONAR BOTON "btn2Edad" DENTRO DEL "activity_datos.xml" (SI SU EDAD ES DE 17 - 25 AÑOS)
         * * */
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

        /**
         * SELECCION DE EDAD AL PRECIONAR BOTON "btn3Edad" DENTRO DEL "activity_datos.xml" (SI SU EDAD ES DE 26 - 35 AÑOS)
         * * */
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
        /**
         * SELECCION DE EDAD AL PRECIONAR BOTON "btn4Edad" DENTRO DEL "activity_datos.xml" (SI SU EDAD ES MAYOR A 36 AÑOS)
         * * */
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
        /**
        *FIN DE SELECCION DE EDAD DENTRO DEL "activity_datos.xml"
        * */

        /**
         * SELECCIÓN DE GENERO DENTRO DEL "activity_datos.xml" CON SPINNER "generos"
         * */
        generos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GENERO=(String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**
         * FIN DE SELECCIÓN DE GENERO DENTRO DEL "activity_datos.xml" CON SPINNER "generos"
         * */


        /**
         * SELECCIÓN DE ORIENTACIÓN DENTRO DEL "activity_datos.xml" CON SPINNER "orientacion"
         * */
        orientacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ORIENTACION=(String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**
         * FIN DE SELECCIÓN DE ORIENTACIÓN DENTRO DEL "activity_datos.xml" CON SPINNER "orientacion"
         * */


        /**
         * SELECCIÓN DE ESTADOS DENTRO DEL "activity_datos.xml" CON SPINNER "estados"
         * */
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
        /**
         * FIN DE SELECCIÓN DE ESTADOS DENTRO DEL "activity_datos.xml" CON SPINNER "estados"
         * */


        /**
         * AL PRECIONAR ESTE BOTÓN SE CAMBIARÁ LA CADENA DE TÍTULO Y SERÁN VISIBLES ALGUNOS ELEMENTOS
         * */
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


        /**
         * AL PRECIONAR ESTE BOTÓN SE CAMBIARÁ LA CADENA DE TÍTULO Y SERÁN VISIBLES ALGUNOS ELEMENTOS
         * */
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


        /**
         * AL PRECIONAR ESTE BOTÓN SE ENVIARÁN LOS RESULTADOS A LA SIGUIENTE ACTIVIDAD ('Questionsask') Y POSTERIORMENTE
         * SE INICIARÁ UNA NUEVA ACTIVITY ('Questionsask')
         * */
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
