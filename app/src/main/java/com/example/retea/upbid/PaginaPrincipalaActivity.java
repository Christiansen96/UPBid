package com.example.retea.upbid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaginaPrincipalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principala);

        Button btnListait = (Button)findViewById(R.id.buttonListaIt);
        Button btnCont = (Button)findViewById(R.id.buttonCont);
        Button btnAddIt = (Button)findViewById(R.id.buttonAddIt);


        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaginaPrincipalaActivity.this, ContulMeuActivity.class));
            }
        });

        btnListait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaginaPrincipalaActivity.this, ListaItemsActivity.class));
            }
        });
        btnAddIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaginaPrincipalaActivity.this, AddItemActivity.class));
            }
        });

    }
}
