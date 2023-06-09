package com.professionalandroid.apps.teamproject;

import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class foodhall_talk1Activity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 1;

    private final int[] storyTexts = {
            R.string.food_storyLine1_1, R.string.food_storyLine1_2, R.string.food_storyLine1_3,
            R.string.food_storyLine1_4, R.string.food_storyLine1_5, R.string.food_storyLine1_6_,
            R.string.food_storyLine1_7, R.string.food_storyLine1_8, R.string.food_storyLine1_9_
    };

    private final int[] imageResources1 = {R.drawable.maincharacter, android.R.color.transparent};
    private final int[] imageResources2 = {R.drawable.minsu, R.drawable.hyerim, android.R.color.transparent};

    private boolean quizFinished = false;
    private TextView food_storyText;

    private TextView userName;
    private TextView hyerim;
    private ImageView food_imageView1;
    private ImageView food_imageView2;

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus3_1"; // 스토리 상태를 저장하기 위해 만든 key


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_foodhall_talk1);


        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextStoryText();
            }
        });

        food_storyText = findViewById(R.id.food_storyText);
        food_imageView1 = findViewById(R.id.food_imageView1);
        food_imageView2 = findViewById(R.id.food_imageView2);


        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");

        userName = (TextView) findViewById(R.id.userName);
        hyerim = (TextView) findViewById(R.id.name_hyerim);
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = settings1.edit();
//        editor.remove(STORY_STATUS_KEY);
//        editor.putInt(STORY_STATUS_KEY, 0);
//        editor.apply();

        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);


        System.out.println("stroyStatus3_1: " + story);


        Button skipButton = (Button) findViewById(R.id.food_skipButton);
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
            food_storyText.setText(storyTexts[story]);
            food_imageView1.setImageResource(imageResources1[1]);
            food_imageView2.setImageResource(imageResources2[2]);
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else if (story == 1) {
            food_storyText.setText(storyTexts[story]);
            food_imageView1.setImageResource(imageResources1[0]);
            food_imageView2.setImageResource(imageResources2[2]);
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 2) {
            food_storyText.setText(storyTexts[story]);
            food_imageView1.setImageResource(imageResources1[1]);
            food_imageView2.setImageResource(imageResources2[1]);
            subVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 3) {
            food_storyText.setText(storyTexts[story]);
            food_imageView1.setImageResource(imageResources1[0]);
            food_imageView2.setImageResource(imageResources2[2]);
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 4) {
            food_storyText.setText(storyTexts[story]);
            food_imageView1.setImageResource(imageResources1[1]);
            food_imageView2.setImageResource(imageResources2[1]);
            subVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 5) {
            food_storyText.setText(storyTexts[story]);
            food_imageView1.setImageResource(imageResources1[0]);
            food_imageView2.setImageResource(imageResources2[2]);
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 6) {
            if (!quizFinished) {
                saveLayout(story);
                Intent intent = new Intent(getApplicationContext(), fd_quiz_1.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);

            } else {
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("stroyStatus1_1_quiz: " + story);
            }
        }
        else if (story == 7) {  //문제가 나오는 곳

            food_storyText.setText(storyTexts[story-1]);
            food_imageView1.setImageResource(imageResources1[0]);
            food_imageView2.setImageResource(imageResources2[2]);
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 8) {
            food_storyText.setText(storyTexts[story-1]);
            food_imageView1.setImageResource(imageResources1[0]);
            food_imageView2.setImageResource(imageResources2[2]);
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else if (story == 9) {

            food_storyText.setText(storyTexts[story-1]);
            food_imageView1.setImageResource(imageResources1[0]);
            food_imageView2.setImageResource(imageResources2[2]);
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else {
            saveLayout(story);
            findViewById(R.id.nextButton).setVisibility(View.GONE);
            finish();
        }
    }
    protected void mainVisiblelity(){
        userName.setVisibility(View.VISIBLE);
        hyerim.setVisibility(View.GONE);
    }
    protected void subVisiblelity(){
        userName.setVisibility(View.GONE);
        hyerim.setVisibility(View.VISIBLE);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == YOUR_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            quizFinished = data.getBooleanExtra("quizFinished", false);
            if (quizFinished) {
                showNextStoryText();
            }
        }
    }

}