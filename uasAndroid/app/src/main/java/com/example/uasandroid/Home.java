package com.example.uasandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
    Button input,tampill;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=findViewById(R.id.btnin);
        tampill=(Button)findViewById(R.id.btntampil);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goinput=new Intent(Home.this,Input.class);
                startActivity(goinput);
            }
        } );


        tampill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotampil=new Intent(Home.this,Tampil.class);
                startActivity(gotampil);
            }
        } );

    }


}
