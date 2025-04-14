package com.ifsc.contaclicks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityB extends AppCompatActivity {

    TextView textResultado, textClassificacao;
    Button buttonVoltar;
    ImageView imcImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);


        textResultado = findViewById(R.id.textResultado);
        textClassificacao = findViewById(R.id.textClassificacao);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        imcImage = findViewById(R.id.imcImage);


        double imc = getIntent().getExtras().getDouble("imc");

        textResultado.setText(String.format("Seu imc é: %.2f", imc));
        textClassificacao.setText(getClassificacao(imc));


        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //Volta pra tela inicial

            }
        });
    }

    private String getClassificacao(double imc) {
        if (imc < 18.5) {
            imcImage.setImageResource(R.drawable.abaixopeso);
        } else if (imc < 25) {
            imcImage.setImageResource(R.drawable.normal);
        } else if (imc < 30) {
            imcImage.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 35) {
            imcImage.setImageResource(R.drawable.obesidade1);
        } else if (imc < 40) {
            imcImage.setImageResource(R.drawable.obesidade2);
        } else {
            imcImage.setImageResource(R.drawable.obesidade3);


        }
    }
}