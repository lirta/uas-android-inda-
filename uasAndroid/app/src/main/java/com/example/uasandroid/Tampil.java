package com.example.uasandroid;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tampil extends AppCompatActivity {
    private RecyclerView mRc;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataKariawan> mItems =new ArrayList<>();
    ProgressDialog pd;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil);

        pd=new ProgressDialog(this);
        mRc=(RecyclerView)findViewById(R.id.rvkariawan);
        mManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRc.setLayoutManager(mManager);

        ApiRequestData api=Server.getClient().create(ApiRequestData.class);
        Call<ResponData>kariawan=api.getkariawan();
        kariawan.enqueue(new Callback<ResponData>() {
            @Override
            public void onResponse(Call<ResponData> call, Response<ResponData> response) {
                Toast.makeText(Tampil.this, "Respon: berhasil ditampilkan" ,Toast.LENGTH_LONG).show();
                mItems = response.body().getResult();
                mAdapter=new AdapterKariawan(Tampil.this,mItems);
                mRc.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponData> call, Throwable t) {

                Toast.makeText(Tampil.this, "Gagal konek",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
