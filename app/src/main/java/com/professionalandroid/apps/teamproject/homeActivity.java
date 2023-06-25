package com.professionalandroid.apps.teamproject;

import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class homeActivity extends AppCompatActivity {

    private final int[] ex_Texts = {R.string.ctHall_explain, R.string.egHall_explain, R.string.foodhall_explain, R.string.lake_explain, R.string.lgHall_explain, R.string.lbHall_explain};
    public MediaPlayer clickPlay;
    int stage1, stage2, stage3, stage4;
    private static final String SHARED_PREFS_KEY = "quiz_score";
    private static final String STORY_STATUS_KEY_STAGE1 = "storyStatus"+3; // 스토리 상태를 저장하기 위해 만든 key
    private static final String STORY_STATUS_KEY_STAGE2 = "storyStatus"+7;
    private static final String STORY_STATUS_KEY_STAGE3 = "storyStatus"+11;
    private static final String STORY_STATUS_KEY_STAGE4 = "storyStatus"+15;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);

        Button restart = findViewById(R.id.restart);

        TextView explain_Text = (TextView) findViewById(R.id.explain_text);
        ImageButton egHallButton = (ImageButton) findViewById(R.id.egHallButton);
        Button in_egHallButton =(Button) findViewById(R.id.in_egHallButton);
        ImageView eg_location_red = (ImageView) findViewById(R.id.eg_location_red);

        ImageButton ctHallButton = (ImageButton) findViewById(R.id.ctHallButton);
        Button in_ctHallButton =(Button) findViewById(R.id.in_ctHallButton);
        ImageView ct_location_red = (ImageView) findViewById(R.id.ct_location_red);

        ImageButton lbHallButton = (ImageButton) findViewById(R.id.lbHallButton);
        Button in_lbHallButton =(Button) findViewById(R.id.in_lbHallButton);
        ImageView lb_location_red = (ImageView) findViewById(R.id.lb_location_red);

        ImageButton stHallButton = (ImageButton) findViewById(R.id.stHallButton);
        Button in_stHallButton =(Button) findViewById(R.id.in_stHallButton);
        ImageView st_location_red = (ImageView) findViewById(R.id.st_location_red);


        ImageButton foodHallButton = (ImageButton) findViewById(R.id.foodHallButton);
        Button in_foodHallButton =(Button) findViewById(R.id.in_foodHallButton);
        ImageView foodHall_location_red = (ImageView) findViewById(R.id.foodHall_location_red);

        ImageButton lakeButton = (ImageButton) findViewById(R.id.lakeButton);
        Button in_lakeButton =(Button) findViewById(R.id.in_lakeButton);
        ImageView lake_location_red = (ImageView) findViewById(R.id.lake_location_red);
        clickPlay = MediaPlayer.create(this, R.raw.click);


        // 마지막 스테이지 접근 가능/ 불가능 설정을 stage 클리어 시 저장되는 점수로 판별
        SharedPreferences settings = getSharedPreferences(STORY_STATUS_KEY_STAGE1, MODE_PRIVATE);
        stage1 =settings.getInt(STORY_STATUS_KEY_STAGE1,0);
        Log.d("SharedPreferences", "stage1: " + stage1);
        SharedPreferences settings2 = getSharedPreferences(STORY_STATUS_KEY_STAGE2, MODE_PRIVATE);
        stage2 =settings2.getInt("storyStatus"+7,0);
        Log.d("SharedPreferences", "stage2: " + stage2);
        SharedPreferences settings3 = getSharedPreferences(STORY_STATUS_KEY_STAGE3, MODE_PRIVATE);
        stage3 =settings3.getInt("storyStatus"+11,0);
        Log.d("SharedPreferences", "stage3: " + stage3);
        SharedPreferences settings4 = getSharedPreferences(STORY_STATUS_KEY_STAGE4, MODE_PRIVATE);
        stage4 =settings4.getInt("storyStatus"+15,0);
        Log.d("SharedPreferences", "stage4: " + stage4);
        
        egHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                explain_Text.setVisibility(View.VISIBLE);
                explain_Text.setText(ex_Texts[1]);


                eg_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.VISIBLE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);
            }
        });
        lakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                explain_Text.setVisibility(View.VISIBLE);
                explain_Text.setText(ex_Texts[3]);

                eg_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.VISIBLE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);

            }
        });
        ctHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                explain_Text.setVisibility(View.VISIBLE);
                explain_Text.setText(ex_Texts[0]);

                ct_location_red.setVisibility(View.VISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.VISIBLE);
                in_lbHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
            }
        });
        lbHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                explain_Text.setVisibility(View.VISIBLE);
                explain_Text.setText(ex_Texts[5]);

                lb_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.VISIBLE);
                in_stHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);



            }
        });

        stHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                explain_Text.setVisibility(View.VISIBLE);
                explain_Text.setText(ex_Texts[4]);

                st_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.VISIBLE);

            }
        });

        foodHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();
                explain_Text.setVisibility(View.VISIBLE);
                explain_Text.setText(ex_Texts[2]);

                st_location_red.setVisibility(View.INVISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.VISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.VISIBLE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);

            }
        });
        in_lbHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlay.start();

                if (stage1 == 8 && stage2 == 5 && stage3 == 10 && stage4 == 16) { // 스테이지를 모두 클리어 하게 되면 저장되는 sharedpreference 값)
                    Intent intent = new Intent(getApplicationContext(), lbhall_talkActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.in_last), Toast.LENGTH_SHORT).show();
                }
            }
        });
        in_foodHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                Intent intent =new Intent(getApplicationContext(),foodHallActivity.class);
                startActivity(intent);

            }
        });
        in_ctHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                Intent intent =new Intent(getApplicationContext(),ctHallActivity.class);
                startActivity(intent);
            }
        });
       in_egHallButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               clickPlay.start();
               // 백년관 --> storyStatus end

                   Intent intent =new Intent(getApplicationContext(),egHallActivity.class);
                   startActivity(intent);
//               Intent intent =new Intent(getApplicationContext(),egHallActivity.class);
//               startActivity(intent);
           }
       });
        in_stHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                Intent intent =new Intent(getApplicationContext(),stHallActivity.class);
               startActivity(intent);
            }
        });

        in_lakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                Intent intent =new Intent(getApplicationContext(),lakeActivity.class);
                startActivity(intent);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() { // 초기화 버튼입니다
            @Override
            public void onClick(View v) {
                clickPlay.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(homeActivity.this);
                builder.setTitle(getString(R.string.restart))
                        .setMessage(getString(R.string.beforereset))
                        .setPositiveButton(getString(R.string.check), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                cleandata();
                                Toast.makeText(homeActivity.this, getString(R.string.resetdialog), Toast.LENGTH_SHORT).show();
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

    }
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
