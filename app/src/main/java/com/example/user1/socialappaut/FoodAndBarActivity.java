package com.example.user1.socialappaut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FoodAndBarActivity extends AppCompatActivity {

    private ImageView ivFood;
    private ImageView ivDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_and_bar);

        ivFood = (ImageView) findViewById(R.id.ivFood);
        ivDrinks = (ImageView) findViewById(R.id.ivDrinks);

        ivFood.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent foodMenu = new Intent(FoodAndBarActivity.this, FoodMenuActivity.class);
                FoodAndBarActivity.this.startActivity(foodMenu);

            }
        });

        ivDrinks.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent drinkMenu = new Intent(FoodAndBarActivity.this, DrinkItemMenuActivity.class);
                FoodAndBarActivity.this.startActivity(drinkMenu);

            }
        });

    }


}

