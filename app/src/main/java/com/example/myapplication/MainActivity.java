package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView diceImageView1 = findViewById(R.id.diceImage1);
        ImageView diceImageView2 =findViewById(R.id.diceImage2);

        Button btnRoll =findViewById(R.id.btnRollTheDice);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        int [] diceImages = {R.mipmap.dice1,R.mipmap.dice2,R.mipmap.dice3,R.mipmap.dice4,R.mipmap.dice5,R.mipmap.dice6};
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyDiceApp","btnRoll is clicked");

                Random rndObject = new Random();

                int myRandomNumber1 = rndObject.nextInt(6);// random number between 0 and 6
                int myRandomNumber2 = rndObject.nextInt(6);
                Log.i("MyDiceApp","The generated random number is "+myRandomNumber1 +"");


                diceImageView1.setImageResource(diceImages[myRandomNumber1]);
                diceImageView2.setImageResource(diceImages[myRandomNumber2]);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.diceImage1));
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.diceImage2));

                mp.start();


            }
        });

    }
}