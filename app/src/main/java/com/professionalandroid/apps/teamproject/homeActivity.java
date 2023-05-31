package com.professionalandroid.apps.teamproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);

        ImageButton egHallButton = (ImageButton) findViewById(R.id.egHallButton);
        TextView info_egHall =(TextView) findViewById(R.id.info_egHall);
        Button in_egHallButton =(Button) findViewById(R.id.in_egHallButton);
        ImageView eg_location_red = (ImageView) findViewById(R.id.eg_location_red);

        ImageButton ctHallButton = (ImageButton) findViewById(R.id.ctHallButton);
        TextView info_ctHall =(TextView) findViewById(R.id.info_ctHall);
        Button in_ctHallButton =(Button) findViewById(R.id.in_ctHallButton);
        ImageView ct_location_red = (ImageView) findViewById(R.id.ct_location_red);

        ImageButton lbHallButton = (ImageButton) findViewById(R.id.lbHallButton);
        TextView info_lbHall =(TextView) findViewById(R.id.info_lbHall);
        Button in_lbHallButton =(Button) findViewById(R.id.in_lbHallButton);
        ImageView lb_location_red = (ImageView) findViewById(R.id.lb_location_red);

        ImageButton stHallButton = (ImageButton) findViewById(R.id.stHallButton);
        TextView info_stHall =(TextView) findViewById(R.id.info_stHall);
        Button in_stHallButton =(Button) findViewById(R.id.in_stHallButton);
        ImageView st_location_red = (ImageView) findViewById(R.id.st_location_red);


        ImageButton foodHallButton = (ImageButton) findViewById(R.id.foodHallButton);
        TextView info_foodHall =(TextView) findViewById(R.id.info_foodHall);
        Button in_foodHallButton =(Button) findViewById(R.id.in_foodHallButton);
        ImageView foodHall_location_red = (ImageView) findViewById(R.id.foodHall_location_red);

        ImageButton lakeButton = (ImageButton) findViewById(R.id.lakeButton);
        TextView info_lake =(TextView) findViewById(R.id.info_lake);
        Button in_lakeButton =(Button) findViewById(R.id.in_lakeButton);
        ImageView lake_location_red = (ImageView) findViewById(R.id.lake_location_red);
        
        
        egHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_stHall.setVisibility(View.GONE);
                info_foodHall.setVisibility(View.GONE);
                info_egHall.setVisibility(View.VISIBLE);

                eg_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.VISIBLE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);
            }
        });
        lakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_ctHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_stHall.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_foodHall.setVisibility(View.GONE);
                info_lake.setVisibility(View.VISIBLE);

                eg_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.VISIBLE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);

            }
        });
        ctHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_stHall.setVisibility(View.GONE);
                info_foodHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.VISIBLE);

                ct_location_red.setVisibility(View.VISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.VISIBLE);
                in_lbHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
            }
        });
        lbHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.GONE);
                info_stHall.setVisibility(View.GONE);
                info_foodHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.VISIBLE);

                lb_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.VISIBLE);
                in_stHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);



            }
        });

        stHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.GONE);
                info_foodHall.setVisibility(View.GONE);
                info_stHall.setVisibility(View.VISIBLE);

                st_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.VISIBLE);

            }
        });

        foodHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.GONE);
                info_foodHall.setVisibility(View.VISIBLE);
                info_stHall.setVisibility(View.GONE);

                st_location_red.setVisibility(View.INVISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                foodHall_location_red.setVisibility(View.VISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_foodHallButton.setVisibility(View.VISIBLE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);

            }
        });
        in_lbHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),lbhall_talkActivity.class);
                startActivity(intent);
            }
        });
        in_foodHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),foodHallActivity.class);
                startActivity(intent);
            }
        });
        in_ctHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),ctHallActivity.class);
                startActivity(intent);
            }
        });
       in_egHallButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               Intent intent =new Intent(getApplicationContext(),egHallActivity.class);
               startActivity(intent);
           }
       });
        in_stHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),stHallActivity.class);
               startActivity(intent);
            }
        });

        in_lakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),lakeActivity.class);
                startActivity(intent);
            }
        });

    }
}
