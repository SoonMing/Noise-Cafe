package com.a0519.willson.test_cafe2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a0519.willson.test_cafe2.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Sign_Up extends AppCompatActivity {
    MaterialEditText phoneNumber, sName, passWord;
    Button btnSignUp;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        phoneNumber = (MaterialEditText)findViewById(R.id.editPhone);
        sName = (MaterialEditText)findViewById(R.id.editName);
        passWord = (MaterialEditText)findViewById(R.id.editPass);

        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("CUSTOMER");


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog( Sign_Up.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(phoneNumber.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(Sign_Up.this, "Phone Number already exists",Toast.LENGTH_SHORT).show();

                        }else{
                            mDialog.dismiss();
                            User user = new User (sName.getText().toString(),passWord.getText().toString());
                            table_user.child(phoneNumber.getText().toString()).setValue(user);
                            Toast.makeText(Sign_Up.this, "Sign Up successfully !",Toast.LENGTH_SHORT).show();
                            finish();
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
