package com.example.tr.violentometroofupp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Desarrolladores extends AppCompatActivity {

    /** Desclaracion de los ImageView Para cada desarrollador o integrante del equipo de desarrollo*/
    ImageView cas,isl,tri,zav,upp;
    /** TextView que devido a sus propiedades será utilizado en forma de link*/
    TextView referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrolladores);

        /** Asignación de los ImageView a cada elemento con su respectivo id dentro del xml 'Desarrolladores'*/
        cas=findViewById(R.id.cast);
        isl=findViewById(R.id.isla);
        tri=findViewById(R.id.tris);
        zav=findViewById(R.id.zaval);
        upp=findViewById(R.id.upptargeta);
        referencia=findViewById(R.id.referencia);


        /** Al presionar la imagen del desarrollador 'Pablo David Castillo morales' lo enviará
         * a una activity donde dé una breve descripcion sobre el y sus redes sociales de contacto
         * */
        cas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev1.class);
                startActivity(intent);
            }
        });


        /** Al presionar la imagen del desarrollador 'Fernando Hernández Islas' lo enviará
         * a una activity donde dé una breve descripcion sobre el y sus redes sociales de contacto
         * */
        isl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev2.class);
                startActivity(intent);
            }
        });


        /** Al presionar la imagen del desarrollador 'Ismael Tristán Romero' lo enviará
         * a una activity donde dé una breve descripcion sobre el y sus redes sociales de contacto
         * */
        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev3.class);
                startActivity(intent);
            }
        });


        /** Al presionar la imagen del desarrollador 'Mauricio Zavala Gomez' lo enviará
         * a una activity donde dé una breve descripcion sobre el y sus redes sociales de contacto
         * */
        zav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Dev4.class);
                startActivity(intent);
            }
        });


        /** Al presionar la imagen de la universidad lo enviará
         * a una activity donde dé una breve descripcion
         * */
        upp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Desupp.class);
                startActivity(intent);
            }
        });



        /** Enviará a la activity Referencias donde se encontrarán todas las refferencias de donde fue tomada la información*/
        referencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Desarrolladores.this,Referencias.class);
                startActivity(intent);
            }
        });
    }
}
