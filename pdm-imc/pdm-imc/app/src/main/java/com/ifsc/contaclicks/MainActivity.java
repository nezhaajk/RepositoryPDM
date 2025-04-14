package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

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
        tvresulado = findViewById(R.id.tvimc);
        buttonCalcular = findViewById(R.id.button);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edipeso = edpeso.getText().toString();
                String edialtura = edaltura.getText().toString();

                if (edipeso.isEmpty() || edialtura.isEmpty()){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos" , Toast.LENGTH_SHORT).show();

                }
                double peso = Double.parseDouble(edipeso);
                double altura = Double.parseDouble(edialtura);
                double imc = peso / (altura*altura);

                Intent intent = new Intent(MainActivity.this, MainActivityB.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("imc", imc);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }
}
