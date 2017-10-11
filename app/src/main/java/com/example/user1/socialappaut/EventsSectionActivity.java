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

public class EventsSectionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseDatabase database;
    DatabaseReference eventItems;
    TextView username;
    TextView tvEvent;
    TextView tvDate;
    TextView tvTime;
    TextView tvDescription;
    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    String name;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_section);

        //Initialise The Firebase Database Object to interact with the food items in the database.
        database = FirebaseDatabase.getInstance();
        eventItems = database.getReference("Event_Items");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tvEvent = (TextView) findViewById(R.id.tvEvent);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

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

        FirebaseRecyclerAdapter<Event_Items,EventMenuViewHolder> adapter = new FirebaseRecyclerAdapter<Event_Items,EventMenuViewHolder>(Event_Items.class,R.layout.event_menu_items,EventMenuViewHolder.class,eventItems) {
            @Override
            protected void populateViewHolder(EventMenuViewHolder viewHolder, Event_Items model, int position) {

                viewHolder.tvEvent.setText(model.getEvent());
                viewHolder.tvDate.setText(model.getDate());
                viewHolder.tvTime.setText(model.getTime());
                viewHolder.tvDescription.setText(model.getDescription());

                final Event_Items clickitem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(EventsSectionActivity.this,""+clickitem.getEvent(),Toast.LENGTH_SHORT).show();
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
            Intent eventsIntent = new Intent(EventsSectionActivity.this,EventsSectionActivity.class);
            EventsSectionActivity.this.startActivity(eventsIntent);

        }else if (id==R.id.nav_food){
            Intent foodAndBarIntent = new Intent(EventsSectionActivity.this,FoodAndBarActivity.class);
            EventsSectionActivity.this.startActivity(foodAndBarIntent);

        }else if(id==R.id.nav_student_board){
            Intent studentBoardIntent = new Intent(EventsSectionActivity.this,StudentBoardSectionActivity.class);
            EventsSectionActivity.this.startActivity(studentBoardIntent);

        }else if(id==R.id.nav_travel){
            Intent travelIntent = new Intent(EventsSectionActivity.this,TravelSectionActivity.class);
            EventsSectionActivity.this.startActivity(travelIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}