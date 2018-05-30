package com.example.ranielle.baronlogger.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.ranielle.baronlogger.MainActivity;
import com.example.ranielle.baronlogger.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Spinner dropdown = findViewById(R.id.spinnerFABRICANTE);
        Spinner dropdown2 = findViewById(R.id.spinnerTIPOEQ);
        //create a list of items for the spinner.
        String[] itemsFABRICANTE = new String[]{"CATERPILLAR"};
        String[] itemsTIPOEQ = new String[]{"FORA DE ESTRADA"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterFAB = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsFABRICANTE);
        ArrayAdapter<String> adapterTIPO = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, itemsTIPOEQ);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapterFAB);
        dropdown2.setAdapter(adapterTIPO);

        Button avancar = findViewById(R.id.bntCONCLUIR);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentVaipraMain = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(intentVaipraMain);
            }
        });

    }
}
