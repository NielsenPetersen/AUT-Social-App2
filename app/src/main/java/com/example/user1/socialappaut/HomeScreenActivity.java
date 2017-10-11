package com.example.user1.socialappaut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity{

    private TextView username;
    private EditText firstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final ImageView ivTravel = (ImageView) findViewById(R.id.ivTravel);
        final ImageView ivStudentBoard = (ImageView) findViewById(R.id.ivStudentBoard);
        final ImageView ivEvents = (ImageView) findViewById(R.id.ivEvents);
        final ImageView ivFoodAndBar = (ImageView) findViewById(R.id.ivFoodAndBar);

        ivTravel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent travelIntent = new Intent(HomeScreenActivity.this,TravelSectionActivity.class);
                HomeScreenActivity.this.startActivity(travelIntent);
            }
        });

        ivStudentBoard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent studentBoardIntent = new Intent(HomeScreenActivity.this,StudentBoardSectionActivity.class);
                HomeScreenActivity.this.startActivity(studentBoardIntent);
            }
        });

        ivEvents.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent eventsIntent = new Intent(HomeScreenActivity.this,EventsSectionActivity.class);
                HomeScreenActivity.this.startActivity(eventsIntent);
            }
        });

        ivFoodAndBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent foodAndBarIntent = new Intent(HomeScreenActivity.this,FoodAndBarActivity.class);
                HomeScreenActivity.this.startActivity(foodAndBarIntent);
            }
        });
    }

}

