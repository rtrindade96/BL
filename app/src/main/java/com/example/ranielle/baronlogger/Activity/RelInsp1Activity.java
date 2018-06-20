package com.example.ranielle.baronlogger.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ranielle.baronlogger.R;

public class RelInsp1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rel_insp1);
//get the spinner from the xml.
        final Spinner dropdownCLIENTE = findViewById(R.id.spinnerCLIENTE);
        final Spinner dropdownTAG = findViewById(R.id.spinnerTAG);
        //create a list of items for the spinner.
        String[] itemsCLIENTE = new String[]{"Cliente1", "Cliente2", "Cliente3"};
        String[] itemsTAG = new String[]{"AABC", "TAG2", "TAG3"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterCLIENTE = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCLIENTE);
        ArrayAdapter<String> adapterTAG = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsTAG);
        //set the spinners adapter to the previously created one.
        dropdownCLIENTE.setAdapter(adapterCLIENTE);
        dropdownTAG.setAdapter(adapterTAG);
        Button avancar = findViewById(R.id.bntAVANÇAR);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cliente = dropdownCLIENTE.getSelectedItem().toString();
                String TAG = dropdownTAG.getSelectedItem().toString();

                EditText dataINST = findViewById(R.id.editDATAINSTA);
                String dtISNT = dataINST.getText().toString();

                EditText dataREV = findViewById(R.id.editDATAREV);
                String dtREV = dataREV.getText().toString();

                /*Bundle b = new Bundle();
                b.putString("CLIENTE", cliente);
                b.putString("TAG", TAG);
                b.putString("DataInst", dtISNT);
                b.putString("DataRev", dtREV);*/
                Intent intentVaipraSegPag = new Intent(RelInsp1Activity.this, RelInsp2Activity.class);
                //intentVaipraSegPag.putExtras(b);
                startActivity(intentVaipraSegPag);
                finish();
            }
        });
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        finish();

    }*/
    /*@Override
    protected void onRestart() {
        super.onRestart();
        finish();

    }*/
}