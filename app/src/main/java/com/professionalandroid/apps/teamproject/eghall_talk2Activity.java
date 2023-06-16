package com.professionalandroid.apps.teamproject;



import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class eghall_talk2Activity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 1;

    private final int[] storyTexts = {R.string.eg_storyLine2_1, R.string.eg_storyLine2_2, R.string.eg_storyLine2_3, R.string.eg_storyLine2_4,R.string.eg_storyLine2_5, R.string.eg_storyLine2_6, R.string.eg_storyLine2_7_, R.string.eg_storyLine2_8,R.string.eg_storyLine2_9,R.string.eg_storyLine2_10,R.string.eg_storyLine2_11,R.string.eg_storyLine2_12,R.string.eg_storyLine2_13,R.string.eg_storyLine2_14,R.string.eg_storyLine2_15,R.string.eg_storyLine2_16_};
    private final int[] imageResources = {android.R.color.transparent, R.drawable.maincharacter,R.drawable.minsu, R.drawable.hyerim};
    private final int[] textResources = {R.layout.activity_eghall_talk2, R.id.userName, R.id.name_minsu, R.id.name_hyerim};

    private boolean quizFinished = false;
    private TextView eg_storyText;

    private TextView userName;
    private TextView subName;
    private ImageView eg_imageView1;
    private ImageView eg_imageView2;

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus"+5; // 스토리 상태를 저장하기 위해 만든 key

//    protected void onPause() { //앱 pause -> 상태 저장
//        super.onPause();
//        saveLayout(story);
//    }


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_eghall_talk2);


        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextStoryText();
            }
        });
        eg_storyText = findViewById(R.id.eg_storyText);
        eg_imageView1 = findViewById(R.id.eg_imageView1);
        eg_imageView2 = findViewById(R.id.eg_imageView2);


        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        subName = (TextView) findViewById(R.id.name_hyerim); // subName으로 변경
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        // 초기화
//        SharedPreferences.Editor editor = settings1.edit();
//        editor.remove(STORY_STATUS_KEY);
//        editor.putInt(STORY_STATUS_KEY, 0);
//        editor.apply();
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);

        showNextStoryText();




        Button skipButton = (Button) findViewById(R.id.eg_skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizFinished) {
                    story = 7;
                }else {
                    skipButton.setVisibility(View.GONE);
                    story = 17;
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
            eg_storyText.setText(storyTexts[story]);
            dark_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }
        else if (story == 1) {
            eg_storyText.setText(storyTexts[story]);
            clear_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 2) {
            eg_storyText.setText(storyTexts[story]);
            dark_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }else if (story == 3) {
            eg_storyText.setText(storyTexts[story]);
            clear_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 4) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String user_Name = settings.getString("user_Name", "");
            String storyText = getString(R.string.eg_storyLine2_4, user_Name);
            eg_storyText.setText(storyText);
            clear_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 5) {
            eg_storyText.setText(storyTexts[story]);
            dark_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 6) {
            eg_storyText.setText(storyTexts[story]);
            clear_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 7) {
            if (!quizFinished) {
                saveLayout(story);
                Intent intent = new Intent(getApplicationContext(), eg_quiz_2.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);
            } else {
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("storyStatus2_1_quiz: " + story);
            }
        }else if (story == 8) {
            eg_storyText.setText(storyTexts[story-1]);
            dark_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(eg_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 9) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String user_Name = settings.getString("user_Name", "");
            String storyText = getString(R.string.eg_storyLine2_9, user_Name);
            eg_storyText.setText(storyText);
            clear_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 10) {
            eg_storyText.setText(storyTexts[story-1]);
            clear_character(eg_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 11) {
            eg_storyText.setText(storyTexts[story-1]);
            clear_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 12) {
            eg_storyText.setText(storyTexts[story-1]);
            clear_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 13) {
            eg_storyText.setText(storyTexts[story-1]);
            dark_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 14) {
            eg_storyText.setText(storyTexts[story-1]);
            clear_character(eg_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 15) {
            eg_storyText.setText(storyTexts[story-1]);
            clear_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 16) {
            eg_storyText.setText(storyTexts[story-1]);
            clear_character(eg_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(eg_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        } else {
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
        name.setTextColor(Color.BLACK);
    }
    //

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
