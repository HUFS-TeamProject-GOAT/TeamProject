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

public class eghall_talk4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_eghall_talk4);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_extra = (TextView) findViewById(R.id.name_extra);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView extra = (ImageView) findViewById(R.id.extra);

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.eg_storyLine4_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.eg_storyLine4_2Button);
        Button storyLine3_Button = (Button) findViewById(R.id.eg_storyLine4_3_Button);
        Button storyLine4_Button = (Button) findViewById(R.id.eg_storyLine4_4_Button);



        TextView story1 = (TextView) findViewById(R.id.eg_storyText4_1);
        TextView story2 = (TextView) findViewById(R.id.eg_storyText4_2);
        TextView story3_ = (TextView) findViewById(R.id.eg_storyText4_3_);
        TextView story4_ = (TextView) findViewById(R.id.eg_storyText4_4_);


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3_.setVisibility(View.INVISIBLE);
                story4_.setVisibility(View.VISIBLE);


                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3_Button.setVisibility(View.INVISIBLE);
                storyLine4_Button.setVisibility(View.VISIBLE);

            }
        });


        storyLine1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setVisibility((View.VISIBLE));

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                story2.setVisibility(View.INVISIBLE);
                story3_.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3_Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);
                extra.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story3_.setVisibility(View.INVISIBLE);
                story4_.setVisibility(View.VISIBLE);

                storyLine3_Button.setVisibility(View.INVISIBLE);
                storyLine4_Button.setVisibility(View.VISIBLE);

                name_extra.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

    }

}