package com.example.semana3_cris_tarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Confijuracion extends AppCompatActivity implements View.OnClickListener {

    private Button negro, azul, blanco;

    private ConstraintLayout fondo;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confijuracion);

        negro = findViewById(R.id.negro_boton);
        azul = findViewById(R.id.azul_boton);
        blanco = findViewById(R.id.blanco_boton);

        fondo = findViewById(R.id.fondo_del_mar);

        // tambien se debe inicializar el sharePreferences, que es el metodo que comparte
        // info a cualquier pantalla de la aplicacion.
        // getSharePreferences es para crear la carpeta para guardar los colores
        // el MODE_PRIVATE es para que solo esta aplicacion pueda acceder a esa carpeta
         preferences = getSharedPreferences("coloresCarpeta",MODE_PRIVATE);

        negro.setOnClickListener(this);
        azul.setOnClickListener(this);
        blanco.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.negro_boton:
                // se crea un string para poder guardar el codigo del color que
                // necesitamos para el fondo
                String colorNegro = "#787979";
                //con este preference estamos accesando a la carpeta
                // con el .edit() estamos editando la carpeta
                // con el putString estamos diciendo que estamos introduciendo un string
                // "color" es el nombre del espacio  donde voy a guardar el color
                // coloNegro es el nombre del string
                //apply() es para ejecutar lo anterior
                preferences.edit().putString("color",colorNegro).apply();
                // finish es para finalizar la actividad/pantalla
                finish();
                break;
            case R.id.azul_boton:

                String colorAzul= "#62d4d4";
                preferences.edit().putString("color", colorAzul).apply();
                finish();
                break;
            case R.id.blanco_boton:

                String colorBlanco= "#faf8da";
                preferences.edit().putString("color", colorBlanco).apply();
                finish();

                break;
        }
    }

    @Override
    // metodo de las actividades (pantallas) para que los cambios generados en una actividad
    // se mantengan cada que se "reinicia" otra pantalla
    protected void onResume() {
        super.onResume();

        SharedPreferences ganchoColor = getSharedPreferences("coloresCarpeta", MODE_PRIVATE);
        fondo.setBackgroundColor(Color.parseColor(ganchoColor.getString("color", "#ffffff")));
    }
}