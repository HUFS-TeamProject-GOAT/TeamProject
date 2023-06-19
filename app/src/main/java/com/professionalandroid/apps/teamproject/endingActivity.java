package com.professionalandroid.apps.teamproject;

import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class endingActivity extends AppCompatActivity {

    int [] values = new int[16];
    private Button back_btn;
    private static final String SHARED_PREFS_KEY = "quiz_score";
    private static final String STORY_STATUS_KEY = "storyStatus";
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_ending);
        Button MainButton = (Button) findViewById(R.id.MainButton);
        Button detailButton =(Button) findViewById(R.id.show_detail_button);
        TextView rankText=(TextView) findViewById(R.id.rankText);
        Button back_btn = findViewById(R.id.back_btn);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        String rankString = getString(R.string.rank, user_Name);
        rankText.setText(rankString);


        for (int i = 0; i < values.length; i++) {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
            values[i] = sharedPreferences.getInt("score"+i, 0);
        }
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

                AlertDialog.Builder builder = new AlertDialog.Builder(endingActivity.this);
                builder.setTitle("게임 초기화")
                        .setMessage("확인 버튼 누르시면 게임이 초기화 됩니다.")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                cleandata();
                                Toast.makeText(endingActivity.this, "점수와 스토리가 초기화 됐습니다..", Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("취소", null);

                AlertDialog dialog = builder.create();

                dialog.setOnShowListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF"))));

                dialog.show();



            }
        });
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                listView.setVisibility(View.VISIBLE);
                back_btn.setVisibility(View.VISIBLE);

                MainButton.setVisibility(View.INVISIBLE);
                detailButton.setVisibility(View.INVISIBLE);
                Rank.setVisibility(View.INVISIBLE);
                rankText.setVisibility(View.INVISIBLE);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.INVISIBLE);
                back_btn.setVisibility(View.INVISIBLE);

                MainButton.setVisibility(View.VISIBLE);
                detailButton.setVisibility(View.VISIBLE);
                Rank.setVisibility(View.VISIBLE);
                rankText.setVisibility(View.VISIBLE);
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

    private void cleandata(){
        SharedPreferences preferences,preferences1;
        SharedPreferences.Editor editor,editor1;

        preferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        for (int i = 0; i <= 16; i++) {
            String shared_prefs_key = "score" + i;
            preferences = getSharedPreferences(shared_prefs_key, Context.MODE_PRIVATE);
            editor = preferences.edit();
            editor.clear();
            editor.apply();
        }

        preferences1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        for (int i = 0; i <= 16; i++) {
            String storyStatusKey = "storyStatus" + i;
            preferences1 = getSharedPreferences(storyStatusKey, Context.MODE_PRIVATE);
            editor1 = preferences1.edit();
            editor1.clear();
            editor1.apply();
        }
    }
}

