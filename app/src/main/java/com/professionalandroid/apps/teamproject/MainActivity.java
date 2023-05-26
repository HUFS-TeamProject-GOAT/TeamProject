package com.professionalandroid.apps.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText userName =(EditText) findViewById(R.id.userName);
        Button startButton = (Button) findViewById(R.id.startButton);
        ImageButton languageButton = (ImageButton) findViewById(R.id.homeImage);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name =userName.getText().toString();
                Intent intent =new Intent(getApplicationContext(),storyActivity.class);
                intent.putExtra("userName",name);
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