package com.example.user1.socialappaut;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity{

    private EditText etStudentID;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etStudentID = (EditText) findViewById(R.id.etStudentID);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference user_table = database.getReference("User");

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String studentID = etStudentID.getText().toString().trim();
                final String password = etPassword.getText().toString().trim();

                //This checks to see if both student ID and password field is empty and notifies the user.
                if (TextUtils.isEmpty(studentID) && TextUtils.isEmpty(password)) {

                    AlertDialog.Builder build = new AlertDialog.Builder(LoginActivity.this);
                    build.setTitle("Invalid Details")
                            .setMessage("Blank Information")
                            .setPositiveButton("Dismiss",null)
                            .create()
                            .show();
                    return;
                }

                //This gives the progress dialog loading feature to show its processing/loading.
                final ProgressDialog noteDialog = new ProgressDialog(LoginActivity.this);
                noteDialog.setMessage("Checking login details...");
                noteDialog.show();

                user_table.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //This checks the database to see if there is a matching student ID stored, If so
                        if (dataSnapshot.child(etStudentID.getText().toString()).exists()) {

                            noteDialog.dismiss();

                            //This gets the users information if password is correct
                            Users user = dataSnapshot.child(etStudentID.getText().toString()).getValue(Users.class);

                            if (user.getPassword().equals(etPassword.getText().toString())) {

                                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT)
                                        .show();

                                Intent campusSelectionIntent = new Intent(LoginActivity.this, CampusSelectionActivity.class);
                                CurrentUser.currentUser = user;
                                startActivity(campusSelectionIntent);
                                finish();
                            } else {

                                Toast.makeText(LoginActivity.this, "Invalid Password", Toast.LENGTH_SHORT)
                                        .show();
                            }

                        } else{

                            Toast.makeText(LoginActivity.this, "Invalid Student ID", Toast.LENGTH_SHORT)
                                    .show();

                            noteDialog.dismiss();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
