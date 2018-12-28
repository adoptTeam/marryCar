package com.example.huaile.marrycarrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class YhhdActivity extends AppCompatActivity {

    private ImageButton mImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yhhd);
        mImageButton=(ImageButton)findViewById(R.id.image1);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(YhhdActivity.this,Xianshi.class);
                startActivity(a);
            }
        });
    }
}
