package com.example.uasandroid;


import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class AdapterKariawan extends RecyclerView.Adapter<AdapterKariawan.HolderData> {


    private List<DataKariawan> mlist;
    private Context ctx;

    public AdapterKariawan(Context ctx,List<DataKariawan>mlist){
        this.ctx=ctx;
        this.mlist=mlist;
    }


    @NonNull
    @Override
    public AdapterKariawan.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tampildata,viewGroup,false);
        HolderData holder = new HolderData(layout);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKariawan.HolderData holderData, int i) {
        DataKariawan dk =mlist.get(i);
        holderData.vw_nik.setText(dk.getNik());
        holderData.vw_nama.setText(dk.getNama());

        holderData.dk = dk;

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView vw_nik,vw_nama;
        DataKariawan dk;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            vw_nik = (TextView)itemView.findViewById(R.id.tvnik);
            vw_nama = (TextView)itemView.findViewById(R.id.tvnama);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent godata = new Intent(ctx,Input.class);
                    godata.putExtra("Nik ",dk.getNik());
                    godata.putExtra("Nama ",dk.getNama());
                    godata.putExtra("Tempat Lahir ",dk.getTempat_lahir());
                    godata.putExtra("Tanggal Lahir ",dk.getTgl_lahir());
                    godata.putExtra("Alamat ",dk.getAlamat());
                    godata.putExtra("Kelamin ",dk.getKelamin());
                    godata.putExtra("Agama ",dk.getAgama());
                    godata.putExtra("Status ",dk.getStatus());
                    godata.putExtra("Pendidikan ",dk.getPendidikan());
                    godata.putExtra("Jabatan ",dk.getJabatan());

                    ctx.startActivity((godata));




                }
            });


        }
    }
}

