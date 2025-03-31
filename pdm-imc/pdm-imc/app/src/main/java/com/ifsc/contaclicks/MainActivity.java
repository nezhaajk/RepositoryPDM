package com.ifsc.contaclicks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int i=0;
    EditText edpeso,edaltura;
    TextView tvresulado;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edpeso=findViewById(R.id.edpeso);
        edaltura=findViewById(R.id.edaltura);
        tvresulado=findViewById(R.id.tvresultadoimc);
        buttonCalcular=findViewById(R.id.button);
        //define um tratamento para o click do botão
        buttonCalcular.setOnClickListener(v->{
            //Calcular o IMC
            //recuper os daos de peso e altura
            double peso,altura, imc;
            peso=Double.parseDouble( edpeso.getText().toString());
            altura=Double.parseDouble( edaltura.getText().toString());
            imc=peso/(altura*altura);
            //Formatando numero
            DecimalFormat decimalFormat=new DecimalFormat("##.##");

            tvresulado.setText(Double.toString(imc));
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo de vida", "metodo onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo de vida", "metodo onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo de vida", "metodo onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo de vida", "metodo onStop");
    }
}

