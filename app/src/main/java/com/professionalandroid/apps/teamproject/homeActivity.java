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
        TextView info_lgHall =(TextView) findViewById(R.id.info_lgHall);
        Button in_stHallButton =(Button) findViewById(R.id.in_stHallButton);
        ImageView st_location_red = (ImageView) findViewById(R.id.st_location_red);

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
                info_lgHall.setVisibility(View.GONE);
                info_egHall.setVisibility(View.VISIBLE);

                eg_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.VISIBLE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);

            }
        });
        lakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_ctHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_lgHall.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_lake.setVisibility(View.VISIBLE);

                eg_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.VISIBLE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);

            }
        });
        ctHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_lgHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.VISIBLE);

                ct_location_red.setVisibility(View.VISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.VISIBLE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.GONE);
            }
        });
        lbHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.GONE);
                info_lgHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.VISIBLE);

                lb_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                st_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.VISIBLE);
                in_stHallButton.setVisibility(View.GONE);



            }
        });
        

        stHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_lake.setVisibility(View.GONE);
                info_egHall.setVisibility(View.GONE);
                info_lbHall.setVisibility(View.GONE);
                info_ctHall.setVisibility(View.GONE);
                info_lgHall.setVisibility(View.VISIBLE);

                st_location_red.setVisibility(View.VISIBLE);
                ct_location_red.setVisibility(View.INVISIBLE);
                lb_location_red.setVisibility(View.INVISIBLE);
                eg_location_red.setVisibility(View.INVISIBLE);
                lake_location_red.setVisibility(View.INVISIBLE);

                in_egHallButton.setVisibility(View.GONE);
                in_lakeButton.setVisibility(View.GONE);
                in_ctHallButton.setVisibility(View.GONE);
                in_lbHallButton.setVisibility(View.GONE);
                in_stHallButton.setVisibility(View.VISIBLE);

            }
        });
        in_lbHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),endingActivity.class);
                startActivity(intent);
            }
        });
        in_egHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),eg1Activity.class);
                startActivity(intent);
            }
        });
        in_stHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),eg1Activity.class);
                startActivity(intent);
            }
        });
        in_ctHallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getApplicationContext(),eg1Activity.class);
                startActivity(intent);
            }
        });
    }
}
