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
                      //************* 대화 액티비티*************//
public class cthall_talk1Activity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 1;

    //스토리 내용을 스트링 리소스 파일에서 참조하는 배열
    private final int[] storyTexts = {R.string.ct_storyLine1_1, R.string.ct_storyLine1_2, R.string.ct_storyLine1_3, R.string.ct_storyLine1_4,R.string.ct_storyLine1_5, R.string.ct_storyLine1_6, R.string.ct_storyLine1_7_, R.string.ct_storyLine1_8,R.string.ct_storyLine1_9,R.string.ct_storyLine1_10,R.string.ct_storyLine1_11_};
    //drawable 파일의 인물 이미지를 참조 받는 배열
    private final int[] imageResources = {android.R.color.transparent, R.drawable.maincharacter,R.drawable.minsu, R.drawable.hyerim};
    // 스트링 리소스 파일의 각각의 이름을 참조하는 배열
    private final int[] textResources = {R.layout.activity_cthall_talk1, R.id.userName, R.id.name_minsu, R.id.name_hyerim};

    private boolean quizFinished = false; //퀴즈를 풀었는지에 대한 bool타입의 변수
    private TextView ct_storyText; // 대화가 표시될 텍스트

    private TextView userName;
    private TextView subName;
    private ImageView ct_imageView1;
    private ImageView ct_imageView2;
    public MediaPlayer clickPlay;

    private int story;//스토리 진행을 위한 변수

    private static final String STORY_STATUS_KEY = "storyStatus"+1; // 스토리 상태를 저장하기 위해 만든 key


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cthall_talk1);
        clickPlay = MediaPlayer.create(this, R.raw.click);

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //다음 버튼을 누를경우 다음 대화가 보이게함
                showNextStoryText();
                clickPlay.start();
            }
        });
        ct_storyText = findViewById(R.id.ct_storyText);
        ct_imageView1 = findViewById(R.id.ct_imageView1);// 주인공 이미지가 들어갈 부분
        ct_imageView2 = findViewById(R.id.ct_imageView2);// 주인공과 대화하는 인물들의 이미지가 들어갈 부분


        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        //쉐어드 프리퍼런스로 유저가 입력한 이름을 받음
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        userName = (TextView) findViewById(R.id.userName);
        subName = (TextView) findViewById(R.id.name_hyerim); // subName으로 변경
        userName.setText(user_Name);

        // 저장된 스토리 진행상황을 진행시킴
        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, Context.MODE_PRIVATE);
        story = settings1.getInt(STORY_STATUS_KEY, 0);
        saveLayout(story);


        showNextStoryText();


        Button skipButton = (Button) findViewById(R.id.ct_skipButton);
        //스킵 버튼누르는 경우에 대한 처리
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                if(!quizFinished) {
                    story = 7; // 퀴즈를 풀지 못한 경우
                }else {
                    skipButton.setVisibility(View.GONE);
                    story = 12; // 퀴즈를  맞췄을 경우 다음 대화로 넘어감
                }
                showNextStoryText();

            }
        });
    }
    //진행상황을 저장함
    public void saveLayout(int story){
        SharedPreferences settings1 = getSharedPreferences(STORY_STATUS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings1.edit();
        editor.putInt(STORY_STATUS_KEY, story);
        editor.apply();
    }

    // 다음 스토리를 story변수의 값에따라 설정함
    private void showNextStoryText() { //story변수와 배열의 인덱스 값을 비교하여 화면을 구현
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
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);// 비 발화자를 어둡게
            clear_character(ct_imageView2,imageResources[3],subName,textResources[3]);//발화자를 밝게
            story++;
        }else if (story == 3) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 4) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }else if (story == 5) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView2,imageResources[2],subName,textResources[2]);
            story++;
        }else if (story == 6) {
            ct_storyText.setText(storyTexts[story]);
            clear_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 7) {  //문제가 나오는 곳
            if (!quizFinished) { //quizFinished의  값을 보고 풀었는지에 대한 사실 파악
                saveLayout(story);
                clear_character(ct_imageView2,imageResources[3],subName,textResources[3]);
                ct_storyText.setText(storyTexts[story-1]);
                Intent intent = new Intent(getApplicationContext(), ct_quiz_2.class);
                startActivityForResult(intent, YOUR_REQUEST_CODE);
            } else {
                story++;
                showNextStoryText();
                saveLayout(story);
                System.out.println("storyStatus1_1_quiz: " + story);
            }

        }else if (story == 8) {
            ct_storyText.setText(storyTexts[story-1]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            clear_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }
        else if (story == 9) {
            ct_storyText.setText(storyTexts[story-1]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 10) {
            ct_storyText.setText(storyTexts[story-1]);
            dark_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            dark_character(ct_imageView2,imageResources[3],subName,textResources[3]);
            story++;
        }else if (story == 11) {
            ct_storyText.setText(storyTexts[story-1]);
            clear_character(ct_imageView1,imageResources[1],userName,textResources[1]);
            story++;
        }
        else {
            saveLayout(story);
            findViewById(R.id.nextButton).setVisibility(View.GONE);
            finish();
        }
    }
    //비 발화자를 어둡게 하는 함수
    protected void dark_character(ImageView image,int imageResources,TextView name,int textResources){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);
        image.setImageResource(imageResources);
        image.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
        if (textResources == R.id.userName) { //주인공인 경우
            name.setText(user_Name);
        } else if (textResources == R.id.name_minsu) { //케인인 경우
            name.setText(getText(R.string.kane));
        } else if (textResources == R.id.name_hyerim) { //록시인 경우
            name.setText(getText(R.string.roksi));
        }
        name.setTextColor(Color.GRAY); // 이름과 이미지를 어둡게 함
    }
    protected void clear_character(ImageView image,int imageResources,TextView name,int textResources){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        image.setImageResource(imageResources);
        image.clearColorFilter();
        if (textResources == R.id.userName) {//주인공인 경우
            name.setText(user_Name);
        } else if (textResources == R.id.name_minsu) { //케인인 경우
            name.setText(getText(R.string.kane));
        } else if (textResources == R.id.name_hyerim) { //록시인 경우
            name.setText(getText(R.string.roksi));
        }
        name.setTextColor(Color.BLACK); //발화자를 밝게함
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

    //퀴즈를 풀었는지에대한 값을 퀴즈 액티비티로부터 값을 intent로 받음
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //받은 값에 대한 처리
        if (requestCode == YOUR_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            quizFinished = data.getBooleanExtra("quizFinished", false);
            if (quizFinished) {
                showNextStoryText();
            }
        }
    }

}
