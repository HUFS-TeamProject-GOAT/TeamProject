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

public class cthall_talk3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_cthall_talk3);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName =(TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_professor = (TextView) findViewById(R.id.name_professor);
        TextView name_minsu =(TextView) findViewById(R.id.name_minsu);



        Button skipButton = (Button) findViewById(R.id.ct_skipButton);

        Button storyLine3_1Button = (Button) findViewById(R.id.ct_storyLine3_1Button);
        Button storyLine3_2Button = (Button) findViewById(R.id.ct_storyLine3_2Button);
        Button storyLine3_3Button = (Button) findViewById(R.id.ct_storyLine3_3Button);
        Button storyLine3_4_Button = (Button) findViewById(R.id.ct_storyLine3_4_Button);
        Button storyLine3_5Button = (Button) findViewById(R.id.ct_storyLine3_5Button);
        Button storyLine3_6Button = (Button) findViewById(R.id.ct_storyLine3_6Button);
        Button storyLine3_7_Button = (Button) findViewById(R.id.ct_storyLine3_7_Button);


        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView professor = (ImageView) findViewById(R.id.professor);
        ImageView minsu = (ImageView) findViewById(R.id.minsu);


        TextView story3_1 =(TextView) findViewById(R.id.ct_storyText3_1);
        TextView story3_2 =(TextView) findViewById(R.id.ct_storyText3_2);
        TextView story3_3=(TextView) findViewById(R.id.ct_storyText3_3);
        TextView story3_4_ =(TextView) findViewById(R.id.ct_storyText3_4_);
        TextView story3_5 =(TextView) findViewById(R.id.ct_storyText3_5);
        TextView story3_6 =(TextView) findViewById(R.id.ct_storyText3_6);
        TextView story3_7_ =(TextView) findViewById(R.id.ct_storyText3_7_);

        skipButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                skipButton.setVisibility(View.INVISIBLE);

                minsu.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
                professor.setVisibility(View.INVISIBLE);
                name_professor.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);
                userName.setVisibility(View.VISIBLE);

                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);

                story3_1.setVisibility(View.INVISIBLE);
                story3_2.setVisibility(View.INVISIBLE);
                story3_3.setVisibility(View.INVISIBLE);
                story3_4_.setVisibility(View.INVISIBLE);
                story3_5.setVisibility(View.VISIBLE);

                storyLine3_1Button.setVisibility(View.INVISIBLE);
                storyLine3_2Button.setVisibility(View.INVISIBLE);
                storyLine3_3Button.setVisibility(View.INVISIBLE);
                storyLine3_4_Button.setVisibility(View.INVISIBLE);
                storyLine3_5Button.setVisibility(View.VISIBLE);
            }
        });



        storyLine3_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               minsu.setVisibility(View.VISIBLE);
               professor.setVisibility((View.INVISIBLE));

                story3_1.setVisibility(View.INVISIBLE);
                story3_2.setVisibility(View.VISIBLE);

                storyLine3_1Button.setVisibility(View.INVISIBLE);
                storyLine3_2Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                name_professor.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setVisibility(View.INVISIBLE);
                minsu.setVisibility(View.INVISIBLE);


                story3_2.setVisibility(View.INVISIBLE);
                story3_3.setVisibility(View.VISIBLE);

                storyLine3_2Button.setVisibility(View.INVISIBLE);
                storyLine3_3Button.setVisibility(View.VISIBLE);


                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3_3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor.setVisibility(View.VISIBLE);
                minsu.setVisibility(View.INVISIBLE);

                story3_3.setVisibility(View.INVISIBLE);
                story3_4_.setVisibility(View.VISIBLE);

                storyLine3_3Button.setVisibility(View.INVISIBLE);
                storyLine3_4_Button.setVisibility(View.VISIBLE);

                name_professor.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);

            }
        });
        storyLine3_4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);
                professor.setVisibility(View.INVISIBLE);
                maincharacter.setVisibility(View.VISIBLE);

                skipButton.setVisibility(View.INVISIBLE);

                story3_4_.setVisibility(View.INVISIBLE);
                story3_5.setVisibility(View.VISIBLE);

                storyLine3_4_Button.setVisibility(View.INVISIBLE);
                storyLine3_5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_professor.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3_5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.setVisibility(View.VISIBLE);
                professor.setVisibility(View.INVISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));



                story3_5.setVisibility(View.INVISIBLE);
                story3_6.setVisibility(View.VISIBLE);

                storyLine3_5Button.setVisibility(View.INVISIBLE);
                storyLine3_6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_minsu.setVisibility(View.VISIBLE);
            }
        });
        storyLine3_6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story3_6.setVisibility(View.INVISIBLE);
                story3_7_.setVisibility(View.VISIBLE);

                storyLine3_6Button.setVisibility(View.INVISIBLE);
                storyLine3_7_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_minsu.setVisibility(View.INVISIBLE);
            }
        });
        storyLine3_7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
