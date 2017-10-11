package com.example.user1.socialappaut;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseDatabase database;
    DatabaseReference foodItems;
    TextView username;
    TextView rateLabel;
    TextView itemLabel;
    TextView priceLabel;
    TextView price;
    TextView itemDescription;
    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    String name;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        //Initialise The Firebase Database Object to interact with the food items in the database.
        database = FirebaseDatabase.getInstance();
        foodItems = database.getReference("Food_Items");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rateLabel = (TextView) findViewById(R.id.tvRate);
        itemLabel = (TextView) findViewById(R.id.tvItem);
        priceLabel = (TextView) findViewById(R.id.tvPrice);
        price = (TextView) findViewById(R.id.tvGetPrice);
        itemDescription = (TextView)findViewById(R.id.tvGetItemDescription);

        //Set the username to be displayed in the menu tab
        View header = navigationView.getHeaderView(0);
        username = (TextView) header.findViewById(R.id.tvFullname);
        name = CurrentUser.currentUser.getFirstname()+" "+CurrentUser.currentUser.getLastname();
        username.setText(name);

        recycler_menu = (RecyclerView) findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);

        createMenu();

    }

    private void createMenu() {

        FirebaseRecyclerAdapter<Drink_Items,MenuViewHolder> adapter = new FirebaseRecyclerAdapter<Drink_Items, MenuViewHolder>(Drink_Items.class,R.layout.food_menu_items,MenuViewHolder.class,foodItems) {
            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, Drink_Items model, int position) {

                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imgItem);
                viewHolder.tvItemName.setText(model.getName());
                viewHolder.tvPrice.setText(model.getPrice());

                final Drink_Items clickitem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodMenuActivity.this,""+clickitem.getName(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        recycler_menu.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drink_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id==R.id.nav_events){
            Intent eventsIntent = new Intent(FoodMenuActivity.this,EventsSectionActivity.class);
            FoodMenuActivity.this.startActivity(eventsIntent);

        }else if (id==R.id.nav_food){
            Intent foodAndBarIntent = new Intent(FoodMenuActivity.this,FoodAndBarActivity.class);
            FoodMenuActivity.this.startActivity(foodAndBarIntent);

        }else if(id==R.id.nav_student_board){
            Intent studentBoardIntent = new Intent(FoodMenuActivity.this,StudentBoardSectionActivity.class);
            FoodMenuActivity.this.startActivity(studentBoardIntent);

        }else if(id==R.id.nav_travel){
            Intent travelIntent = new Intent(FoodMenuActivity.this,TravelSectionActivity.class);
            FoodMenuActivity.this.startActivity(travelIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
