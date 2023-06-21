package com.professionalandroid.apps.teamproject;



import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lbhall_talkActivity extends AppCompatActivity {



    private static final int YOUR_REQUEST_CODE = 1;

    private final int[] storyTexts = {R.string.lb_storyLine1_1, R.string.lb_storyLine1_2, R.string.lb_storyLine1_3, R.string.lb_storyLine1_4, R.string.lb_storyLine1_5,R.string.lb_storyLine1_6_ };
    private final int[] imageResources = {android.R.color.transparent, R.drawable.maincharacter,R.drawable.president};
    private final int[] textResources = {R.layout.activity_lbhall_talk, R.id.userName, R.id.name_president};

    private TextView lb_storyText;

    private TextView userName;
    private TextView subName;
    private ImageView lb_imageView1;
    private ImageView lb_imageView2;

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus"+16; // 스토리 상태를 저장하기 위해 만든 key

//    protected void onPause() { //앱 pause -> 상태 저장
//        super.onPause();
//        saveLayout(story);
//    }


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_lbhall_talk);


        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextStoryText();
            }
        });
        findViewById(R.id.endingButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),endingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.skipButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
                story = settings1.getInt(STORY_STATUS_KEY, 6);
                saveLayout(story);

                Intent intent =new Intent(getApplicationContext(),endingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        lb_storyText = findViewById(R.id.lb_storyText);
        lb_imageView1 = findViewById(R.id.lb_imageView1);
        lb_imageView2 = findViewById(R.id.lb_imageView2);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        subName = (TextView) findViewById(R.id.name_president);
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = settings1.edit();
//        editor.remove(STORY_STATUS_KEY);
//        editor.putInt(STORY_STATUS_KEY, 0);
//        editor.apply();
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);



        showNextStoryText();
    }
    public void saveLayout(int story){
        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings1.edit();
        editor.putInt(STORY_STATUS_KEY, story);
        editor.apply();
    }



        private void showNextStoryText() {

        if (story == 0) {
            saveLayout(story);
            lb_storyText.setText(storyTexts[story]);
            dark_character(lb_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }
        else if (story == 1) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String user_Name = settings.getString("user_Name", "");
            String storyText = getString(R.string.lb_storyLine1_2, user_Name);
            lb_storyText.setText(storyText);
            dark_character(lb_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(lb_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 2) {
            lb_storyText.setText(storyTexts[story]);
            clear_character(lb_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(lb_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 3) {
            lb_storyText.setText(storyTexts[story]);
            dark_character(lb_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(lb_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 4) {
            lb_storyText.setText(storyTexts[story]);
            clear_character(lb_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(lb_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 5) {
            lb_storyText.setText(storyTexts[story]);
            dark_character(lb_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(lb_imageView2,imageResources[2],subName,textResources[2]);
            findViewById(R.id.nextButton).setVisibility(View.GONE);
            findViewById(R.id.skipButton).setVisibility(View.INVISIBLE);
            findViewById(R.id.endingButton).setVisibility(View.VISIBLE);
            story++;
        }
        else {
            saveLayout(story);
        }


    }
    protected void dark_character(ImageView image,int imageResources,TextView name,int textResources){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);
        image.setImageResource(imageResources);
        image.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
        if (textResources == R.id.userName) {
            name.setText(user_Name);
        }else if (textResources == R.id.name_president) {
            name.setText("");
        }
        name.setTextColor(Color.GRAY);
    }
    protected void clear_character(ImageView image,int imageResources,TextView name,int textResources){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        image.setImageResource(imageResources);
        image.clearColorFilter();
        if (textResources == R.id.userName) {
            name.setText(user_Name);
        } else if (textResources == R.id.name_president) {
            name.setText("솔론");
        }
        name.setTextColor(Color.BLACK);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STORY_STATUS_KEY, story);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        story = savedInstanceState.getInt(STORY_STATUS_KEY);
    }

}