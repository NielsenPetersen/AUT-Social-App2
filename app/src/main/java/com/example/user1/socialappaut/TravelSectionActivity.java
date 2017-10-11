package com.example.user1.socialappaut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class TravelSectionActivity extends AppCompatActivity {

    private ImageView ivCarpool;
    private ImageView ivShuttle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_section);

        ivCarpool = (ImageView) findViewById(R.id.ivCarpool);
        ivShuttle = (ImageView) findViewById(R.id.ivShuttle);

        ivCarpool.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent carpool = new Intent(TravelSectionActivity.this, CarpoolActivity.class);
                TravelSectionActivity.this.startActivity(carpool);

            }
        });

        ivShuttle.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent shuttle = new Intent(TravelSectionActivity.this, ShuttleActivity.class);
                TravelSectionActivity.this.startActivity(shuttle);

            }
        });

    }

}
