package com.example.ranielle.baronlogger.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ranielle.baronlogger.R;

public class RelRevest2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rel_revest2);

        Button avancar = findViewById(R.id.btavancar2);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GUARDAR OS DADOS inspetor, CLIENTE, TAG, DataInst e DataRev
                Intent intentVaipraTerPag = new Intent(RelRevest2Activity.this, RelRevest3Activity.class);
                startActivity(intentVaipraTerPag);
                finish();
            }
        });
    }
}
