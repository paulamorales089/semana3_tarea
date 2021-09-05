package com.example.semana3_cris_tarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button configuracion, continuar;
    private EditText nombreEspacio;
    private ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuracion = findViewById(R.id.configuracion_boton);
        continuar = findViewById(R.id.continuar_boton);
        nombreEspacio = findViewById(R.id.espacio_nombre);
        fondo = findViewById(R.id.genesis);



            configuracion.setOnClickListener(
                    (v)->{
                        Intent i = new Intent(this, Confijuracion.class);
                        // el startActivity es necesario para activar al el intent del OnClick
                        startActivity(i);
                    }
            );

        continuar.setOnClickListener(
                (v)->{

                    String nombreEstudiante = nombreEspacio.getText().toString();

                    if (nombreEstudiante.isEmpty()) {
                        Toast.makeText(this,"Escribe tu mensaje baby",Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        Intent i = new Intent(this, CalculatePromediate.class);
                        // el startActivity es necesario para activar al el intent del OnClick
                        i.putExtra("espacioNombre",nombreEstudiante);
                        startActivity(i);
                    }
                }
        );
    }

    @Override
    // metodo de las actividades (pantallas) para que los cambios generados en una actividad
    // se mantengan cada que se "reinicia" otra pantalla
    protected void onResume() {
        super.onResume();

        SharedPreferences ganchoColor = getSharedPreferences("coloresCarpeta", MODE_PRIVATE);
        fondo.setBackgroundColor(Color.parseColor(ganchoColor.getString("color", "#ffffff")));
        nombreEspacio.setText("");
    }

}