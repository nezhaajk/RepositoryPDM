package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    EditText edpeso, edaltura;
    TextView tvresulado;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edpeso = findViewById(R.id.edpeso);
        edaltura = findViewById(R.id.edaltura);
        tvresulado = findViewById(R.id.tvresultadoimc);
        buttonCalcular = findViewById(R.id.button);
        //define um tratamento para o click do botão

        Intent intent = new Intent(getApplicationContext(), MainActivityB.class);
        String msg= edpeso.getText().toString();
        intent.putExtra("mensagem", msg);
        startActivity(intent);


    }
}
