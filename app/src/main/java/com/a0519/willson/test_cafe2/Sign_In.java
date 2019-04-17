package com.a0519.willson.test_cafe2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a0519.willson.test_cafe2.Common.Common;
import com.a0519.willson.test_cafe2.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sign_In extends AppCompatActivity {
    EditText phoneNumber, passWord;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        phoneNumber = (EditText) findViewById(R.id.editPhone);
        passWord = (EditText) findViewById(R.id.editPass);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("CUSTOMER");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog  mDialog = new ProgressDialog( Sign_In.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phoneNumber.getText().toString()).exists()) {
                            mDialog.dismiss();
                            User user = dataSnapshot.child(phoneNumber.getText().toString()).getValue(User.class);
                            user.setPhone(phoneNumber.getText().toString()); //set Phone
                            if (user.getPassword().equals(passWord.getText().toString())) {
                                Intent homeIntent = new Intent(Sign_In.this,Home.class);
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();


                            } else {
                                Toast.makeText(Sign_In.this, "Sign In Failed !", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(Sign_In.this, "User does'nt exists", Toast.LENGTH_SHORT).show();
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
