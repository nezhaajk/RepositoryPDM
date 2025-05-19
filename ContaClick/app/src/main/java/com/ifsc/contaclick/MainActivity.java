package com.ifsc.contaclick;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Objects;

public class
MainActivity extends AppCompatActivity {


    int i=0;
    String [] nomes= new String[]{"Mercurio", "Venus", "Terra", "Marte", "Jupter", "Saturno", "Urano", "Netuno"};
    ListView lv;
    ImageView imagePlaneta2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupera listview
        lv= findViewById(R.id.listview);

        PlanetaDao planetaDao=new PlanetaDao();//data source

        AdapterPlaneta ap=new AdapterPlaneta(this,
                R.layout.item_lista,
                planetaDao.getPlanetas());

        //Exibir a lista de planetas
        lv.setAdapter(ap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta p = planetaDao.getPlanetas().get(position);

                //Criamos uma intenção pra abrir um atividade
                Intent i = new Intent(getApplicationContext(),PlanetaActivity.class);

                i.putExtra("planeta", (CharSequence) p);

                startActivity(i);

            }
        });





    }
}