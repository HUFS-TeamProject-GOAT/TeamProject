package com.professionalandroid.apps.teamproject;



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

public class cthall_talk1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_cthall_talk1);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        TextView userName =(TextView) findViewById(R.id.userName);
        Intent intent =getIntent();
        String name =intent.getStringExtra("userName");

        userName.setText(name);
        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_minsu =(TextView) findViewById(R.id.name_minsu);


        Button skipButton = (Button) findViewById(R.id.ct_skipButton);
        Button storyLine1_1Button = (Button) findViewById(R.id.ct_storyLine1_1Button);
        Button storyLine1_2Button = (Button) findViewById(R.id.ct_storyLine1_2Button);
        Button storyLine1_3Button = (Button) findViewById(R.id.ct_storyLine1_3Button);
        Button storyLine1_4Button = (Button) findViewById(R.id.ct_storyLine1_4Button);
        Button storyLine1_5Button = (Button) findViewById(R.id.ct_storyLine1_5Button);
        Button storyLine1_6Button = (Button) findViewById(R.id.ct_storyLine1_6Button);
        Button storyLine1_7_Button = (Button) findViewById(R.id.ct_storyLine1_7_Button);
        Button storyLine1_8Button = (Button) findViewById(R.id.ct_storyLine1_8Button);
        Button storyLine1_9Button = (Button) findViewById(R.id.ct_storyLine1_9Button);
        Button storyLine1_10Button = (Button) findViewById(R.id.ct_storyLine1_10Button);
        Button storyLine1_11_Button = (Button) findViewById(R.id.ct_storyLine1_11_Button);


        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);

        TextView story1_1 =(TextView) findViewById(R.id.ct_storyText1_1);
        TextView story1_2 =(TextView) findViewById(R.id.ct_storyText1_2);
        TextView story1_3 =(TextView) findViewById(R.id.ct_storyText1_3);
        TextView story1_4 =(TextView) findViewById(R.id.ct_storyText1_4);
        TextView story1_5 =(TextView) findViewById(R.id.ct_storyText1_5);
        TextView story1_6 =(TextView) findViewById(R.id.ct_storyText1_6);
        TextView story1_7_ =(TextView) findViewById(R.id.ct_storyText1_7_);
        TextView story1_8 =(TextView) findViewById(R.id.ct_storyText1_8);
        TextView story1_9 =(TextView) findViewById(R.id.ct_storyText1_9);
        TextView story1_10 =(TextView) findViewById(R.id.ct_storyText1_10);
        TextView story1_11_ =(TextView) findViewById(R.id.ct_storyText1_11_);


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);
            }
        });



        storyLine1_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story1_1.setVisibility(View.INVISIBLE);
                story1_2.setVisibility(View.VISIBLE);


                storyLine1_1Button.setVisibility(View.INVISIBLE);
                storyLine1_2Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine1_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_2.setVisibility(View.INVISIBLE);
                story1_3.setVisibility(View.VISIBLE);

                storyLine1_2Button.setVisibility(View.INVISIBLE);
                storyLine1_3Button.setVisibility(View.VISIBLE);


                name_hyerim.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_3.setVisibility(View.INVISIBLE);
                story1_4.setVisibility(View.VISIBLE);

                storyLine1_3Button.setVisibility(View.INVISIBLE);
                storyLine1_4Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_4.setVisibility(View.INVISIBLE);
                story1_5.setVisibility(View.VISIBLE);


                storyLine1_4Button.setVisibility(View.INVISIBLE);
                storyLine1_5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
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
                hyerim.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_6.setVisibility(View.INVISIBLE);
                story1_7_.setVisibility(View.VISIBLE);

                storyLine1_6Button.setVisibility(View.INVISIBLE);
                storyLine1_7_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });

        storyLine1_7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);

                story1_7_.setVisibility(View.INVISIBLE);
                story1_8.setVisibility(View.VISIBLE);

                storyLine1_7_Button.setVisibility(View.INVISIBLE);
                storyLine1_8Button.setVisibility(View.VISIBLE);

                name_hyerim.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);

            }
        });

        storyLine1_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_8.setVisibility(View.INVISIBLE);
                story1_9.setVisibility(View.VISIBLE);
                storyLine1_8Button.setVisibility(View.INVISIBLE);
                storyLine1_9Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_9.setVisibility(View.INVISIBLE);
                story1_10.setVisibility(View.VISIBLE);
                storyLine1_9Button.setVisibility(View.INVISIBLE);
                storyLine1_10Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine1_10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.VISIBLE);
                maincharacter.setVisibility(View.INVISIBLE);
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story1_10.setVisibility(View.INVISIBLE);
                story1_11_.setVisibility(View.VISIBLE);
                storyLine1_10Button.setVisibility(View.INVISIBLE);
                storyLine1_11_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine1_11_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();


            }
        });

    }

}
