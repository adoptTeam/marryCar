package com.example.huaile.marrycarrent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DE LL on 2017/5/10.
 */
public class TimerActivity extends Activity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        iv = (ImageView)this.findViewById(R.id.imageView1);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        iv.setAnimation(anim);
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                startActivity(new Intent(TimerActivity.this,MainActivity.class));
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);
    }

}
