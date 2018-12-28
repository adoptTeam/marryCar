package com.example.huaile.marrycarrent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {
    public ImageView imageView;
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private RecyclerView mRecyclerView;


    public boolean juage = true;
    public int images[] = new int[]{R.drawable.a1, R.drawable.b1,
            R.drawable.c1, R.drawable.d1, R.drawable.e1, R.drawable.f1,R.drawable.g1,R.drawable.h};
    public int count = 0;


    public Handler handler = new Handler();
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            AnimationSet animationSet1 = new AnimationSet(true);

            TranslateAnimation ta = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 00, Animation.RELATIVE_TO_SELF,
                    00, Animation.RELATIVE_TO_SELF, 00,
                    Animation.RELATIVE_TO_SELF, 00);
            ta.setDuration(10000);
            animationSet1.addAnimation(ta);
            animationSet1.setFillAfter(true);
            imageView.startAnimation(animationSet1);
            imageView.setBackgroundResource(images[count % 8]);
            count++;

            if (juage)
                handler.postDelayed(runnable, 2600);
            Log.i("handler", "handler");
        }
    };

    @Override

  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        imageView = (ImageView) findViewById(R.id.niha);
        imageButton1=(ImageButton)findViewById(R.id.zuchepinpai);
       imageButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(DisplayActivity.this,ZcppActivity.class);
                startActivity(i);
            }
        });
        imageButton2=(ImageButton)findViewById(R.id.zijiazuche);
        imageButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent o=new Intent(DisplayActivity.this,TjwdActivity.class);
                startActivity(o);
            }
        });
        imageButton3=(ImageButton)findViewById(R.id.shangwuzuche);
        imageButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent o=new Intent(DisplayActivity.this,SousuoActivity.class);
                startActivity(o);
            }
        });
        imageButton4=(ImageButton)findViewById(R.id.lvyouzuche);
        handler.postDelayed(runnable, 3);
    }



}