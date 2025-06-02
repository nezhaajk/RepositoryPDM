package com.ifsc.contaclick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


Button buttonCancelar, buttonSalvar, buttonDeletar;
TextView tvid;

EditText editText;

public class ExibeNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibe_nota);

        Bundle b= getIntent().getExtras();
        if (b.containsKey("notas")){
            Nota nota = (Nota) b.getSerializable("nota");
        }else {
            Toast.makeText(this, "Nota vazia", Toast.LENGTH_SHORT).show();
            finish();
        }
        //associando os componentes com variaveis locais
        tvid = findViewById(R.id.textViewId);
        editText= findViewById(R.id.edNota);
        buttonCancelar= findViewById(R.id.buttonCancelar);
        buttonDeletar= findViewById(R.id.buttonDeletar);
        buttonSalvar= findViewById(R.id.buttonSalvar);


    }
}
