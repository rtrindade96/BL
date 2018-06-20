
package com.example.ranielle.baronlogger.Activity;


import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.net.Uri;

import com.example.ranielle.baronlogger.Helper.Permissao;
import com.example.ranielle.baronlogger.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class RelRevest1Activity extends AppCompatActivity {

    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    //fotos revest antes
    private ImageButton imageButtonCamera;
    private Button buttonFotos;
    private ImageView imageviewFoto;

    //fotos horimetro
    private ImageButton imageButtonCamHorimetro;
    private Button buttonFotosHorimetro;
    private ImageView imageviewHorimetro;

    //fotos TAG
    private ImageButton imageButtonCamTAG;
    private Button buttonFotosTAG;
    private ImageView imageviewTAG;




    private static final int SELECAO_CAMERA = 100;
    private static final int SELECAO_GALERIA = 200;
    private static final int SELECAO_CAMERAHORIMETRO = 300;
    private static final int SELECAO_GALERIAHORIMETRO = 400;
    private static final int SELECAO_CAMERATAG = 500;
    private static final int SELECAO_GALERIATAG = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rel_revest1);


        //Validar permissões
        Permissao.validarPermissoes(permissoesNecessarias, this, 1);

        //Abrir galeria e camera
        imageButtonCamera = findViewById(R.id.imageButtonCamera);
        buttonFotos = findViewById(R.id.buttonFotos);
        imageviewFoto = findViewById(R.id.imageViewFoto);


        imageButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, SELECAO_CAMERA);


                }
            }

        });

        buttonFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, SELECAO_GALERIA);


                }
            }
        });


        //Abrir galeria e camera HORIMETRO
//fotos horimetro
        imageButtonCamHorimetro = findViewById(R.id.imageButtonCamHorimetro);
        buttonFotosHorimetro = findViewById(R.id.buttonFotosHorimetro);
        imageviewHorimetro = findViewById(R.id.imageViewHomimetro);

        imageButtonCamHorimetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, SELECAO_CAMERAHORIMETRO);


                }
            }

        });

        buttonFotosHorimetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, SELECAO_GALERIAHORIMETRO);


                }
            }
        });

        //Abrir galeria e camera TAG
//fotos horimetro
        imageButtonCamTAG = findViewById(R.id.imageButtonCamTAG);
        buttonFotosTAG = findViewById(R.id.buttonFotosTAG);
        imageviewTAG = findViewById(R.id.imageviewTAG);

        imageButtonCamTAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, SELECAO_CAMERATAG);


                }
            }

        });

        buttonFotosTAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, SELECAO_GALERIATAG);


                }
            }
        });

        Button avancar = findViewById(R.id.bntAVANÇAR);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText DATAINST = findViewById(R.id.editDATAINSTA);
                String dtinst = DATAINST.getText().toString();

                EditText HORIMETRO = findViewById(R.id.editHORIMETRO);
                String horimetro = HORIMETRO.getText().toString();

                EditText AREA = findViewById(R.id.editAREA);
                String area = AREA.getText().toString();

                Bundle b = new Bundle();
                b.putString("DataInst", dtinst);
                b.putString("Horimetro", horimetro);
                b.putString("Area", area);
                Intent intentVaipraSegPag = new Intent(RelRevest1Activity.this, RelRevest2Activity.class);
                intentVaipraSegPag.putExtras(b);
                startActivity(intentVaipraSegPag);

                //GUARDAR OS DADOS inspetor, CLIENTE, TAG, DataInst e DataRev
                finish();


            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bitmap imagem = null;
            Bitmap imghorimetro = null;
            Bitmap imgTAG = null;

            try {

                switch (requestCode) {
                    case SELECAO_CAMERA:
                        imagem = (Bitmap) data.getExtras().get("data");
                        break;
                    case SELECAO_GALERIA:
                        Uri localImagemSelecionada = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionada);
                        break;

                    case SELECAO_CAMERAHORIMETRO:
                        imghorimetro = (Bitmap) data.getExtras().get("data");
                        break;
                    case SELECAO_GALERIAHORIMETRO:
                        Uri localImagemSelecionadaHorimetro = data.getData();
                        imghorimetro = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionadaHorimetro);
                        break;
                    case SELECAO_CAMERATAG:
                        imgTAG = (Bitmap) data.getExtras().get("data");
                        break;
                    case SELECAO_GALERIATAG:
                        Uri localImagemSelecionadaTAG = data.getData();
                        imgTAG = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionadaTAG);
                        break;
                }

                if (imagem != null) {
                    imageviewFoto.setImageBitmap(imagem);
                    // Converter a imagem no imageview em array de bytes

                    Bitmap bitmap = ((BitmapDrawable)imageviewFoto.getDrawable()).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] imageInByte = stream.toByteArray();


                    try { stream.close(); }
                    catch (IOException e) {
                        e.printStackTrace();
                    }



                }

                if (imghorimetro !=null){
                    imageviewHorimetro.setImageBitmap(imghorimetro);


                }
                if (imgTAG !=null){
                    imageviewTAG.setImageBitmap(imgTAG);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }






}