package com.example.semana3_cris_tarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    private TextView primerText, notaText;
    private Button calcularAgain;
    private ConstraintLayout fondo;

    private String nombre, nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        primerText = findViewById(R.id.intro_a_la_nota);
        notaText = findViewById(R.id.NOTA);
        calcularAgain = findViewById(R.id.CALCULA_OTRA_VEZ_BOBIS);
        fondo = findViewById(R.id.fondo_final);
        nombre = getIntent().getExtras().getString("espacioNombre");
        nota = getIntent().getExtras().getString("promedio");

        primerText.setText("Hola, " + nombre + " tu nota final es de: ");
        notaText.setText(nota);

        //calcularAgain.setOnClickListener(this);
        calcularAgain.setOnClickListener((v)->{
            finish();
        });
    }
    protected void onResume() {
        super.onResume();

        SharedPreferences ganchoColor = getSharedPreferences("coloresCarpeta", MODE_PRIVATE);
        fondo.setBackgroundColor(Color.parseColor(ganchoColor.getString("color", "#ffffff")));

    }


    /*public void onClick(View view) {
        finish();
    }*/
}