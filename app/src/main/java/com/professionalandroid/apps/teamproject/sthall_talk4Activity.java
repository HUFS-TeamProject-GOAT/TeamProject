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

public class sthall_talk4Activity extends AppCompatActivity {



    private static final int YOUR_REQUEST_CODE = 1;

    private final int[] storyTexts = {R.string.st_storyLine4_1, R.string.st_storyLine4_2, R.string.st_storyLine4_3, R.string.st_storyLine4_4, R.string.st_storyLine4_5,R.string.st_storyLine4_6,R.string.st_storyLine4_7,R.string.st_storyLine4_8,R.string.st_storyLine4_9_,R.string.st_storyLine4_10,R.string.st_storyLine4_11,R.string.st_storyLine4_12,R.string.st_storyLine4_13,R.string.st_storyLine4_14,R.string.st_storyLine4_15_};
    private final int[] imageResources = {android.R.color.transparent, R.drawable.maincharacter,R.drawable.minsu, R.drawable.hyerim, R.drawable.security};

    private final int[] textResources = {R.layout.activity_sthall_talk4, R.id.userName, R.id.name_minsu, R.id.name_hyerim, R.id.name_security};


    private boolean quizFinished = false;
    private TextView st_storyText;

    private TextView userName;

    private TextView subName;

    private ImageView st_imageView1;
    private ImageView st_imageView2;


    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus"+15; // 스토리 상태를 저장하기 위해 만든 key

//    protected void onPause() { //앱 pause -> 상태 저장
//        super.onPause();
//        saveLayout(story);
//    }


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sthall_talk4);
        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextStoryText();
            }
        });
        st_storyText = findViewById(R.id.st_storyText);
        st_imageView1 = findViewById(R.id.st_imageView1);
        st_imageView2 = findViewById(R.id.st_imageView2);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        subName = (TextView) findViewById(R.id.name_hyerim);
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        // 초기화
        SharedPreferences.Editor editor = settings1.edit();
        editor.remove(STORY_STATUS_KEY);
        editor.putInt(STORY_STATUS_KEY, 0);
        editor.apply();
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);

        showNextStoryText();


        Button skipButton = (Button) findViewById(R.id.skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizFinished) {
                    story = 9;
                }else {
                    skipButton.setVisibility(View.GONE);
                    story = 16;
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
        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);
        if (story == 0) {
            saveLayout(story);
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }
        else if (story == 1) {
            st_storyText.setText(storyTexts[story]);
            clear_character(st_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(st_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 2) {
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 3) {
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(st_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 4) {
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 5) {
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(st_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 6) {
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }
        else if (story == 7) {
            st_storyText.setText(storyTexts[story]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 8) {
            st_storyText.setText(storyTexts[story]);
            clear_character(st_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(st_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 9) {
            if (!quizFinished) {
                saveLayout(story);
                Intent intent = new Intent(getApplicationContext(), st_quiz_4.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);
            } else {
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("stroyStatus4_4_quiz: " + story);
            }
        }
        else if (story == 10) {
            st_storyText.setText(storyTexts[story-1]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(st_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }
        else if (story == 11) {
            st_storyText.setText(storyTexts[story-1]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[4],subName,textResources[4]);
            story++;
        }
        else if (story == 12) {
            st_storyText.setText(storyTexts[story-1]);
            clear_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[4],subName,textResources[4]);
            story++;
        }
        else if (story == 13) {
            st_storyText.setText(storyTexts[story-1]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }
        else if (story == 14) {
            st_storyText.setText(storyTexts[story-1]);
            dark_character(st_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(st_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 15) {
            st_storyText.setText(storyTexts[story-1]);
            clear_character(st_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(st_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else {
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
            name.setText("케인");
        } else if (textResources == R.id.name_hyerim) {
            name.setText("록시");
        }
        else if (textResources == R.id.name_security) {
            name.setText("이케나스");
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
            name.setText("케인");
        } else if (textResources == R.id.name_hyerim) {
            name.setText("록시");
        }
        else if (textResources == R.id.name_security) {
            name.setText("이케나스");
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