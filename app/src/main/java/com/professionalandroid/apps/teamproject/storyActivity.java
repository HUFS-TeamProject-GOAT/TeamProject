package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class storyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_story);

        ColorMatrix darkMatrix = new ColorMatrix();
        darkMatrix.setSaturation(0);

        TextView userName =(TextView) findViewById(R.id.userName);
        Intent intent =getIntent();
        String name =intent.getStringExtra("userName");
        userName.setText(name);

        Button skipButton = (Button) findViewById(R.id.skipButton);
        Button story1Button = (Button) findViewById(R.id.storyLine1Button);
        Button story2Button = (Button) findViewById(R.id.storyLine2Button);
        Button story3Button = (Button) findViewById(R.id.storyLine3Button);
        Button story4Button = (Button) findViewById(R.id.storyLine4Button);
        Button story5Button = (Button) findViewById(R.id.storyLine5Button);
        Button story6Button = (Button) findViewById(R.id.storyLine6Button);
        Button story_endButton = (Button) findViewById(R.id.story_endButton);

        Button ct_skipButton = (Button) findViewById(R.id.ct_skipButton);
        Button ct_storyLine1_1Button = (Button) findViewById(R.id.ct_storyLine1_1Button);
        Button ct_storyLine1_2Button = (Button) findViewById(R.id.ct_storyLine1_2Button);
        Button ct_storyLine1_3Button = (Button) findViewById(R.id.ct_storyLine1_3Button);
        Button ct_storyLine1_4Button = (Button) findViewById(R.id.ct_storyLine1_4Button);
        Button ct_storyLine1_5Button = (Button) findViewById(R.id.ct_storyLine1_5Button);
        Button ct_storyLine1_6Button = (Button) findViewById(R.id.ct_storyLine1_6Button);
        Button ct_storyLine1_7_Button = (Button) findViewById(R.id.ct_storyLine1_7_Button);

        ImageView minsu = (ImageView) findViewById(R.id.minsu);
        ImageView maincharacter = (ImageView) findViewById(R.id.maincharacter);
        ImageView hyerim = (ImageView) findViewById(R.id.hyerim);

        TextView story1 =(TextView) findViewById(R.id.storyText1);
        TextView story2 =(TextView) findViewById(R.id.storyText2);
        TextView story3 =(TextView) findViewById(R.id.storyText3);
        TextView story4 =(TextView) findViewById(R.id.storyText4);
        TextView story5 =(TextView) findViewById(R.id.storyText5);
        TextView story6 =(TextView) findViewById(R.id.storyText6);
        TextView story7 =(TextView) findViewById(R.id.storyText7);

        TextView ct_story1_1 =(TextView) findViewById(R.id.ct_storyText1_1);
        TextView ct_story1_2 =(TextView) findViewById(R.id.ct_storyText1_2);
        TextView ct_story1_3 =(TextView) findViewById(R.id.ct_storyText1_3);
        TextView ct_story1_4 =(TextView) findViewById(R.id.ct_storyText1_4);
        TextView ct_story1_5 =(TextView) findViewById(R.id.ct_storyText1_5);
        TextView ct_story1_6 =(TextView) findViewById(R.id.ct_storyText1_6);
        TextView ct_story1_7_ =(TextView) findViewById(R.id.ct_storyText1_7_);


        TextView name_minsu = (TextView) findViewById(R.id.name_minsu);
        TextView name_hyerim = (TextView) findViewById(R.id.name_hyerim);


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);
            }
        });

        story1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                minsu.setVisibility(View.VISIBLE);

                story1.setVisibility(View.INVISIBLE);
                story2.setVisibility(View.VISIBLE);

                story1Button.setVisibility(View.INVISIBLE);
                story2Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        story2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story2.setVisibility(View.INVISIBLE);
                story3.setVisibility(View.VISIBLE);

                story2Button.setVisibility(View.INVISIBLE);
                story3Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        story3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story3.setVisibility(View.INVISIBLE);
                story4.setVisibility(View.VISIBLE);


                story3Button.setVisibility(View.INVISIBLE);
                story4Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        story4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story4.setVisibility(View.INVISIBLE);
                story5.setVisibility(View.VISIBLE);

                story4Button.setVisibility(View.INVISIBLE);
                story5Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        story5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minsu.clearColorFilter();
                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));

                story5.setVisibility(View.INVISIBLE);
                story6.setVisibility(View.VISIBLE);

                story5Button.setVisibility(View.INVISIBLE);
                story6Button.setVisibility(View.VISIBLE);


                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);
            }
        });
        story6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maincharacter.clearColorFilter();
                minsu.setColorFilter(new ColorMatrixColorFilter(darkMatrix));


                story6.setVisibility(View.INVISIBLE);
                story7.setVisibility(View.VISIBLE);

                story6Button.setVisibility(View.INVISIBLE);
                story_endButton.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.INVISIBLE);
                userName.setVisibility(View.VISIBLE);
            }
        });
        story_endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),homeActivity.class);
                startActivity(intent);

                maincharacter.setColorFilter(new ColorMatrixColorFilter(darkMatrix));
                minsu.setVisibility(View.VISIBLE);

                ct_story1_1.setVisibility(View.VISIBLE);

                ct_storyLine1_1Button.setVisibility(View.VISIBLE);

                name_minsu.setVisibility(View.VISIBLE);
                userName.setVisibility(View.INVISIBLE);


            }
        });
    }

}
