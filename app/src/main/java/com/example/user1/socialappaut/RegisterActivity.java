package com.example.user1.socialappaut;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etFirstname;
    private EditText etLastname;
    private EditText etPassword;
    private EditText etStudentID;
    private EditText etAutEmail;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstname = (EditText) findViewById(R.id.etFirstname);
        etLastname = (EditText) findViewById(R.id.etLastname);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etStudentID = (EditText) findViewById(R.id.etStudentID);
        etAutEmail = (EditText) findViewById(R.id.etAutEmail);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

    }

    public void onClick(View view) {

        if (view == btnRegister) {

            final String firstname = etFirstname.getText().toString().trim();
            final String lastname = etLastname.getText().toString().trim();
            final String autEmail = etAutEmail.getText().toString().trim();
            final String studentID = etStudentID.getText().toString().trim();
            final String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(autEmail) ||
                    TextUtils.isEmpty(studentID) || TextUtils.isEmpty(password)) {

                AlertDialog.Builder build = new AlertDialog.Builder(RegisterActivity.this);
                build.setTitle("Register Incomplete")
                        .setMessage("Please Enter Required Information")
                        .setPositiveButton("Dismiss",null)
                        .create()
                        .show();
                return;
            }else {

                final ProgressDialog nDialog = new ProgressDialog(RegisterActivity.this);
                nDialog.setMessage("Please wait...");
                nDialog.show();
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference tableUser = database.getReference("User");

                tableUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(etStudentID.getText().toString()).exists()) {

                            nDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, "Email already registered", Toast.LENGTH_SHORT).show();

                            return;
                        }else{

                            nDialog.dismiss();
                            Users user = new Users(firstname,lastname,autEmail,password);
                            tableUser.child(studentID).setValue(user);
                            Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }
    }
}