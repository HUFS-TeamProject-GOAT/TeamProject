package com.professionalandroid.apps.teamproject;



import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private final int[] imageResources1 = {R.drawable.maincharacter, android.R.color.transparent};
    private final int[] imageResources2 = {R.drawable.president, R.drawable.hyerim, android.R.color.transparent};

    private boolean quizFinished = false;
    private TextView st_storyText;

    private TextView userName;
    private TextView hyerim;
    private TextView president;
    private ImageView st_imageView1;
    private ImageView st_imageView2;

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus1_1"; // 스토리 상태를 저장하기 위해 만든 key

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
            }
        });
        findViewById(R.id.skipButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),endingActivity.class);
                startActivity(intent);
            }
        });
        st_storyText = findViewById(R.id.lb_storyText);
        st_imageView1 = findViewById(R.id.lb_imageView1);
        st_imageView2 = findViewById(R.id.lb_imageView2);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        president = (TextView) findViewById(R.id.name_president);
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings1.edit();
        editor.remove(STORY_STATUS_KEY);
        editor.putInt(STORY_STATUS_KEY, 0);
        editor.apply();
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);


        System.out.println("stroyStatus1_1: " + story);



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
            st_storyText.setText(storyTexts[story]);
            dark_main();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else if (story == 1) {
            st_storyText.setText(storyTexts[story]);
            dark_main();
            clear_president();
            subVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 2) {
            st_storyText.setText(storyTexts[story]);
            clear_main();
            dark_president();
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }else if (story == 3) {
            st_storyText.setText(storyTexts[story]);
            dark_main();
            clear_president();
            subVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else if (story == 4) {
            st_storyText.setText(storyTexts[story]);
            clear_main();
            dark_president();
            mainVisiblelity();
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else if (story == 5) {
            st_storyText.setText(storyTexts[story]);
            dark_main();
            clear_president();
            subVisiblelity();
            findViewById(R.id.nextButton).setVisibility(View.GONE);
            findViewById(R.id.endingButton).setVisibility(View.VISIBLE);
            story++;
            System.out.println("stroyStatus1_1: " + story);
        }
        else {
            saveLayout(story);
        }


    }
    protected void mainVisiblelity(){
        userName.setVisibility(View.VISIBLE);
        president.setVisibility(View.INVISIBLE);
    }
    protected void subVisiblelity(){
        userName.setVisibility(View.INVISIBLE);
        president.setVisibility(View.VISIBLE);
    }
    protected void dark_main(){
        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);
        st_imageView1.setImageResource(imageResources1[0]);
        st_imageView1.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

    }
    protected void clear_main(){
        st_imageView1.setImageResource(imageResources1[0]);
        st_imageView1.clearColorFilter();
    }

    protected void dark_president(){
        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);
        st_imageView2.setImageResource(imageResources2[0]);
        st_imageView2.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

    }
    protected void clear_president(){
        st_imageView2.setImageResource(imageResources2[0]);
        st_imageView2.clearColorFilter();
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