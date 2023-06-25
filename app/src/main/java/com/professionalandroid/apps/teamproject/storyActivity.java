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

public class storyActivity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 1;
    //스토리 내용을 스트링 리소스 파일에서 참조하는 배열
    private final int[] storyTexts = {R.string.storyLine1, R.string.storyLine2, R.string.storyLine3, R.string.storyLine4,R.string.storyLine5, R.string.storyLine6, R.string.storyLine7};
    //drawable 파일의 인물 이미지를 참조 받는 배열
    private final int[] imageResources = {android.R.color.transparent, R.drawable.maincharacter,R.drawable.minsu};
    // 스트링 리소스 파일의 각각의 이름을 참조하는 배열
    private final int[] textResources = {R.layout.activity_cthall_talk1, R.id.userName, R.id.name_minsu};

    private boolean quizFinished = false; //퀴즈를 풀었는지에 대한 bool타입의 변수
    private TextView ct_storyText;  // 대화가 표시될 텍스트

    private TextView userName;
    private TextView subName;
    private ImageView ct_imageView1; //주인공의 이미지가 들어갈 뷰
    private ImageView ct_imageView2; // 주인공과 대화하는 인물의 이미지가 들어갈 뷰

    private int story;
    private static final String STORY_STATUS_KEY = "storyStatus"+0; // 스토리 상태를 저장하기 위해 만든 key
    public MediaPlayer clickPlay; //클릭시 소리 나게끔


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_story);
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

        //공유 프리퍼런스에 저장된 입력받은 이름을 가져옴
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        subName = (TextView) findViewById(R.id.name_hyerim); // subName으로 변경
        userName.setText(user_Name);

        //스토리 진행상황을 저장하는 변수 'story'
        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);

        showNextStoryText();




        Button skipButton = (Button) findViewById(R.id.ct_skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                skipButton.setVisibility(View.GONE);
                story = 7;
                showNextStoryText();
            }
        });
    }
    public void saveLayout(int story){ // 스토리 진행상황을 공유 프리퍼런스에 저장
        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings1.edit();
        editor.putInt(STORY_STATUS_KEY, story);
        editor.apply();
    }

    private void showNextStoryText() {  //story변수와 배열의 인덱스 값을 비교하여 화면을 구현
        if (story == 0) {
            saveLayout(story);
            ct_storyText.setText(storyTexts[story]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }
        else if (story == 1) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 2) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 3) {
            ct_storyText.setText(storyTexts[story]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 4) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 5) {
            ct_storyText.setText(storyTexts[story]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }else if (story == 6) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }else if (story == 7) {  // quiz
            if (!quizFinished) { //quizFinished의  값을 보고 풀었는지에 대한 사실 파악
                saveLayout(story);
                clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
                ct_storyText.setText(storyTexts[story-1]);
                Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);
            } else { // 스토리를 풀었을경우 다음 대화로 계속 잔행
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("storyStatus1_1_quiz: " + story);
            }
        } else {
            saveLayout(story);
            Intent intent = new Intent(getApplicationContext(), homeActivity.class);
            startActivity(intent);
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
