package com.professionalandroid.apps.teamproject;



import static com.professionalandroid.apps.teamproject.MainActivity.PREFS_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class eghall_talk1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_eghall_talk1);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName =(TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_minsu =(TextView) findViewById(R.id.name_minsu);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);

        Button skipButton = (Button) findViewById(R.id.eg_skipButton);
        Button storyLine1_1Button = (Button) findViewById(R.id.eg_storyLine1_1Button);
        Button storyLine1_2Button = (Button) findViewById(R.id.eg_storyLine1_2Button);
        Button storyLine1_3Button = (Button) findViewById(R.id.eg_storyLine1_3Button);
        Button storyLine1_4_Button = (Button) findViewById(R.id.eg_storyLine1_4_Button);
        Button storyLine1_5Button = (Button) findViewById(R.id.eg_storyLine1_5Button);
        Button storyLine1_6Button = (Button) findViewById(R.id.eg_storyLine1_6Button);
        Button storyLine1_7_Button = (Button) findViewById(R.id.eg_storyLine1_7_Button);


        TextView story1_1 =(TextView) findViewById(R.id.eg_storyText1_1);
        TextView story1_2 =(TextView) findViewById(R.id.eg_storyText1_2);
        TextView story1_3 =(TextView) findViewById(R.id.eg_storyText1_3);
        TextView story1_4_ =(TextView) findViewById(R.id.eg_storyText1_4_);
        TextView story1_5 =(TextView) findViewById(R.id.eg_storyText1_5);
        TextView story1_6 =(TextView) findViewById(R.id.eg_storyText1_6);
        TextView story1_7_ =(TextView) findViewById(R.id.eg_storyText1_7_);



        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);
                story1_1.setVisibility(View.INVISIBLE);
                story1_2.setVisibility(View.INVISIBLE);
                story1_3.setVisibility(View.INVISIBLE);
                story1_4_.setVisibility(View.INVISIBLE);

                storyLine1_1Button.setVisibility(View.INVISIBLE);
                storyLine1_2Button.setVisibility(View.INVISIBLE);
                storyLine1_3Button.setVisibility(View.INVISIBLE);

                hyerim.clearColorFilter();
                hyerim.setVisibility(View.VISIBLE);
                minsu.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_4_.setVisibility(View.INVISIBLE);
                story1_5.setVisibility(View.VISIBLE);


                storyLine1_4_Button.setVisibility(View.INVISIBLE);
                storyLine1_5Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });



        storyLine1_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.VISIBLE);

                story1_1.setVisibility(View.INVISIBLE);
                story1_2.setVisibility(View.VISIBLE);

                storyLine1_1Button.setVisibility(View.INVISIBLE);
                storyLine1_2Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility(View.VISIBLE);
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_2.setVisibility(View.INVISIBLE);
                story1_3.setVisibility(View.VISIBLE);

                storyLine1_2Button.setVisibility(View.INVISIBLE);
                storyLine1_3Button.setVisibility(View.VISIBLE);


                name_hyerim.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine1_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
                hyerim.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_3.setVisibility(View.INVISIBLE);
                story1_4_.setVisibility(View.VISIBLE);

                storyLine1_3Button.setVisibility(View.INVISIBLE);
                storyLine1_4_Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);
                hyerim.clearColorFilter();
                hyerim.setVisibility(View.VISIBLE);
                minsu.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_4_.setVisibility(View.INVISIBLE);
                story1_5.setVisibility(View.VISIBLE);


                storyLine1_4_Button.setVisibility(View.INVISIBLE);
                storyLine1_5Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_5.setVisibility(View.INVISIBLE);
                story1_6.setVisibility(View.VISIBLE);

                storyLine1_5Button.setVisibility(View.INVISIBLE);
                storyLine1_6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
                hyerim.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_6.setVisibility(View.INVISIBLE);
                story1_7_.setVisibility(View.VISIBLE);

                storyLine1_6Button.setVisibility(View.INVISIBLE);
                storyLine1_7_Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });

        storyLine1_7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });


    }

}
