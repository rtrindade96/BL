package com.example.ranielle.baronlogger.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ranielle.baronlogger.MainActivity;
import com.example.ranielle.baronlogger.R;

public class RelInsp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rel_insp2);
        Button avancar = findViewById(R.id.bntCONCLUIR);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaipraMain = new Intent(RelInsp2Activity.this, MainActivity.class);
                startActivity(intentVaipraMain);
            }
        });

    }
}
