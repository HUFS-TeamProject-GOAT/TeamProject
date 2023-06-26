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
                       //**************엔딩 액티비티****************//
public class endingActivity extends AppCompatActivity {

    int [] score_values = new int[16]; // 점수값을 저장할 배열
    int totalScore=0; // 점수값을 합산할 변수

    private static final String SHARED_PREFS_KEY = "quiz_score"; //퀴즈값을 저장한 공유 프리퍼런스와 같은 이름을 사용
    public MediaPlayer clickPlay;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_ending);
        Button MainButton = (Button) findViewById(R.id.MainButton);
        Button detailButton =(Button) findViewById(R.id.show_detail_button);
        TextView rankText=(TextView) findViewById(R.id.rankText);
        Button back_btn = findViewById(R.id.back_btn);
        Button back_btn_go_home = findViewById(R.id.back_btn_go_home);
        clickPlay = MediaPlayer.create(this, R.raw.click);// 클릭시 효과음
        TextView show_Rank = (TextView)findViewById(R.id.showRank); // A,B,C,D의 랭크가 들어가 텍스트뷰

        //공유 프리퍼런스를 통해 저장한 유저가 입력한 이름을 받음
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        String rankString = getString(R.string.rank, user_Name);
        rankText.setText(rankString);


        //점수값을 배열에 저장하고 totalScore에 추가하여 총점을 구한다.
        for (int i = 0; i < score_values.length ; i++) {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
            score_values[i] = sharedPreferences.getInt("score"+i, 0);
        }
        for (int i = 0; i < score_values.length ; i++) {
            totalScore += score_values[i];
        }

        //calculate함수를 통해 랭크를 정한다.
        String rank = calculateScore(totalScore);
        TextView Rank = (TextView) findViewById(R.id.rank);
        TextView totalScoreTextView = findViewById(R.id.total_score);
        totalScoreTextView.setText(String.valueOf(totalScore+" / 380"));
        Rank.setText(rank);

        //어댑터를 이용하여 퀴즈 값을 리스트뷰로 보여준다.
        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < score_values.length ; i++) {
            itemList.add(getString(R.string.quiz) + i + ": " + score_values[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(endingActivity.this);
                builder.setTitle(getString(R.string.restart))
                        .setMessage(getString(R.string.beforereset))
                        .setPositiveButton(getString(R.string.check), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                cleandata();
                                Toast.makeText(endingActivity.this, getString(R.string.resetdialog), Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton(getString(R.string.notcheck), null);

                AlertDialog dialog = builder.create();

                dialog.setOnShowListener(dialogInterface -> getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#70FFFFFF"))));

                dialog.show();



            }
        });
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                listView.setVisibility(View.VISIBLE); // 퀴즈의 값을 각각 보여주는 리스트뷰
                back_btn.setVisibility(View.VISIBLE);

                totalScoreTextView.setVisibility(View.INVISIBLE);//화면 상단에 보이던 텍스트 뷰
                MainButton.setVisibility(View.INVISIBLE);
                detailButton.setVisibility(View.INVISIBLE);
                Rank.setVisibility(View.INVISIBLE); // 랭크를 보여주는 텍스트 뷰
                rankText.setVisibility(View.INVISIBLE);
                show_Rank.setVisibility(View.INVISIBLE);
                back_btn_go_home.setVisibility(View.INVISIBLE);

            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() { //리스트뷰에서 랭크를 보여주는 화면으로 돌아옴
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.INVISIBLE); //각 퀴즈 값을 보여주던 리스트값
                back_btn.setVisibility(View.INVISIBLE);

                totalScoreTextView.setVisibility(View.VISIBLE); //화면 상단에 보이던 텍스트 뷰
                MainButton.setVisibility(View.VISIBLE);
                detailButton.setVisibility(View.VISIBLE);
                Rank.setVisibility(View.VISIBLE);
                rankText.setVisibility(View.VISIBLE);
                show_Rank.setVisibility(View.VISIBLE);
                back_btn_go_home.setVisibility(View.VISIBLE);
            }
        });

        back_btn_go_home.setOnClickListener(new View.OnClickListener() {// 월드맵으로 가는 버튼
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(intent);
                finish(); //스테이지가 모여있는 월드맵으로 돌아가고 지금의 액티비티를 종료한다
            }
        });

    }
    //총점에 따른 랭크부여 기준
    private String calculateScore(int n){
        if(n>=360){
            return "A"; //합이 360점 이상 인경우
        }
        if(n>=340){
            return "B"; //합이 340점 이상 인경우
        }
        if(n>=320){
            return "C"; //합이 320점 이상 인경우
        }
        else{
            return "D"; //합이 320점 밑인 경우
        }
    }

   //각각의 점수값과 스토리 진행상황을 저장하는 값을 clear 함수를 통해 초기화 한다
    private void cleandata(){
        SharedPreferences preferences1;
        SharedPreferences.Editor editor1;

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();


        for (int i = 0; i < 16; i++) {
            String storyStatusKey = "storyStatus" + i;
            preferences1 = getSharedPreferences(storyStatusKey, Context.MODE_PRIVATE);
            editor1 = preferences1.edit();
            editor1.clear();
            editor1.apply();
        }
    }
}