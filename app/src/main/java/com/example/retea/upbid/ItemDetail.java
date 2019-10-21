package com.example.retea.upbid;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.retea.upbid.MainActivity.itemList;

public class ItemDetail extends AppCompatActivity {
    TextView nume;
    TextView descriere;
    TextView pretStart;
    TextView pretBuyout;
    TextView pretCurent;
    Button buyoutBtn;
    Button licitBtn;
    TextInputEditText sumaLicitata;
    TextView stareItem;
    int pozitie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        nume = findViewById(R.id.tvNumeDet);
        descriere = findViewById(R.id.tvDescriereDet);
        pretStart = findViewById(R.id.tvPretStartDet);
        pretBuyout = findViewById(R.id.tvPretBuyoutDet);
        pretCurent = findViewById(R.id.tvPretCurentDet);
        buyoutBtn = findViewById(R.id.btn_buyout);
        licitBtn = findViewById(R.id.btn_liciteaza);
        sumaLicitata = findViewById(R.id.editTextInput);
        stareItem = findViewById(R.id.tvVandut);
        getIncomingIntent();

        buyoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemList.get(pozitie).isVandut()){
                    buyoutBtn.setError("Deja vandut");
                }else{
                itemList.get(pozitie).setVandut(true);
                itemList.get(pozitie).setAuctioned(false);
                itemList.get(pozitie).setPretCurent(itemList.get(pozitie).getPretBuyout());
                stareItem.setText("VANDUT!");
                pretCurent.setText(String.valueOf(itemList.get(pozitie).getPretBuyout()));
                Utils.saveDataList(getApplicationContext());
                buyoutBtn.setError(null);
                }
            }
        });

        licitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateSumaLic()){
                itemList.get(pozitie).setPretCurent(Integer.valueOf(sumaLicitata.getText().toString()));
                itemList.get(pozitie).setAuctioned(true);
                pretCurent.setText(String.valueOf(itemList.get(pozitie).getPretCurent()));
                stareItem.setText("Licitatie in desfasurare");
                Utils.saveDataList(getApplicationContext());
                }
            }
        });

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("itemPosition")) {
            int itemPos = getIntent().getIntExtra("itemPosition", 0);
            setItem(itemPos);
            pozitie = itemPos;
        }
    }

    private void setItem(int pos) {

        nume.setText(itemList.get(pos).getNume());
        descriere.setText(itemList.get(pos).getDescr());
        pretStart.setText(String.valueOf(itemList.get(pos).getPretStart()));
        pretBuyout.setText(String.valueOf(itemList.get(pos).getPretBuyout()));
        if (itemList.get(pos).isAuctioned()) {
            pretCurent.setText(String.valueOf(itemList.get(pos).getPretCurent()));
            stareItem.setText("Licitatie in desfasurare");
        } else{
            pretCurent.setText("Nelicitat");
            stareItem.setText("Nelicitat");
            itemList.get(pos).setPretCurent(itemList.get(pos).getPretStart());
        }
        if(itemList.get(pos).isVandut()){
            stareItem.setText("VANDUT!");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ItemDetail.this, ListaItemsActivity.class));

    }

    private boolean validateSumaLic() {
        String vPretS = sumaLicitata.getText().toString().trim();
        if(itemList.get(pozitie).isVandut()){
            sumaLicitata.setError("Obiect deja vandut!");
            return false;
        }
        if (vPretS.isEmpty()){
            sumaLicitata.setError("Campul trebuie completat");
            return false;
        }
      /*  if (Integer.valueOf(vPretS) <= itemList.get(pozitie).getPretCurent()) {
            sumaLicitata.setError("Suma prea mica");
            return false;
        }*/
        if (Integer.valueOf(vPretS) <= itemList.get(pozitie).getPretStart()) {
            sumaLicitata.setError("Suma prea mica");
            return false;
        }
        if (Integer.valueOf(vPretS) >= itemList.get(pozitie).getPretBuyout()) {
            sumaLicitata.setError("Suma prea mare");
            return false;
        }
        else{
            sumaLicitata.setError(null);
            return true;
        }
    }
}