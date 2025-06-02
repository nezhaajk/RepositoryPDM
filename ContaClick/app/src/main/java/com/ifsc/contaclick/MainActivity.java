package com.ifsc.contaclick;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class
MainActivity extends AppCompatActivity {


    int i=0;
    SQLiteDatabase db;
    Button buttonInsere;
    EditText editText;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("banco",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR)");
        buttonInsere=findViewById(R.id.buttonInsere);
        editText=findViewById(R.id.editText);
        listView=findViewById(R.id.listView);
        buttonInsere.setOnClickListener(v->{
            String msg =editText.getText().toString();
            if(!msg.isEmpty()) {
                insertNota(msg);
            }
        });

    }

    public void listagemNotas(){
        ArrayList<String> lista = new ArrayList<>();
        Cursor cursor= db.rawQuery("SELECT * FROM notas",null);
        if (cursor.moveToFirst()){
            do{
                Nota n = new Nota(cursor.getInt(0),cursor.getInt(1));
            }

        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        android.R.id.text1,listaNotas);
        listView.setAdapter(adapter);
    }

    public void insertNota(String txt){
        ContentValues cv=new ContentValues();
        cv.put("txt",txt);
        db.insert("notas",null,cv);
    }
}