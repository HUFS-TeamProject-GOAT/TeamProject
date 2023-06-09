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

    private static final String SHARED_PREFS_KEY = "quiz_score";
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


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        int[] values = new int[17];
        int totalScore=0;
        for (int i = 0; i < values.length; i++) {
            values[i] = sharedPreferences.getInt("score" + i, 0);
            totalScore+=values[i];
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
