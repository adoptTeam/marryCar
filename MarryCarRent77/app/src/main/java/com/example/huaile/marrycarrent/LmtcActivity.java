package com.example.huaile.marrycarrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LmtcActivity extends AppCompatActivity {
private ImageButton mImageButton1;
    private ImageButton mImageButton2;
    private ImageButton mImageButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lmtc);
       mImageButton1=(ImageButton)findViewById(R.id.tkc);
      mImageButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent i=new Intent(LmtcActivity.this,TkcActivity.class);
                startActivity(i);
            }
        });
        mImageButton2=(ImageButton)findViewById(R.id.nwms);
      mImageButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent i=new Intent(LmtcActivity.this,NwmsActivity.class);
                startActivity(i);
            }
        });
       mImageButton3=(ImageButton)findViewById(R.id.xfzdz);
      mImageButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent i=new Intent(LmtcActivity.this,XfzdzActivity.class);
                startActivity(i);
            }
        });
    }
}
