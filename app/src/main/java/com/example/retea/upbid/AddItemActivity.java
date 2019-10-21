package com.example.retea.upbid;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.retea.upbid.MainActivity.itemList;

public class AddItemActivity extends AppCompatActivity {

    String aNume;
    String aDescriere;
    int aPretStart;
    int aPretBuyout;

    private TextInputLayout textInputNume;
    private TextInputLayout textInputPretStart;
    private TextInputLayout textInputPretBuyout;
    private TextInputLayout textInputDescriere;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        textInputNume = findViewById(R.id.text_input_nume);
        textInputPretStart = findViewById(R.id.text_input_pret_start);
        textInputPretBuyout = findViewById(R.id.text_input_pret_buyout);
        textInputDescriere = findViewById(R.id.text_input_descriere);
        button = findViewById(R.id.confirmButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName() | !validateDescriere() | !validatePretStart() | !validatePretBuyout()) {
                    return;
                }
                String succes = "Adaugare cu succes!";
                aNume = textInputNume.getEditText().getText().toString();
                aPretStart = Integer.valueOf(textInputPretStart.getEditText().getText().toString());
                aPretBuyout = Integer.valueOf(textInputPretBuyout.getEditText().getText().toString());
                aDescriere = textInputDescriere.getEditText().getText().toString();
                Item item = new Item(aNume,aDescriere,aPretStart,aPretBuyout);
                itemList.add(item);
                Toast.makeText(AddItemActivity.this, succes, Toast.LENGTH_SHORT).show();
                Utils.saveDataList(getApplicationContext());
                textInputNume.getEditText().setText(null);
                textInputPretBuyout.getEditText().setText(null);
                textInputPretStart.getEditText().setText(null);
                textInputDescriere.getEditText().setText(null);

            }
        });

    }

    private boolean validateName() {
        String vNume = textInputNume.getEditText().getText().toString().trim();
        if (vNume.isEmpty()) {
            textInputNume.setError("Campul trebuie completat");
            return false;
        } else {
            textInputNume.setError(null);
            return true;
        }
    }

    private boolean validatePretStart() {
        String vPretS = textInputPretStart.getEditText().getText().toString().trim();
        if (vPretS.isEmpty()) {
            textInputPretStart.setError("Campul trebuie completat");
            return false;
        } else {
            textInputPretStart.setError(null);
            return true;
        }
    }

    private boolean validatePretBuyout() {
        String vPretB = textInputPretBuyout.getEditText().getText().toString().trim();
        if (vPretB.isEmpty()) {
            textInputPretBuyout.setError("Campul trebuie completat");
            return false;
        }
        int mPretS = Integer.valueOf(textInputPretStart.getEditText().getText().toString());
        int mPretB = Integer.valueOf(textInputPretBuyout.getEditText().getText().toString());
            if (mPretB < mPretS) {
            textInputPretBuyout.setError("Pretul de buyout trebuie sa fie mai mare decat pretul de start");
            return false;
        } else {
            textInputNume.setError(null);
            return true;
        }
    }

    private boolean validateDescriere() {
        String vDescr = textInputDescriere.getEditText().getText().toString();
        if (vDescr.isEmpty()) {
            textInputDescriere.setError("Campul trebuie completat");
            return false;
        } else {
            textInputDescriere.setError(null);
            return true;
        }
    }
}