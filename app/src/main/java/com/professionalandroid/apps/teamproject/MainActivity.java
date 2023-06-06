package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public static final  String PREFS_NAME = "MyPREFS";

    private Button btn;
    EditText userName;
    String user_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName = (EditText)findViewById(R.id.userName);
        Button startButton = (Button) findViewById(R.id.startButton);
        ImageButton languageButton = (ImageButton) findViewById(R.id.globalImage);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user_Name = settings.getString("user_Name","");

        SharedPreferences gameChapter = getSharedPreferences("GameChapter", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = gameChapter.edit();


        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                user_Name = userName.getText().toString();
                editor.putString("user_Name",user_Name);
                editor.apply();
                Intent intent =new Intent(getApplicationContext(),storyActivity.class);
                intent.putExtra("userName",user_Name);
                startActivity(intent);
            }
        });
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),languageActivity.class);
                startActivity(intent);
            }
        });
    }
}