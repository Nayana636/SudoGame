package com.example.homepage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile_Activity extends AppCompatActivity {

    private ImageButton homeIcon, editProfileButton;
    private RelativeLayout historyButton, statisticsButton, logoutButton;
    private TextView profileTitle, userName, userEmail, userDOB, userGender;
    private ImageView historyArrow, statisticsArrow, logoutArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        homeIcon = findViewById(R.id.homeIcon);
        editProfileButton = findViewById(R.id.editProfileButton);
        historyButton = findViewById(R.id.historyButton);
        statisticsButton = findViewById(R.id.statisticsButton);
        logoutButton = findViewById(R.id.logoutButton);

        profileTitle = findViewById(R.id.profileTitle);
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userDOB = findViewById(R.id.userDOB);
        userGender = findViewById(R.id.userGender);

        historyArrow = findViewById(R.id.historyArrow);
        statisticsArrow = findViewById(R.id.statisticsArrow);
        logoutArrow = findViewById(R.id.logoutArrow);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Profile_Activity.this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Profile_Activity.this, MainActivity.class);
                 startActivity(intent);
            }
        });

        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile_Activity.this, "", Toast.LENGTH_SHORT).show();

            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Profile_Activity.this, "History Clicked", Toast.LENGTH_SHORT).show();

                // Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                // startActivity(intent);
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Profile_Activity.this, "Statistics Clicked", Toast.LENGTH_SHORT).show();

                // Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                // startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Profile_Activity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();

                // Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // startActivity(intent);
                // finish(); // Close the current activity
            }
        });
    }
}
