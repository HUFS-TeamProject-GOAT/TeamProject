package com.professionalandroid.apps.teamproject;

import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class endingActivity extends AppCompatActivity {

    int [] score_values = new int[17];

    private static final String SHARED_PREFS_KEY = "quiz_score";
    private static final String STORY_STATUS_KEY= "storyStatus";
    public MediaPlayer clickPlay;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_ending);
        Button MainButton = (Button) findViewById(R.id.MainButton);
        Button detailButton =(Button) findViewById(R.id.show_detail_button);
        TextView rankText=(TextView) findViewById(R.id.rankText);
        Button back_btn = findViewById(R.id.back_btn);
        clickPlay = MediaPlayer.create(this, R.raw.click);
        TextView show_Rank = (TextView)findViewById(R.id.showRank);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        String rankString = getString(R.string.rank, user_Name);
        rankText.setText(rankString);


        for (int i = 0; i < score_values.length; i++) {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
            score_values[i] = sharedPreferences.getInt("score"+i, 0);
        }
        int totalScore=0;
        for (int i = 0; i < score_values.length; i++) {
            totalScore += score_values[i];
        }

        String rank = calculateScore(totalScore);
        TextView Rank = (TextView) findViewById(R.id.rank);
        Rank.setText(rank);

        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < score_values.length; i++) {
            itemList.add("퀴즈" + i + ": " + score_values[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
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
                clickPlay.start();
                listView.setVisibility(View.VISIBLE);
                back_btn.setVisibility(View.VISIBLE);

                MainButton.setVisibility(View.INVISIBLE);
                detailButton.setVisibility(View.INVISIBLE);
                Rank.setVisibility(View.INVISIBLE);
                rankText.setVisibility(View.INVISIBLE);
                show_Rank.setVisibility(View.INVISIBLE);

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
                show_Rank.setVisibility(View.VISIBLE);
            }
        });

    }
    private String calculateScore(int n){
        if(n>380){
            return "A";
        }
        if(n>360){
            return "B";
        }
        if(n>340){
            return "C";
        }
        else{
            return "D";
        }
    }

    private void cleandata(){
        SharedPreferences preferences1;
        SharedPreferences.Editor editor1;

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();


        for (int i = 0; i <= 16; i++) {
            String storyStatusKey = "storyStatus" + i;
            preferences1 = getSharedPreferences(storyStatusKey, Context.MODE_PRIVATE);
            editor1 = preferences1.edit();
            editor1.clear();
            editor1.apply();
        }
    }
}