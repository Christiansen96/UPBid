package com.example.retea.upbid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.loadDataList(getApplicationContext());

        Button btnLogin = findViewById(R.id.button2);
        Button btnMainPage = findViewById(R.id.button1);
        Button btnClear = findViewById(R.id.button3);
        Button btnClearBought = findViewById(R.id.button4);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }


        });

        btnMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PaginaPrincipalaActivity.class));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.clear();
                Utils.saveDataList(getApplicationContext());
            }
        });

        btnClearBought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lim = itemList.size();
                for(int i = lim-1;i>=0;i--){
                    if(itemList.get(i).isVandut()){
                        itemList.remove(i);
                    }
                    Utils.saveDataList(getApplicationContext());
                }
            }
        });
    }



    }