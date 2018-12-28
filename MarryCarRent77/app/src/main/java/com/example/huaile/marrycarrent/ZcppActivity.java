package com.example.huaile.marrycarrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ZcppActivity extends AppCompatActivity {
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zcpp);
        imageButton1 = (ImageButton) findViewById(R.id.bm);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(ZcppActivity.this, baomaActivity.class);
                startActivity(p);
            }
        });
        imageButton2 = (ImageButton) findViewById(R.id.bc);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(ZcppActivity.this, benchiActivity.class);
                startActivity(p);
            }
        });
    }
}