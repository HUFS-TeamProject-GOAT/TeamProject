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

public class foodhall_talk3Activity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 1;

    private final int[] storyTexts = {
            R.string.food_storyLine3_1, R.string.food_storyLine3_2, R.string.food_storyLine3_3,
            R.string.food_storyLine3_4, R.string.food_storyLine3_5_, R.string.food_storyLine3_6,
            R.string.food_storyLine3_7, R.string.food_storyLine3_8_
    };

    private final int[] imageResources1 = {android.R.color.transparent, R.drawable.maincharacter, R.drawable.minsu, R.drawable.hyerim};
    private final int[] textResources= {R.layout.activity_foodhall_talk3,R.id.maincharacter,R.id.name_minsu, R.id.name_hyerim};

    private boolean quizFinished = false;
    private TextView food_storyText;

    private TextView userName;
    private TextView subName;
    private ImageView food_imageView1;
    private ImageView food_imageView2;

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus3_3"; // 스토리 상태를 저장하기 위해 만든 key


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_foodhall_talk3);


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
        subName = (TextView) findViewById(R.id.name_hyerim);
        userName.setText(user_Name);

        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings1.edit();
        editor.remove(STORY_STATUS_KEY);
        editor.putInt(STORY_STATUS_KEY, 0);
        editor.apply();

        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);


        System.out.println("stroyStatus3_3: " + story);


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

            dark_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            dark_character(food_imageView1,imageResources1[1],userName,textResources[1]);


            story++;
            System.out.println("stroyStatus3_3: " + story);
        }
        else if (story == 1) {

            saveLayout(story);
            food_storyText.setText(storyTexts[story]);

            clear_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            dark_character(food_imageView1,imageResources1[1],userName,textResources[1]);


            story++;
            System.out.println("stroyStatus3_3: " + story);

        }else if (story == 2) {
            saveLayout(story);
            food_storyText.setText(storyTexts[story]);
            dark_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            clear_character(food_imageView1,imageResources1[1],userName,textResources[1]);

            story++;
            System.out.println("stroyStatus3_3: " + story);

        }else if (story == 3) {
            saveLayout(story);
            food_storyText.setText(storyTexts[story]);
            clear_character(food_imageView2,imageResources1[2],subName,textResources[2]);
            dark_character(food_imageView1,imageResources1[1],userName,textResources[1]);

            story++;
            System.out.println("stroyStatus3_3: " + story);
        }else if (story == 4) {

            saveLayout(story);
            food_storyText.setText(storyTexts[story]);
            dark_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            clear_character(food_imageView1,imageResources1[1],userName,textResources[1]);

            story++;
        }else if (story == 5) {

            if (!quizFinished) {
                saveLayout(story);
                Intent intent = new Intent(getApplicationContext(), fd_quiz_3.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);

            } else {
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("stroyStatus3_3_quiz: " + story);
            }

        }else if (story == 6) {

            food_storyText.setText(storyTexts[story-1]);
            clear_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            dark_character(food_imageView1,imageResources1[1],userName,textResources[1]);

            story++;
            System.out.println("stroyStatus3_3: " + story);

        }  else if (story == 7) {

            food_storyText.setText(storyTexts[story-1]);

            dark_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            clear_character(food_imageView1,imageResources1[1],userName,textResources[1]);


            story++;
            System.out.println("stroyStatus3_3: " + story);

        }
        else if (story == 8) {

            food_storyText.setText(storyTexts[story-1]);
            clear_character(food_imageView2,imageResources1[3],subName,textResources[3]);
            dark_character(food_imageView1,imageResources1[1],userName,textResources[1]);

            story++;
            System.out.println("stroyStatus3_3: " + story);

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
        if (textResources == R.id.maincharacter) {
            name.setText(user_Name);
        } else if (textResources == R.id.name_minsu) {
            name.setText("케인");
        } else if (textResources == R.id.name_hyerim) {
            name.setText("록시");
        }
        else if (textResources == R.id.name_extra) {
            name.setText("asdf");
        }

        name.setTextColor(Color.GRAY);
    }
    protected void clear_character(ImageView image,int imageResources,TextView name,int textResources){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        image.setImageResource(imageResources);
        image.clearColorFilter();
        if (textResources == R.id.maincharacter) {
            name.setText(user_Name);
        } else if (textResources == R.id.name_minsu) {
            name.setText("케인");
        } else if (textResources == R.id.name_hyerim) {
            name.setText("록시");
        }
        else if (textResources == R.id.name_extra) {
            name.setText("asdf");
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
