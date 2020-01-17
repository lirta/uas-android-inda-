package com.example.uasandroid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Input extends AppCompatActivity {
    Button simpann,vieww,updatee,deletee;
    EditText nikk,namaa,tempatl,tgll,alamatt,kelamin,agamaa,statuss,pndd,jabatann;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);

        simpann=(Button)findViewById(R.id.btnsimpan);
        vieww=(Button)findViewById(R.id.btntampil);
        updatee=(Button)findViewById(R.id.btnupdate);
        deletee=(Button)findViewById(R.id.btndelete);

        nikk=(EditText)findViewById(R.id.ednik);
        namaa=(EditText)findViewById(R.id.ednama);
        tempatl=(EditText)findViewById(R.id.ettempatlahir);
        tgll=(EditText)findViewById(R.id.ettglahir);
        alamatt=(EditText)findViewById(R.id.edalamat);
        kelamin=(EditText)findViewById(R.id.edkl);
        agamaa=(EditText)findViewById(R.id.edagama);
        statuss=(EditText)findViewById(R.id.edstatus);
        pndd=(EditText)findViewById(R.id.edpendidikan);
        jabatann=(EditText)findViewById(R.id.edjabatan);

        final String nik=getIntent().getStringExtra("nik");
        if (nik !=null){
            String na=getIntent().getStringExtra("namaaaa");
            nikk.setText(nik);
            namaa.setText(na);
            simpann.setVisibility(View.GONE);
        }

       deletee.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String nikkk=nikk.getText().toString();
               ApiRequestData aapi=Server.getClient().create(ApiRequestData.class);
               Call<ResponData>deletedata=aapi.hapusdata(nikkk);
               deletedata.enqueue(new Callback<ResponData>() {
                   @Override
                   public void onResponse(Call<ResponData> call, Response<ResponData> response) {
                       if (response.body().getPesan().equals("1")){
                           Toast.makeText(Input.this,"Berhasil menghapus DATA",Toast.LENGTH_SHORT).show();
                           nikk.setText("");
                           namaa.setText("");
                           tempatl.setText("");
                           tgll.setText("");
                           alamatt.setText("");
                           kelamin.setText("");
                           agamaa.setText("");
                           statuss.setText("");
                           pndd.setText("");
                           jabatann.setText("");

                       }else if (response.body().getPesan().equals("2")){
                           Toast.makeText(Input.this,"gagal menghapus DATA",Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onFailure(Call<ResponData> call, Throwable t) {
                       Toast.makeText(Input.this,"Gagal Menyanbungkan....!!",Toast.LENGTH_SHORT).show();

                   }
               });
           }
       });



        updatee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nikkk=nikk.getText().toString();
                String naama=namaa.getText().toString();
                final
                String temptll=tempatl.getText().toString();
                String tggll=tgll.getText().toString();
                String alamatttt=alamatt.getText().toString();
                String kelaminn=kelamin.getText().toString();
                String agaama=agamaa.getText().toString();
                String statuuss=statuss.getText().toString();
                String pnndd=pndd.getText().toString();
                String jabataann=jabatann.getText().toString();

                ApiRequestData apii=Server.getClient().create(ApiRequestData.class);
                Call<ResponData>updatedata=apii.updatedata(nikkk,naama,temptll,tggll,alamatttt,kelaminn,agaama,statuuss,pnndd,jabataann);
                updatedata.enqueue(new Callback<ResponData>() {
                    @Override
                    public void onResponse(Call<ResponData> call, Response<ResponData> response) {
                        if (response.body().getPesan().equals("1")){
                            Toast.makeText(Input.this,"DATA Berhasil di UPDATE",Toast.LENGTH_SHORT).show();


                        }else if (response.body().getPesan().equals("2")){
                            Toast.makeText(Input.this,"DATA belum ada dan telah disimpan",Toast.LENGTH_SHORT).show();
                        }
                        nikk.setText("");
                        namaa.setText("");
                        tempatl.setText("");
                        tgll.setText("");
                        alamatt.setText("");
                        kelamin.setText("");
                        agamaa.setText("");
                        statuss.setText("");
                        pndd.setText("");
                        jabatann.setText("");
                    }

                    @Override
                    public void onFailure(Call<ResponData> call, Throwable t) {
                        Toast.makeText(Input.this,"Gagal Menyanbungkan....!!",Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });


        vieww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotampil=new Intent(Input.this,Tampil.class);
                startActivity(gotampil);
            }
        });

        simpann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nikkk=nikk.getText().toString();
                String naama=namaa.getText().toString();
                final
                String temptll=tempatl.getText().toString();
                String tggll=tgll.getText().toString();
                String alamatttt=alamatt.getText().toString();
                String kelaminn=kelamin.getText().toString();
                String agaama=agamaa.getText().toString();
                String statuuss=statuss.getText().toString();
                String pnndd=pndd.getText().toString();
                String jabataann=jabatann.getText().toString();

                ApiRequestData api=Server.getClient().create(ApiRequestData.class);
                Call<ResponData>savedata=api.simpandata(nikkk,naama,temptll,tggll,alamatttt,kelaminn,agaama,statuuss,pnndd,jabataann);
                savedata.enqueue(new Callback<ResponData>() {
                    @Override
                    public void onResponse(Call<ResponData> call, Response<ResponData> response) {
                        response.body().getKode();
                        if (response.body().getKode().equals("1")){
                            Toast.makeText(Input.this,"Data Berhasil disimpan. ",Toast.LENGTH_SHORT).show();
                            nikk.setText("");
                            namaa.setText("");
                            tempatl.setText("");
                            tgll.setText("");
                            alamatt.setText("");
                            kelamin.setText("");
                            agamaa.setText("");
                            statuss.setText("");
                            pndd.setText("");
                            jabatann.setText("");
                        }else  if (response.body().getKode().equals("2")){
                            Toast.makeText(Input.this,"Data Sudah ada." ,Toast.LENGTH_SHORT).show();
                        }
                        nikk.setText("");
                        namaa.setText("");
                        tempatl.setText("");
                        tgll.setText("");
                        alamatt.setText("");
                        kelamin.setText("");
                        agamaa.setText("");
                        statuss.setText("");
                        pndd.setText("");
                        jabatann.setText("");
                    }

                    @Override
                    public void onFailure(Call<ResponData> call, Throwable t) {
                        Toast.makeText(Input.this,"Gagal Menyanbungkan....!!",Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });




    }

}
