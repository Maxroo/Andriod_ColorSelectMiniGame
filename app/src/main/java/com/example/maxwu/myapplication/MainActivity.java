package com.example.maxwu.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button leftbutton;
    private Button rightbutton;
    private TextView colorname;
    private TextView score;
    private int scores = 0;
    Random random = new Random();
    private int rans;
    private int ran1;
    private int ran2;


    int[] color = {Color.CYAN, Color.RED, Color.BLUE, Color.GREEN,Color.BLACK,Color.YELLOW,Color.WHITE,Color.GRAY};
    String[] names = {"Cyan","Red","Blue","Green","Black","Yellow","White","Grey"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftbutton = findViewById(R.id.LeftB);
        rightbutton = findViewById(R.id.RightB);
        colorname = findViewById(R.id.ColorName);
        score = findViewById(R.id.Score);
        score.setText("Score: " + scores);
        randomint();
        initalcolor();
    }

    private void toastm(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void randomint()
    {
        rans = random.nextInt(2) + 1;
        ran1 = random.nextInt(8);
        ran2 = random.nextInt(8);
    }

    private void initalcolor()
    {
        leftbutton.setBackgroundColor(color[ran1]);
        rightbutton.setBackgroundColor(color[ran2]);

        if (rans == 1)
        {
            colorname.setText(names[ran1]);
        }else
        {
            colorname.setText(names[ran2]);
        }
    }

    public void clicked(View view) {

        if (view.getId() == R.id.LeftB)
        {
            if (ran1 == ran2)
            {
                toastm("right");
                scores ++;
            }else if (rans == 1)
            {
                toastm("Right");
                scores ++;
            }else
            {
                toastm("Wrong");
                scores--;
            }

        }else if (view.getId() == R.id.RightB)
        {
            if (rans == 2)
            {
                toastm("Right");
                scores ++;

            }else if (ran1 == ran2)
            {
                toastm("Right");
                scores ++;
            }
            else
            {
                toastm("Wrong");
                scores --;

            }
        }
        score.setText("Score: " + scores);
        randomint();
        leftbutton.setBackgroundColor(color[ran1]);
        rightbutton.setBackgroundColor(color[ran2]);
        if (rans == 1)
        {
            colorname.setText(names[ran1]);
        }else
        {
            colorname.setText(names[ran2]);
        }
    }

}
