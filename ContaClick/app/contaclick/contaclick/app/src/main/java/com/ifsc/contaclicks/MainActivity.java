package com.ifsc.contaclicks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    SQLiteDatabase bancoDados;
    EditText editText;
    Button buttonInserir;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Associando os componentes com váriaveis locais
        editText = findViewById(R.id.editText);
        buttonInserir = findViewById(R.id.buttonInserir);
        listView = findViewById(R.id.listView);
        //Configura o banco de dados
        bancoDados = openOrCreateDatabase("banco", MODE_PRIVATE, null);
        //Cria a tabela caso não exista
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT);");
        this.listaNotas();

        buttonInserir.setOnClickListener(view -> {
            String texto = editText.getText().toString();
            if (!texto.isEmpty()) {
                inserirNota(texto);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Nota nota = (Nota) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ExibeNotaActivity.class);
                intent.putExtra("nota", nota);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        listaNotas();
    }

    public void inserirNota(String texto) {
        //bancoDados.execSQL("INSERT INTO notas (txt) VALUES ('" + texto + "');");
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", texto);
        bancoDados.insert("notas", null, contentValues);
        editText.setText("");
        this.listaNotas();
    }

    public void atualizaListagemNotas(ArrayList<Nota> lista) {
        AdapterNotas adapter = new AdapterNotas(this, R.layout.item_nota, lista);
        listView.setAdapter(adapter);
    }
    public void listaNotas() {
        ArrayList<Nota> lista = new ArrayList<Nota>();
        Cursor cursor = bancoDados.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        Nota n ;
        while (!cursor.isAfterLast()) {
            n = new Nota(cursor.getInt(0), cursor.getString(1));
            lista.add(n);
            cursor.moveToNext();
        }
        cursor.close();
        atualizaListagemNotas(lista);
    }






}