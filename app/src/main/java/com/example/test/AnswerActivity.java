package com.example.test;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AnswerActivity extends AppCompatActivity {
    private Button back;
    private TextView show_answer_area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        back= (Button) findViewById(R.id.back);
        show_answer_area= (TextView) findViewById(R.id.area);

        Intent i = getIntent();

        List<String> answerlist = (List<String>) i.getSerializableExtra("answerlist");
        for(int num=1;num<=answerlist.size();num++) {
            show_answer_area.append("方案" +num+ " : " + answerlist.get(num-1) + '\n');
        }

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnswerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
