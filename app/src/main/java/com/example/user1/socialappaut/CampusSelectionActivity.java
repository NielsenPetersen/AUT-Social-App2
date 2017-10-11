package com.example.user1.socialappaut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class CampusSelectionActivity extends AppCompatActivity {

    private ImageView btnNorthCampus;
    private ImageView btnCityCampus;
    private ImageView btnSouthCampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_selection);

        btnNorthCampus = (ImageView) findViewById(R.id.btnNorthCampus);
        btnCityCampus = (ImageView) findViewById(R.id.btnCityCampus);
        btnSouthCampus = (ImageView) findViewById(R.id.btnSouthCampus);

        btnNorthCampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent northCampusIntent = new Intent(CampusSelectionActivity.this,HomeScreenActivity.class);
                CampusSelectionActivity.this.startActivity(northCampusIntent);
            }
        });

        btnCityCampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent cityCampusIntent = new Intent(CampusSelectionActivity.this,HomeScreenActivity.class);
                CampusSelectionActivity.this.startActivity(cityCampusIntent);
            }
        });

        btnSouthCampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent southCampusIntent = new Intent(CampusSelectionActivity.this,HomeScreenActivity.class);
                CampusSelectionActivity.this.startActivity(southCampusIntent);
            }
        });
    }
}
