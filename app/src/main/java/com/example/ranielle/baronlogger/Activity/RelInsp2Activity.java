package com.example.ranielle.baronlogger.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.ranielle.baronlogger.MainActivity;
import com.example.ranielle.baronlogger.R;

public class RelInsp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rel_insp2);
        final Spinner dropdownINSPETOR = findViewById(R.id.spinnerCLIENTE);
        //create a list of items for the spinner.
        String[] itemsINSPETOR = new String[]{"Inspetor1", "Inspetor2", "Inspetor3"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterINSPETOR = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsINSPETOR);
        //set the spinners adapter to the previously created one.
        dropdownINSPETOR.setAdapter(adapterINSPETOR);


        Bundle b = getIntent().getExtras();
        if (b != null){
            String CLIENTE = b.getString("CLIENTE");
            String TAG = b.getString("TAG");
            String DataInst = b.getString("DataInst");
            String DataRev = b.getString("DataRev");
        }
        Button avancar = findViewById(R.id.bntCONCLUIR);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inspetor = dropdownINSPETOR.getSelectedItem().toString();
                ImageView imgvRevAntes = findViewById(R.id.imgvREVEST);
                ImageView imgvHORIMETRO = findViewById(R.id.imgvHORIMETRO);
                ImageView imgvTAG = findViewById(R.id.imgvTAG);

                //GUARDAR OS DADOS inspetor, CLIENTE, TAG, DataInst e DataRev
                finish();
            }
        });
    }
}