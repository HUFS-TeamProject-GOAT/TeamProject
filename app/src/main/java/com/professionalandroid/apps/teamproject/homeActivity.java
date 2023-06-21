package com.professionalandroid.apps.teamproject;

import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class homeActivity extends AppCompatActivity {

    private final int[] ex_Texts = {R.string.ctHall_explain, R.string.egHall_explain, R.string.foodhall_explain, R.string.lake_explain, R.string.lgHall_explain, R.string.lbHall_explain};
    public MediaPlayer clickPlay;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);
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
            public void onClick(View v){
                clickPlay.start();
                Intent intent =new Intent(getApplicationContext(),lbhall_talkActivity.class);
                startActivity(intent);
            }
        });
        in_foodHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clickPlay.start();
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                boolean bool1 = settings.getString("storyStatus4", "").equals("17");
                boolean bool2 = settings.getString("storyStatus5", "").equals("8");
                boolean bool3 = settings.getString("storyStatus6", "").equals("15");
                boolean bool4 = settings.getString("storyStatus7", "").equals("5");

                // 백년관 --> storyStatus1
                if (!(bool1 && bool2 && bool3 && bool4))
                    Log.d("homeActivity","food_stop");
                else {
                    Intent intent =new Intent(getApplicationContext(),foodHallActivity.class);
                    startActivity(intent);
                }

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
               SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
               boolean bool1 = settings.getString("storyStatus1", "").equals("12");
               boolean bool2 = settings.getString("storyStatus2", "").equals("7");
               boolean bool3 = settings.getString("storyStatus3", "").equals("8");

               // 백년관 --> storyStatus end
               if (!(bool1 && bool2 && bool3))
                   Log.d("homeActivity","eg_stop");
               else {
                   Intent intent =new Intent(getApplicationContext(),ctHallActivity.class);
                   startActivity(intent);
               }

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

    }
}
