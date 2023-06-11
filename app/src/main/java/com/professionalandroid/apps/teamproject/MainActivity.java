package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.media.MediaPlayer;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final  String PREFS_NAME = "MyPREFS";

    private Button btn;
    public MediaPlayer mediaPlayer;
    EditText userName;
    String user_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BGM 재생
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        userName = (EditText)findViewById(R.id.userName);

        Button startButton = (Button) findViewById(R.id.startButton);
        ImageButton languageButton = (ImageButton) findViewById(R.id.globalImage);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user_Name = settings.getString("user_Name","");



        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                user_Name = userName.getText().toString();
                if (user_Name.isEmpty()) { // 닉네임이 비어있는 경우
                    showAlertDialog("닉네임을 입력해주세요");
                } else {
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("user_Name", user_Name);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), storyActivity.class);
                    intent.putExtra("userName", user_Name);
                    startActivity(intent);
                }
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
    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}