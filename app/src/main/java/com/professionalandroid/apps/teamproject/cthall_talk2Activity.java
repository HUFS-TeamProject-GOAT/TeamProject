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
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class cthall_talk2Activity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 1;

    private final int[] storyTexts = {R.string.ct_storyLine2_1, R.string.ct_storyLine2_2, R.string.ct_storyLine2_3_, R.string.ct_storyLine2_4, R.string.ct_storyLine2_5, R.string.ct_storyLine2_6_};
    private final int[] imageResources = {android.R.color.transparent, R.drawable.maincharacter,R.drawable.minsu, R.drawable.hyunggu,R.drawable.professor2};
    private final int[] textResources = {R.layout.activity_cthall_talk2, R.id.userName, R.id.name_minsu, R.id.name_hyunggu, R.id.name_professor2};

    private boolean quizFinished = false;
    private TextView ct_storyText;

    private TextView userName;
    private TextView subName;
    private ImageView ct_imageView1;
    private ImageView ct_imageView2;
    public MediaPlayer clickPlay;

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus"+2; // 스토리 상태를 저장하기 위해 만든 key

//    protected void onPause() { //앱 pause -> 상태 저장
//        super.onPause();
//        saveLayout(story);
//    }


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cthall_talk2);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                showNextStoryText();
            }
        });
        ct_storyText = findViewById(R.id.ct_storyText);
        ct_imageView1 = findViewById(R.id.ct_imageView1);
        ct_imageView2 = findViewById(R.id.ct_imageView2);


        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        subName = (TextView) findViewById(R.id.name_hyunggu); // subName으로 변경
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = settings1.edit();
//        editor.remove(STORY_STATUS_KEY);
//        editor.putInt(STORY_STATUS_KEY, 0);
//        editor.apply();
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);

        showNextStoryText();

        Button skipButton = (Button) findViewById(R.id.ct_skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                if(!quizFinished) {
                    story = 3;
                }else {
                    skipButton.setVisibility(View.GONE);
                    story = 7;
                }
                showNextStoryText();

            }
        });
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
            ct_storyText.setText(storyTexts[story]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }
        else if (story == 1) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }else if (story == 2) {
            ct_storyText.setText(storyTexts[story]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(ct_imageView2,imageResources[4],subName,textResources[4]);
            story++;
        }else if (story == 3) {
            if (!quizFinished) {
                saveLayout(story);
                dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
                clear_character(ct_imageView2,imageResources[4],subName,textResources[4]);
                ct_storyText.setText(storyTexts[story-1]);
                Intent intent = new Intent(getApplicationContext(), ct_quiz_3.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);
            } else {
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("stroyStatus1_2_quiz: " + story);
            }
        }else if (story == 4) {
            ct_storyText.setText(storyTexts[story-1]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 5) {
            ct_storyText.setText(storyTexts[story-1]);
            clear_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 6) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String user_Name = settings.getString("user_Name", "");
            String storyText = getString(R.string.ct_storyLine2_6_, user_Name);
            ct_storyText.setText(storyText);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else {
            saveLayout(story);
            findViewById(R.id.nextButton).setVisibility(View.GONE);
            finish();
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
        } else if (textResources == R.id.name_minsu) {
            name.setText(getText(R.string.kane));
        } else if (textResources == R.id.name_hyunggu) {
            name.setText(getText(R.string.bigboy));
        } else if (textResources == R.id.name_professor2) {
            name.setText(getText(R.string.kamelot));
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
        } else if (textResources == R.id.name_minsu) {
            name.setText(getText(R.string.kane));
        } else if (textResources == R.id.name_hyunggu) {
            name.setText(getText(R.string.bigboy));
        } else if (textResources == R.id.name_professor2) {
            name.setText(getText(R.string.kamelot));
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
