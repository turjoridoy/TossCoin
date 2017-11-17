package com.eitasha.toss;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView coin;
    Button toss,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] coinArray ={
                R.drawable.flower,
                R.drawable.man,
        };

        coin = (ImageView) findViewById(R.id.coin);
        toss = (Button) findViewById(R.id.toss);
        exit = (Button) findViewById(R.id.exit);

        final MediaPlayer mp = MediaPlayer.create(MainActivity.this,R.raw.coinflip);

        toss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int flip = rand.nextInt(2);

                mp.start();
                coin.setImageResource(coinArray[flip]);

                RotateAnimation rotate = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(1000);
                coin.startAnimation(rotate);

                if (flip == 0){
                    Toast.makeText(MainActivity.this, "শাপলা", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "মানুষ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }

}
