package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    Button bt_spin;
    ImageView iv_bottle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_spin = (Button)findViewById(R.id.bt_spin);
        iv_bottle = (ImageView)findViewById(R.id.iv_bottle);

        bt_spin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                int spinDegrees;
                Random random = new Random();

                spinDegrees = random.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0,spinDegrees,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);

                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());
                iv_bottle.startAnimation(rotateBottle);

            }
        });
    }
}