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
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    public static final  String PREFS_NAME = "MyPREFS";

    public MediaPlayer mediaPlayer, clickPlay;
    EditText userName;
    String user_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BGM 재생
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm);
        clickPlay = MediaPlayer.create(this, R.raw.click);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        userName = (EditText)findViewById(R.id.userName);

        Button startButton = (Button) findViewById(R.id.startButton);
        ImageButton languageButton = (ImageButton) findViewById(R.id.globalImage);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user_Name = settings.getString("user_Name","");



        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                user_Name = userName.getText().toString();
                clickPlay.start();
                if (user_Name.isEmpty()) { // 닉네임이 비어있는 경우
                    showAlertDialog(getString(R.string.nameError));
                } else {
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("user_Name", user_Name);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), storyActivity.class);
                    intent.putExtra("userName", user_Name);
                    startActivity(intent);
//                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bgm2);
//                    mediaPlayer.setLooping(true);
//                    mediaPlayer.start();
                }
            }
        });
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),languageActivity.class);
                clickPlay.start();
                startActivity(intent);
                finish();
            }
        });


    }
    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton(getString(R.string.check), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
//            mediaPlayer.start();
//        }
    }
//
//
//    @Override
//    protected void onPause() {
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.pause();
//        }
//        super.onPause();
//    }
//}