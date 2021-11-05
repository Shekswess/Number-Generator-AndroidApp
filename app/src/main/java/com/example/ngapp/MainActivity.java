package com.example.ngapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        points = 0;
        roll();
    }

    private void roll() {
        Random r = new Random();
        num1 = r.nextInt(9);
        num2 = r.nextInt(9);
        while(num2 == num1)
            num2 = r.nextInt(9);
        Button left = findViewById(R.id.button1);
        Button right = findViewById(R.id.button2);
        left.setText(String.valueOf(num1));
        right.setText(String.valueOf(num2));
        left.setBackgroundColor(Color.GRAY);
        right.setBackgroundColor(Color.GRAY);
    }

    private boolean check(int a, int b) {
        boolean result = false;
        if(a > b)
        {
            result = true;
            points++;
            Toast.makeText(this,"Correct !", Toast.LENGTH_LONG).show();
        }
        else{
            points--;
            Toast.makeText(this,"Incorrect !", Toast.LENGTH_LONG).show();
        }
        TextView poeni = findViewById(R.id.point);
        poeni.setText(getResources().getString(R.string.score) + " " + String.valueOf(points));
        return result;
    }

    public void button2Click(View view) {
        boolean guess = check(num2,num1);
        roll();
    }
    public void button1Click(View view) {
        boolean guess = check(num1,num2);
        roll();
    }
}