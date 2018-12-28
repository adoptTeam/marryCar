package com.example.huaile.marrycarrent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
/**
 * Created by huaile on 2017/4/27.
 */
public class PmdActivity extends AppCompatActivity {
    public ImageView imageView;

    public boolean juage = true;
    public int images[] = new int[]{R.drawable.a, R.drawable.b,R.drawable.c,
    R.drawable.d,R.drawable.e};
    public int count = 0;


    public Handler handler = new Handler();
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            AnimationSet animationSet1 = new AnimationSet(true);

            TranslateAnimation ta = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                    -1f, Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 0f);
            ta.setDuration(10000);
            animationSet1.addAnimation(ta);
            animationSet1.setFillAfter(true);
            imageView.startAnimation(animationSet1);
            imageView.setBackgroundResource(images[count % 5]);
            count++;

            if (juage)
                handler.postDelayed(runnable, 2600);
            Log.i("handler", "handler");
        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        handler.postDelayed(runnable, 2800);
    }


    public void onPause() {
        juage = false;
        super.onPause();
    }
}

