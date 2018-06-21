package com.example.ranielle.baronlogger.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ranielle.baronlogger.Model.CadastroEquipamento;
import com.example.ranielle.baronlogger.Network.NetworkUtil;
import com.example.ranielle.baronlogger.Network.RetrofitInterface;
import com.example.ranielle.baronlogger.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private RetrofitInterface mAPIService;
    private TextView mResponseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        final Spinner dropdownFABRICANTE = findViewById(R.id.spinnerFABRICANTE);
        final Spinner dropdownTIPOEQ = findViewById(R.id.spinnerTIPOEQ);
        //create a list of items for the spinner.
        String[] itemsFABRICANTE = new String[]{"CATERPILLAR"};
        String[] itemsTIPOEQ = new String[]{"FORA DE ESTRADA"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterFAB = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsFABRICANTE);
        ArrayAdapter<String> adapterTIPO = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, itemsTIPOEQ);
        //set the spinners adapter to the previously created one.
        dropdownFABRICANTE.setAdapter(adapterFAB);
        dropdownTIPOEQ.setAdapter(adapterTIPO);
        mAPIService = NetworkUtil.getRetrofit();
        mResponseTv = findViewById(R.id.txtAREA);

        Button avancar = findViewById(R.id.bntCONCLUIR);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FABRICANTE = dropdownFABRICANTE.getSelectedItem().toString();
                String TIPO_EQUIP = dropdownTIPOEQ.getSelectedItem().toString();

                EditText modelo = findViewById(R.id.editMODELO);
                String MODELO = modelo.getText().toString();

                EditText area = findViewById(R.id.editAREA);
                String AREA = area.getText().toString();

                EditText carga = findViewById(R.id.editCARGA);
                String CARGA = carga.getText().toString();

                if (!(MODELO.matches("")||AREA.matches("")||CARGA.matches(""))) {
                    //GUARDAR OS DADOS inspetor, CLIENTE, TAG, DataInst e DataRev
                    sendPost(AREA.trim(), MODELO.trim());

                    finish();
                }
//                Toast.makeText(CadastroActivity.this,"Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void sendPost(String title, String body) {
        mAPIService.savePost(title, body, 1).enqueue(new Callback<CadastroEquipamento>() {
            @Override
            public void onResponse(Call<CadastroEquipamento> call, Response<CadastroEquipamento> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
//                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<CadastroEquipamento> call, Throwable t) {
//                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }
    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}

