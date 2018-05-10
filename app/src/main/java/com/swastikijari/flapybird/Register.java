package com.swastikijari.flapybird;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import static android.widget.Toast.makeText;
public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void man(View view){
        DatabaseReference man1 = Global.df.child("Elective chosen");
        man1.setValue("Mobile Adhoc Networks");
        Toast t1 = makeText(getApplicationContext(),"Successfully Registered for Man",Toast.LENGTH_LONG);t1.show();

    }
    public void math(View view){
        DatabaseReference math1 = Global.df.child("Elective chosen");
        math1.setValue("Numerical Methods");
        Toast t2 = makeText(getApplicationContext(),"Successfully Registered for Numerical Methods",Toast.LENGTH_LONG);
                t2.show();
    }
    public void dos(View view){
        DatabaseReference dos1 = Global.df.child("Elective chosen");
        dos1.setValue("Distributed Operating Systems");
        Toast t3 = makeText(getApplicationContext(),"Successfully Registered for DOS",Toast.LENGTH_LONG);
                t3.show();
    }
    public void logout(View view)
    {
        Intent int23 = new Intent(Register.this,Viewreg.class);
        startActivity(int23);
    }
}
