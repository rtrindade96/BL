package com.example.ranielle.baronlogger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import com.example.ranielle.baronlogger.Activity.LoginActivity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ranielle.baronlogger.Activity.LoginActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // startActivity(new Intent(this, LoginActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Baron Logger");


    }


    /* @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }
    */
    public void btEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

    /*public void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();
        if( autenticacao.getCurrentUser() != null ){
            abrirTelaPrincipal();
        }
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, MainActivity.class));
    }*/

}


