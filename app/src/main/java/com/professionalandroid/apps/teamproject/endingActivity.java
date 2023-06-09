package com.professionalandroid.apps.teamproject;

import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class endingActivity extends AppCompatActivity {

    int [] values = new int[16];
    private static final String SHARED_PREFS_KEY1 = "quiz_score1_1";
    private static final String SHARED_PREFS_KEY2 = "quiz_score1_2";
    private static final String SHARED_PREFS_KEY3 = "quiz_score1_3";
    private static final String SHARED_PREFS_KEY4= "quiz_score1_4";
    private static final String SHARED_PREFS_KEY5 = "quiz_score2_1";
    private static final String SHARED_PREFS_KEY6 = "quiz_score2_2";
    private static final String SHARED_PREFS_KEY7= "quiz_score2_3";
    private static final String SHARED_PREFS_KEY8 = "quiz_score2_4";
    private static final String SHARED_PREFS_KEY9 = "quiz_score3_1";
    private static final String SHARED_PREFS_KEY10 = "quiz_score3_2";
    private static final String SHARED_PREFS_KEY11= "quiz_score3_3";
    private static final String SHARED_PREFS_KEY12 = "quiz_score3_4";
    private static final String SHARED_PREFS_KEY13 = "quiz_score4_1";
    private static final String SHARED_PREFS_KEY14 = "quiz_score4_2";
    private static final String SHARED_PREFS_KEY15 = "quiz_score4_3";
    private static final String SHARED_PREFS_KEY16 = "quiz_score4_4";
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_ending);
        Button MainButton = (Button) findViewById(R.id.MainButton);
        Button detailButton =(Button) findViewById(R.id.show_detail_button);
        TextView rankText=(TextView) findViewById(R.id.rankText);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName =(TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS_KEY1, MODE_PRIVATE);
        values[0] = sharedPreferences1.getInt("score", 0);
        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS_KEY2, MODE_PRIVATE);
        values[1] = sharedPreferences2.getInt("score", 0);
        SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREFS_KEY3, MODE_PRIVATE);
        values[2] = sharedPreferences3.getInt("score", 0);
        SharedPreferences sharedPreferences4 = getSharedPreferences(SHARED_PREFS_KEY4, MODE_PRIVATE);
        values[3] = sharedPreferences4.getInt("score", 0);
        SharedPreferences sharedPreferences5 = getSharedPreferences(SHARED_PREFS_KEY5, MODE_PRIVATE);
        values[4] = sharedPreferences5.getInt("score", 0);
        SharedPreferences sharedPreferences6 = getSharedPreferences(SHARED_PREFS_KEY6, MODE_PRIVATE);
        values[5] = sharedPreferences6.getInt("score", 0);
        SharedPreferences sharedPreferences7 = getSharedPreferences(SHARED_PREFS_KEY7, MODE_PRIVATE);
        values[6] = sharedPreferences7.getInt("score", 0);
        SharedPreferences sharedPreferences8 = getSharedPreferences(SHARED_PREFS_KEY8, MODE_PRIVATE);
        values[7] = sharedPreferences8.getInt("score", 0);
        SharedPreferences sharedPreferences9 = getSharedPreferences(SHARED_PREFS_KEY9, MODE_PRIVATE);
        values[8] = sharedPreferences9.getInt("score", 0);
        SharedPreferences sharedPreferences10 = getSharedPreferences(SHARED_PREFS_KEY10, MODE_PRIVATE);
        values[9] = sharedPreferences10.getInt("score", 0);
        SharedPreferences sharedPreferences11 = getSharedPreferences(SHARED_PREFS_KEY11, MODE_PRIVATE);
        values[10] = sharedPreferences11.getInt("score", 0);
        SharedPreferences sharedPreferences12 = getSharedPreferences(SHARED_PREFS_KEY12, MODE_PRIVATE);
        values[11] = sharedPreferences12.getInt("score", 0);
        SharedPreferences sharedPreferences13 = getSharedPreferences(SHARED_PREFS_KEY13, MODE_PRIVATE);
        values[12] = sharedPreferences13.getInt("score", 0);
        SharedPreferences sharedPreferences14 = getSharedPreferences(SHARED_PREFS_KEY14, MODE_PRIVATE);
        values[13] = sharedPreferences14.getInt("score", 0);
        SharedPreferences sharedPreferences15 = getSharedPreferences(SHARED_PREFS_KEY15, MODE_PRIVATE);
        values[14] = sharedPreferences15.getInt("score", 0);
        SharedPreferences sharedPreferences16 = getSharedPreferences(SHARED_PREFS_KEY16, MODE_PRIVATE);
        values[15] = sharedPreferences16.getInt("score", 0);

        int totalScore=0;
        for (int i = 0; i < values.length; i++) {
            totalScore +=values[i];
        }

        String rank = calculateScore(totalScore);
        TextView Rank = (TextView) findViewById(R.id.rank);
        Rank.setText(rank);

        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            itemList.add("퀴즈" + i + ": " + values[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                listView.setVisibility(View.VISIBLE);

                MainButton.setVisibility(View.INVISIBLE);
                detailButton.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.INVISIBLE);
                Rank.setVisibility(View.INVISIBLE);
                rankText.setVisibility(View.INVISIBLE);
            }
        });

    }
    private String calculateScore(int n){
        if(n>6){
            return "A";
        }
        if(n>4){
            return "B";
        }
        if(n>2){
            return"C";
        }
        else{
            return "D";
        }
    }
}
