package com.ifsc.contaclick;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlaneta extends ArrayAdapter<Planeta> {
    int mresoucer;
    public AdapterPlaneta(@NonNull Context context, int resource, @NonNull List<Planeta> objects){
        super(context, resource, objects);
        mresoucer=resource;

    }
     public View getView(int position, @NonNull View converView, @NonNull ViewGroup parent){
         LayoutInflater layoutInflater = LayoutInflater.from(getContext());
         converView= layoutInflater.inflate(mresoucer,parent,false);

         TextView tvnome= converView.findViewById(R.id.textView);
         ImageView im =converView.findViewById(R.id.imageView);

         tvnome.setText(this.getItem(position).nome);
         im.setImageResource(this.getItem(position).imagem);

         return converView;
     }
}
