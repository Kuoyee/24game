package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ImageView[] cards;
    private ImageButton[] card1;
    private ImageButton[] card2;
    private ImageButton[] card3;
    private ImageButton[] card4;

    private Button button_clear;
    private Button next;
    private int already_choosed_count=0;
    private List<Integer> choosed_list;
    private List<String> ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choosed_list = new ArrayList<Integer>();
        ans = new ArrayList<String>();
        cards = new ImageView[4];
        card1= new ImageButton[14];
        card2= new ImageButton[14];
        card3= new ImageButton[14];
        card4= new ImageButton[14];

        cards[0] = (ImageView) findViewById(R.id.card1);
        cards[1] = (ImageView) findViewById(R.id.card2);
        cards[2] = (ImageView) findViewById(R.id.card3);
        cards[3] = (ImageView) findViewById(R.id.card4);

        card1[1] = (ImageButton) findViewById(R.id.card1_1);
        card1[2] = (ImageButton) findViewById(R.id.card1_2);
        card1[3] = (ImageButton) findViewById(R.id.card1_3);
        card1[4] = (ImageButton) findViewById(R.id.card1_4);
        card1[5] = (ImageButton) findViewById(R.id.card1_5);
        card1[6] = (ImageButton) findViewById(R.id.card1_6);
        card1[7] = (ImageButton) findViewById(R.id.card1_7);
        card1[8] = (ImageButton) findViewById(R.id.card1_8);
        card1[9] = (ImageButton) findViewById(R.id.card1_9);
        card1[10] = (ImageButton) findViewById(R.id.card1_10);
        card1[11] = (ImageButton) findViewById(R.id.card1_11);
        card1[12] = (ImageButton) findViewById(R.id.card1_12);
        card1[13] = (ImageButton) findViewById(R.id.card1_13);

        card2[1] = (ImageButton) findViewById(R.id.card2_1);
        card2[2] = (ImageButton) findViewById(R.id.card2_2);
        card2[3] = (ImageButton) findViewById(R.id.card2_3);
        card2[4] = (ImageButton) findViewById(R.id.card2_4);
        card2[5] = (ImageButton) findViewById(R.id.card2_5);
        card2[6] = (ImageButton) findViewById(R.id.card2_6);
        card2[7] = (ImageButton) findViewById(R.id.card2_7);
        card2[8] = (ImageButton) findViewById(R.id.card2_8);
        card2[9]= (ImageButton) findViewById(R.id.card2_9);
        card2[10] = (ImageButton) findViewById(R.id.card2_10);
        card2[11] = (ImageButton) findViewById(R.id.card2_11);
        card2[12] = (ImageButton) findViewById(R.id.card2_12);
        card2[13] = (ImageButton) findViewById(R.id.card2_13);

        card3[1] = (ImageButton) findViewById(R.id.card3_1);
        card3[2] = (ImageButton) findViewById(R.id.card3_2);
        card3[3] = (ImageButton) findViewById(R.id.card3_3);
        card3[4] = (ImageButton) findViewById(R.id.card3_4);
        card3[5] = (ImageButton) findViewById(R.id.card3_5);
        card3[6] = (ImageButton) findViewById(R.id.card3_6);
        card3[7] = (ImageButton) findViewById(R.id.card3_7);
        card3[8] = (ImageButton) findViewById(R.id.card3_8);
        card3[9] = (ImageButton) findViewById(R.id.card3_9);
        card3[10] = (ImageButton) findViewById(R.id.card3_10);
        card3[11] = (ImageButton) findViewById(R.id.card3_11);
        card3[12] = (ImageButton) findViewById(R.id.card3_12);
        card3[13] = (ImageButton) findViewById(R.id.card3_13);

        card4[1] = (ImageButton) findViewById(R.id.card4_1);
        card4[2] = (ImageButton) findViewById(R.id.card4_2);
        card4[3] = (ImageButton) findViewById(R.id.card4_3);
        card4[4] = (ImageButton) findViewById(R.id.card4_4);
        card4[5] = (ImageButton) findViewById(R.id.card4_5);
        card4[6] = (ImageButton) findViewById(R.id.card4_6);
        card4[7] = (ImageButton) findViewById(R.id.card4_7);
        card4[8] = (ImageButton) findViewById(R.id.card4_8);
        card4[9] = (ImageButton) findViewById(R.id.card4_9);
        card4[10] = (ImageButton) findViewById(R.id.card4_10);
        card4[11] = (ImageButton) findViewById(R.id.card4_11);
        card4[12] = (ImageButton) findViewById(R.id.card4_12);
        card4[13] = (ImageButton) findViewById(R.id.card4_13);

        next = (Button) findViewById(R.id.next);
        button_clear = (Button) findViewById(R.id.clear);


        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(already_choosed_count!=4){
                    Toast.makeText(MainActivity.this, "还没选完嘞！", Toast.LENGTH_LONG).show();
                }else{
                    check check=new check();
                    ans=check.calculate_answer(choosed_list);
                    Toast.makeText(MainActivity.this, "ans: "+ans, Toast.LENGTH_LONG).show();
                    //调转页面  传参数ans
                    Intent intent=new Intent(MainActivity.this,AnswerActivity.class);
                    intent.putExtra("answerlist",(Serializable)ans);
                    startActivity(intent);
                }

            }
        });

        button_clear.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                already_choosed_count = 0;
                choosed_list.clear();
                //将图片设置为默认
                for (int i = 0; i < 4; i++) {
                    cards[i].setImageResource(R.drawable.card);
                }
            }
        });

       for(int i=1;i<14;i++){
           setlistener(card1[i],1,i);
       }
        for(int i=1;i<14;i++){
            setlistener(card2[i],2,i);
        }
        for(int i=1;i<14;i++){
            setlistener(card3[i],3,i);
        }
        for(int i=1;i<14;i++){
            setlistener(card4[i],4,i);
        }

    }

    private void setlistener(ImageButton imgbt,int number,int pos){
        imgbt.setOnClickListener(new View.OnClickListener() {
            Field field = null;
            @Override
            public void onClick(View v) {
                if (already_choosed_count == 4) {
                    Toast.makeText(MainActivity.this, "已经有4张了！！", Toast.LENGTH_LONG).show();
                } else {
               String resName = "card" +number+"_"+pos ;
                    try {
                        int drawableId = getResourceByReflect(resName);
//                        Toast.makeText(MainActivity.this, "add: "+pos, Toast.LENGTH_LONG).show();
                        cards[already_choosed_count].setImageResource(drawableId);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    already_choosed_count++;
                    choosed_list.add(pos);
                }
            }
        });
    }


    //根据文件名称获取资源的ID
    private int getResourceByReflect(String imageName) throws NoSuchFieldException, IllegalAccessException {
        Class drawable  =  R.drawable.class;
        Field field = null;
        int r_id ;
        field = drawable.getField(imageName);
        r_id = field.getInt(field.getName());
        return r_id;
    }




}