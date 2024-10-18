package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile_Activity extends AppCompatActivity {

    private ImageButton homeIcon, editProfileButton;
    private RelativeLayout historyButton, statisticsButton, logoutButton;
    private TextView userName, userEmail, userDOB, userGender;

    private DatabaseReference databaseReference;
    private String userUID = "ImpVhSURePUTj0zVPepZF58ittt2";  // static UID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseApp.initializeApp(this);

        homeIcon = findViewById(R.id.homeIcon);
        editProfileButton = findViewById(R.id.editProfileButton);
        historyButton = findViewById(R.id.historyButton);
        statisticsButton = findViewById(R.id.statisticsButton);
        logoutButton = findViewById(R.id.logoutButton);

        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userDOB = findViewById(R.id.userDOB);
        userGender = findViewById(R.id.userGender);

        databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userUID);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    String username = snapshot.child("username").getValue(String.class);
                    String email = snapshot.child("email").getValue(String.class);
                    String dob = snapshot.child("dob").getValue(String.class);
                    String gender = snapshot.child("gender").getValue(String.class);

                    userName.setText(username != null ? username : "N/A");
                    userEmail.setText(email != null ? email : "N/A");
                    userDOB.setText(dob != null ? dob : "N/A");
                    userGender.setText(gender != null ? gender : "N/A");
                } else {
                    Toast.makeText(Profile_Activity.this, "User data not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile_Activity.this, "Failed to load user data.", Toast.LENGTH_SHORT).show();
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile_Activity.this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile_Activity.this, "History Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile_Activity.this, "Statistics Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile_Activity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
