package com.example.huaile.marrycarrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v4.app.Fragment;
import android.widget.TextView;


public class Tab03Activity extends AppCompatActivity {

    private ImageButton mShouye;
    private ImageButton mXiangqing;
    private ImageButton mWode;
private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private Button mButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab03);



        mShouye = (ImageButton) findViewById(R.id.shouye);
        mShouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
        mXiangqing = (ImageButton) findViewById(R.id.xiangqing);
        mXiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, Tab02Activity.class);
                startActivity(i);
            }
        });

        mWode = (ImageButton) findViewById(R.id.wode);
        mWode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, Tab04Activity.class);
                startActivity(i);
            }
        });
        mTextView1 = (TextView) findViewById(R.id.jiageyouhui);
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, JiaGeYouHuiActivity.class);
                startActivity(i);
            }
        });
        mTextView2 = (TextView) findViewById(R.id.chexingfenfu);
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, JiaGeYouHuiActivity.class);
                startActivity(i);
            }
        });
        mTextView3 = (TextView) findViewById(R.id.fangxinzuche);
        mTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, JiaGeYouHuiActivity.class);
                startActivity(i);
            }
        });
      mButton1 = (Button) findViewById(R.id.liji);
       mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tab03Activity.this, Tab04Activity.class);
                startActivity(i);
            }
        });
    }


    }






