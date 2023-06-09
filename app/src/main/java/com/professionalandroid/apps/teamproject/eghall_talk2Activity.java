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

public class eghall_talk2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_eghall_talk2);

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

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button skipButton1 = (Button) findViewById(R.id.skipButton1);
        Button storyLine2_1Button = (Button) findViewById(R.id.eg_storyLine2_1Button);
        Button storyLine2_2Button = (Button) findViewById(R.id.eg_storyLine2_2Button);
        Button storyLine2_3Button = (Button) findViewById(R.id.eg_storyLine2_3Button);
        Button storyLine2_4Button = (Button) findViewById(R.id.eg_storyLine2_4Button);
        Button storyLine2_5Button = (Button) findViewById(R.id.eg_storyLine2_5Button);
        Button storyLine2_6Button = (Button) findViewById(R.id.eg_storyLine2_6Button);
        Button storyLine2_7_Button = (Button) findViewById(R.id.eg_storyLine2_7_Button);
        Button storyLine2_8Button = (Button) findViewById(R.id.eg_storyLine2_8Button);
        Button storyLine2_9Button = (Button) findViewById(R.id.eg_storyLine2_9Button);
        Button storyLine2_10Button = (Button) findViewById(R.id.eg_storyLine2_10Button);
        Button storyLine2_11Button = (Button) findViewById(R.id.eg_storyLine2_11Button);
        Button storyLine2_12Button = (Button) findViewById(R.id.eg_storyLine2_12Button);
        Button storyLine2_13Button = (Button) findViewById(R.id.eg_storyLine2_13Button);
        Button storyLine2_14Button = (Button) findViewById(R.id.eg_storyLine2_14Button);
        Button storyLine2_15Button = (Button) findViewById(R.id.eg_storyLine2_15Button);
        Button storyLine2_16_Button = (Button) findViewById(R.id.eg_storyLine2_16_Button);


        TextView story2_1 =(TextView) findViewById(R.id.eg_storyText2_1);
        TextView story2_2 =(TextView) findViewById(R.id.eg_storyText2_2);
        TextView story2_3 =(TextView) findViewById(R.id.eg_storyText2_3);
        TextView story2_4 =(TextView) findViewById(R.id.eg_storyText2_4);
        TextView story2_5 =(TextView) findViewById(R.id.eg_storyText2_5);
        TextView story2_6 =(TextView) findViewById(R.id.eg_storyText2_6);
        TextView story2_7_ =(TextView) findViewById(R.id.eg_storyText2_7_);
        TextView story2_8 =(TextView) findViewById(R.id.eg_storyText2_8);
        TextView story2_9 =(TextView) findViewById(R.id.eg_storyText2_9);
        TextView story2_10 =(TextView) findViewById(R.id.eg_storyText2_10);
        TextView story2_11 =(TextView) findViewById(R.id.eg_storyText2_11);
        TextView story2_12 =(TextView) findViewById(R.id.eg_storyText2_12);
        TextView story2_13 =(TextView) findViewById(R.id.eg_storyText2_13);
        TextView story2_14 =(TextView) findViewById(R.id.eg_storyText2_14);
        TextView story2_15 =(TextView) findViewById(R.id.eg_storyText2_15);
        TextView story2_16_ =(TextView) findViewById(R.id.eg_storyText2_16_);



        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);
                skipButton1.setVisibility(View.VISIBLE);

                maincharacter.setVisibility(View.VISIBLE);
                maincharacter.clearColorFilter();
                minsu.setVisibility(View.INVISIBLE);
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);

                skipButton.setVisibility(View.INVISIBLE);

                story2_1.setVisibility(View.INVISIBLE);
                story2_2.setVisibility(View.INVISIBLE);
                story2_3.setVisibility(View.INVISIBLE);
                story2_4.setVisibility(View.INVISIBLE);
                story2_5.setVisibility(View.INVISIBLE);
                story2_6.setVisibility(View.INVISIBLE);
                story2_7_.setVisibility(View.INVISIBLE);
                story2_8.setVisibility(View.VISIBLE);

                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);


                storyLine2_1Button.setVisibility(View.INVISIBLE);
                storyLine2_2Button.setVisibility(View.INVISIBLE);
                storyLine2_3Button.setVisibility(View.INVISIBLE);
                storyLine2_4Button.setVisibility(View.INVISIBLE);
                storyLine2_5Button.setVisibility(View.INVISIBLE);
                storyLine2_6Button.setVisibility(View.INVISIBLE);
                storyLine2_7_Button.setVisibility(View.INVISIBLE);
                storyLine2_8Button.setVisibility(View.VISIBLE);
            }
        });



        storyLine2_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility((View.VISIBLE));
                maincharacter.clearColorFilter();
                minsu.setVisibility(View.INVISIBLE);
                minsu.clearColorFilter();
                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);

                story2_1.setVisibility(View.INVISIBLE);
                story2_2.setVisibility(View.VISIBLE);

                storyLine2_1Button.setVisibility(View.INVISIBLE);
                storyLine2_2Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility((View.VISIBLE));

                story2_2.setVisibility(View.INVISIBLE);
                story2_3.setVisibility(View.VISIBLE);

                storyLine2_2Button.setVisibility(View.INVISIBLE);
                storyLine2_3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_3.setVisibility(View.INVISIBLE);
                story2_4.setVisibility(View.VISIBLE);

                storyLine2_3Button.setVisibility(View.INVISIBLE);
                storyLine2_4Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_4.setVisibility(View.INVISIBLE);
                story2_5.setVisibility(View.VISIBLE);

                storyLine2_4Button.setVisibility(View.INVISIBLE);
                storyLine2_5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_5.setVisibility(View.INVISIBLE);
                story2_6.setVisibility(View.VISIBLE);

                storyLine2_5Button.setVisibility(View.INVISIBLE);
                storyLine2_6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_6.setVisibility(View.INVISIBLE);
                story2_7_.setVisibility(View.VISIBLE);

                storyLine2_6Button.setVisibility(View.INVISIBLE);
                storyLine2_7_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });

        storyLine2_7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);

                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_7_.setVisibility(View.INVISIBLE);
                story2_8.setVisibility(View.VISIBLE);

                storyLine2_7_Button.setVisibility(View.INVISIBLE);
                storyLine2_8Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_8.setVisibility(View.INVISIBLE);
                story2_9.setVisibility(View.VISIBLE);

                storyLine2_8Button.setVisibility(View.INVISIBLE);
                storyLine2_9Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_9.setVisibility(View.INVISIBLE);
                story2_10.setVisibility(View.VISIBLE);

                storyLine2_9Button.setVisibility(View.INVISIBLE);
                storyLine2_10Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_10.setVisibility(View.INVISIBLE);
                story2_11.setVisibility(View.VISIBLE);

                storyLine2_10Button.setVisibility(View.INVISIBLE);
                storyLine2_11Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_11.setVisibility(View.INVISIBLE);
                story2_12.setVisibility(View.VISIBLE);

                storyLine2_11Button.setVisibility(View.INVISIBLE);
                storyLine2_12Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_12.setVisibility(View.INVISIBLE);
                story2_13.setVisibility(View.VISIBLE);

                storyLine2_12Button.setVisibility(View.INVISIBLE);
                storyLine2_13Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_13.setVisibility(View.INVISIBLE);
                story2_14.setVisibility(View.VISIBLE);

                storyLine2_13Button.setVisibility(View.INVISIBLE);
                storyLine2_14Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2_14.setVisibility(View.INVISIBLE);
                story2_15.setVisibility(View.VISIBLE);

                storyLine2_14Button.setVisibility(View.INVISIBLE);
                storyLine2_15Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine2_15Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.INVISIBLE);
                maincharacter.clearColorFilter();

                story2_15.setVisibility(View.INVISIBLE);
                story2_16_.setVisibility(View.VISIBLE);

                storyLine2_15Button.setVisibility(View.INVISIBLE);
                storyLine2_16_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine2_16_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        skipButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}