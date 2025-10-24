package com.abdullah.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup[] qs = new RadioGroup[5];

    String[] answers = new String[5];

    Integer[] ids = new Integer[5];

    Button btn;
    Integer score;
    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        qs[0] = findViewById(R.id.q1);
        qs[1] = findViewById(R.id.q2);
        qs[2] = findViewById(R.id.q3);
        qs[3] = findViewById(R.id.q4);
        qs[4] = findViewById(R.id.q5);
        btn = findViewById(R.id.btn);
        score = 0;

        ids[0]= qs[0].getCheckedRadioButtonId();
        ids[1]= qs[1].getCheckedRadioButtonId();
        ids[2]= qs[2].getCheckedRadioButtonId();
        ids[3]= qs[3].getCheckedRadioButtonId();
        ids[4]= qs[4].getCheckedRadioButtonId();
        answers[0] = "Islamabad";
        answers[1] = "7";
        answers[2] = "Pacific";
        answers[3] = "21";
        answers[4] = "45";


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                ids[0]= qs[0].getCheckedRadioButtonId();
                ids[1]= qs[1].getCheckedRadioButtonId();
                ids[2]= qs[2].getCheckedRadioButtonId();
                ids[3]= qs[3].getCheckedRadioButtonId();
                ids[4]= qs[4].getCheckedRadioButtonId();
                count = 0;
                RadioButton[] selected = new RadioButton[5];

                for(int i=0;i<5;i++)
                {
                    if(ids[i] != -1)
                    {
                        selected[i] = findViewById(ids[i]);
                        if(selected[i].getText().equals(answers[i]))
                            score++;
                    }
                    else
                        count++;
                }
                Toast.makeText(MainActivity.this, "Questions attempted: "+ Integer.toString(5-count), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "You scored: "+ Integer.toString(score)+"/5", Toast.LENGTH_SHORT).show();
            }
        });




    }
}