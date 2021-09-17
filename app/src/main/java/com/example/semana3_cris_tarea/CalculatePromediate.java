package com.example.semana3_cris_tarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatePromediate extends AppCompatActivity {

    private EditText proyectoParcial1, proyectoParcial2, quix, parcial1, parcial2;
    private Button calculameEsta;
    private ConstraintLayout fondo;
    private String nombre;
    private Boolean isEmpty;
    private Double prom;
    private String[] notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_promediate);

        proyectoParcial1 = findViewById(R.id.proyectoParcial1);
        proyectoParcial2 = findViewById(R.id.proyectoParcial2);
        quix = findViewById(R.id.quix);
        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);


        calculameEsta = findViewById(R.id.calcular_boton);

        fondo=findViewById(R.id.fondo_final);

        nombre = getIntent().getExtras().getString("espacioNombre");

        calculameEsta.setOnClickListener((v)->{
            isEmpty = false;
            calculo();
            if (!isEmpty) {
                Intent i = new Intent(this, Final.class);
                i.putExtra("espacioNombre", nombre);
                String promStr = String.valueOf(prom);
                i.putExtra("promedio", promStr);
                startActivity(i);
                finish();
            }
        });
    }

    private void calculo() {
        // guardando los strings de las notas, es decir lo que el usuario
        // colocó para llenar los edit text de la pantalla
        String proyectoparcial11 = proyectoParcial1.getText().toString();
        String proyectoparcial22 = proyectoParcial2.getText().toString();
        String quiz = quix.getText().toString();
        String parcial11 = parcial1.getText().toString();
        String parcial22 = parcial2.getText().toString();

        double nota1 = 0, nota2 =0, nota3 = 0, nota4 = 0, nota5=0;

        notas = new String[]{
          // aqui se esta llenando el array de strings con los strings de las notas
          proyectoparcial11,
          proyectoparcial22,
          quiz,
          parcial11,
          parcial22
        };



        if (!isEmpty){
            for (int i = 0; i < notas.length; i++){
                if(notas[i] == null || notas[i].isEmpty()){
                    Toast.makeText(this,"Escriba todas las notas ", Toast.LENGTH_LONG).show();
                    isEmpty = true;
                }else{
                    double number = Double.parseDouble(notas[i]);
                    if (number > 5){
                        Toast.makeText(this,"las notas van de 0 a 5", Toast.LENGTH_LONG).show();
                        isEmpty = true;

                    } else {
                        if ( i == 0){
                            nota1 = number;
                        } else if (i == 1){
                            nota2 = number;
                        }else if (i == 2){
                            nota3 = number;
                        }else if (i == 3){
                            nota4 = number;
                        }else if (i == 4){
                            nota5 = number;
                        }
                    }
                }
                Log.e(">>>", ""+ nota1 + "," + nota2+ "," + nota3+ "," + nota4+ "," + nota5);
                double promedio = ((nota1 * 0.25)+(nota2*0.25)+(nota3*0.20)+(nota4*0.15)+(nota5*0.15));
                prom = Math.round(promedio*100.0)/100.0;
                Log.e("<<<", "promedio: "+prom);
            }
        }

    }


    protected void onResume() {
        super.onResume();

        SharedPreferences ganchoColor = getSharedPreferences("coloresCarpeta", MODE_PRIVATE);
        fondo.setBackgroundColor(Color.parseColor(ganchoColor.getString("color", "#ffffff")));
        proyectoParcial1.setText("");
        proyectoParcial2.setText("");
        quix.setText("");
        parcial1.setText("");
        parcial2.setText("");


    }
}