package com.example.ranielle.baronlogger.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_BARONLOGGER";
    public static String TABELA_RELREVEST = "relatorio_revestimento";
    public static String TABELA_INSPECAOREVEST = "relatorio_inspecaorevestimento";
    public static String TABELA_CADEQUIPAMENTOS = "cadastroequipamentos";


    //CAMPOS TABELA EXCLUSIVOS RELATORIO DE REVESTIMENTO
    public static String FTREVESTIMENTOANTES = "ftrevestimentoantes";
    public static String HORIMETRODIG = "horimetrodig";
    public static String TEMPODESERVICO ="tempodeservico";
    public static String FTREVESTIMENTODEPOIS = "ftrevestimentodepois";
    public static String SUPERVISORRESP = "supervisorresp";
    public static String FUNCIONARIO1 = "funcionario1";
    public static String FUNCIONARIO2 = "funcionario2";
    public static String FUNCIONARIO3 = "funcionario3";
    public static String OBSERVACOES = "observacoes";

    // CAMPOS UTILIZADOS EM AMBOS OS RELATÓRIOS
    public static String ID= "id";
    public static String CLIENTE = "cliente";
    public static String HORIMETRO = "horimetro";
    public static String TAG = "tag";
    public static String DATAREVESTIMENTO = "datarevestimento";
    public static String AREAREVESTIMENTO = "arearevestimento";


    //campos tabela relatorio de inspeção
    public static String INSPETORRESPONSAVEL = "inspetorresponsavel";
    public static String TAGTXT = "tagtxt";
    public static String DATAINSTALACAO = "datainstalacao";

    //CAMPOS TABELA CAD EQUIPAMENTOS
    public static String FABRICANTE = "fabricante";
    public static String MODELO = "modelo";
    public static String CARGA = "carga";
    public static String TIPOEQUIPAMENTO = "tipoequipamento";





    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_RELREVEST
                    +  " ("+ ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FTREVESTIMENTOANTES + "_antes BLOB NOT NULL, "
                    + HORIMETRO + "BLOB NOT NULL, "
                    + TAG + "BLOB NOT NULL, "
                    + DATAREVESTIMENTO + "TEXT NOT NULL, "
                    + HORIMETRODIG + "REAL NOT NULL, "
                    + AREAREVESTIMENTO +"REAL NOT NULL, "
                    + CLIENTE +"TEXT NOT NULL, "
                    + TEMPODESERVICO + "REAL NOT NULL, "
                    + FTREVESTIMENTODEPOIS + "BLOB NOT NULL, "
                    + SUPERVISORRESP +"TEXT NOT NULL, "
                    + FUNCIONARIO1 + "TEXT NOT NULL, "
                    + FUNCIONARIO2 + "TEXT NOT NULL, "
                    + FUNCIONARIO3 + "TEXT NOT NULL, "
                    + OBSERVACOES + "TEXT);";
                    db.execSQL(sql);

        // CRIA A TABELA INSPEÇÃO DE REVESTIMENTO
        String sqlinspecaorevestimento = "CREATE TABLE IF NOT EXISTS " + TABELA_INSPECAOREVEST
                +  " ("+ ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CLIENTE +"TEXT NOT NULL, "
                + TAGTXT + "TEXT NOT NULL, "
                + DATAINSTALACAO + " TEXT NOT NULL, "
                + DATAREVESTIMENTO + "TEXT NOT NULL, "
                + INSPETORRESPONSAVEL + "TEXT NOT NULL, "
                + FTREVESTIMENTOANTES + "BLOB NOT NULL, "
                + HORIMETRO + "BLOB NOT NULL, "
                + TAG + "BLOB NOT NULL);";
        db.execSQL(sqlinspecaorevestimento);

        // CRIA A TABELA DE CADASTRO DE EQUIP.
        String sqlcadequipamentos = "CREATE TABLE IF NOT EXISTS " + TABELA_CADEQUIPAMENTOS
                +  " ("+ ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FABRICANTE +"TEXT NOT NULL, "
                + TIPOEQUIPAMENTO + "TEXT NOT NULL, "
                + MODELO + " TEXT NOT NULL, "
                + AREAREVESTIMENTO + "TEXT NOT NULL, "
                + CARGA + "TEXT NOT NULL);";
        db.execSQL(sqlcadequipamentos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
