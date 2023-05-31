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

public class eghall_talk3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_eghall_talk3);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String user_Name = settings.getString("user_Name", "");
        TextView userName = (TextView) findViewById(R.id.userName);
        userName.setText(user_Name);

        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);
        TextView name_hyungchan = (TextView) findViewById(R.id.name_hyungchan);

        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);
        ImageView hyungchan = (ImageView) findViewById(R.id.hyungchan);

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button storyLine1Button = (Button) findViewById(R.id.eg_storyLine3_1Button);
        Button storyLine2Button = (Button) findViewById(R.id.eg_storyLine3_2Button);
        Button storyLine3Button = (Button) findViewById(R.id.eg_storyLine3_3Button);
        Button storyLine4Button = (Button) findViewById(R.id.eg_storyLine3_4Button);
        Button storyLine5Button = (Button) findViewById(R.id.eg_storyLine3_5Button);
        Button storyLine6Button = (Button) findViewById(R.id.eg_storyLine3_6Button);
        Button storyLine7Button = (Button) findViewById(R.id.eg_storyLine3_7Button);
        Button storyLine8Button = (Button) findViewById(R.id.eg_storyLine3_8Button);
        Button storyLine9Button = (Button) findViewById(R.id.eg_storyLine3_9Button);
        Button storyLine10_Button = (Button) findViewById(R.id.eg_storyLine3_10_Button);
        Button storyLine11Button = (Button) findViewById(R.id.eg_storyLine3_11Button);
        Button storyLine12Button = (Button) findViewById(R.id.eg_storyLine3_12Button);
        Button storyLine13Button = (Button) findViewById(R.id.eg_storyLine3_13Button);
        Button storyLine14_Button = (Button) findViewById(R.id.eg_storyLine3_14_Button);


        TextView story1 = (TextView) findViewById(R.id.eg_storyText3_1);
        TextView story2 = (TextView) findViewById(R.id.eg_storyText3_2);
        TextView story3 = (TextView) findViewById(R.id.eg_storyText3_3);
        TextView story4 = (TextView) findViewById(R.id.eg_storyText3_4);
        TextView story5 = (TextView) findViewById(R.id.eg_storyText3_5);
        TextView story6 = (TextView) findViewById(R.id.eg_storyText3_6);
        TextView story7 = (TextView) findViewById(R.id.eg_storyText3_7);
        TextView story8 = (TextView) findViewById(R.id.eg_storyText3_8);
        TextView story9 = (TextView) findViewById(R.id.eg_storyText3_9);
        TextView story10_ = (TextView) findViewById(R.id.eg_storyText3_10_);
        TextView story11 = (TextView) findViewById(R.id.eg_storyText3_11);
        TextView story12 = (TextView) findViewById(R.id.eg_storyText3_12);
        TextView story13 = (TextView) findViewById(R.id.eg_storyText3_13);
        TextView story14_ = (TextView) findViewById(R.id.eg_storyText3_14_);



        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.INVISIBLE);
                story8.setVisibility(View.INVISIBLE);
                story9.setVisibility(View.INVISIBLE);
                story10_.setVisibility(View.VISIBLE);

                Intent intent = new Intent(getApplicationContext(), quizexActivity.class);
                startActivity(intent);

                storyLine1Button.setVisibility(View.INVISIBLE);
                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8Button.setVisibility(View.INVISIBLE);
                storyLine9Button.setVisibility(View.INVISIBLE);
                storyLine10_Button.setVisibility(View.VISIBLE);
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
                story3.setVisibility(View.VISIBLE);

                storyLine2Button.setVisibility(View.INVISIBLE);
                storyLine3Button.setVisibility(View.VISIBLE);


                userName.setVisibility(View.VISIBLE);
            }
        });
        storyLine3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyungchan.setVisibility(View.VISIBLE);
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);

                storyLine3Button.setVisibility(View.INVISIBLE);
                storyLine4Button.setVisibility(View.VISIBLE);

                name_hyungchan.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        storyLine4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyungchan.clearColorFilter();

                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.VISIBLE);

                storyLine4Button.setVisibility(View.INVISIBLE);
                storyLine5Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyungchan.setVisibility(View.INVISIBLE);
            }
        });
        storyLine5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyungchan.clearColorFilter();
               maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story5.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);

                storyLine5Button.setVisibility(View.INVISIBLE);
                storyLine6Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyungchan.setVisibility(View.VISIBLE);
            }
        });
        storyLine6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               hyungchan.setVisibility(View.INVISIBLE);
               hyerim.setVisibility(View.VISIBLE);

               story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                storyLine6Button.setVisibility(View.INVISIBLE);
                storyLine7Button.setVisibility(View.VISIBLE);

                hyungchan.setVisibility(View.VISIBLE);
                maincharacter.setVisibility(View.INVISIBLE);
            }
        });

        storyLine7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyungchan.setVisibility(View.INVISIBLE);
               hyerim.setVisibility(View.VISIBLE);
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story7.setVisibility(View.INVISIBLE);
                story8.setVisibility(View.VISIBLE);

                storyLine7Button.setVisibility(View.INVISIBLE);
                storyLine8Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story8.setVisibility(View.INVISIBLE);
                story9.setVisibility(View.VISIBLE);

                storyLine8Button.setVisibility(View.INVISIBLE);
                storyLine9Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story9.setVisibility(View.INVISIBLE);
                story10_.setVisibility(View.VISIBLE);

                storyLine9Button.setVisibility(View.INVISIBLE);
                storyLine10_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine10_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),quizexActivity.class);
                startActivity(intent);

                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story10_.setVisibility(View.INVISIBLE);
                story11.setVisibility(View.VISIBLE);

                storyLine10_Button.setVisibility(View.INVISIBLE);
                storyLine11Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);

            }
        });
        storyLine11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();

                story11.setVisibility(View.INVISIBLE);
                story12.setVisibility(View.VISIBLE);

                storyLine11Button.setVisibility(View.INVISIBLE);
                storyLine12Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyerim.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story12.setVisibility(View.INVISIBLE);
                story13.setVisibility(View.VISIBLE);

                storyLine12Button.setVisibility(View.INVISIBLE);
                storyLine13Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.INVISIBLE);
                name_hyerim.setVisibility(View.VISIBLE);
            }
        });
        storyLine13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               maincharacter.clearColorFilter();
               hyerim.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story13.setVisibility(View.INVISIBLE);
                story14_.setVisibility(View.VISIBLE);

                storyLine13Button.setVisibility(View.INVISIBLE);
                storyLine14_Button.setVisibility(View.VISIBLE);

                userName.setVisibility(View.VISIBLE);
                name_hyerim.setVisibility(View.INVISIBLE);
            }
        });
        storyLine14_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}