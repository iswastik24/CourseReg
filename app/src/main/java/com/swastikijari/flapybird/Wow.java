package com.swastikijari.flapybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Map;
public class Wow extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wow);
    }
    public void onClick(View view)
    {
        FirebaseDatabase fd = FirebaseDatabase.getInstance();
        Global.df=fd.getReference().child(Global.s1).child("Elective chosen");
        Global.df.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String item = dataSnapshot.getValue(String.class);
                TextView t1 =(TextView)findViewById(R.id.textView11);
                t1.setText(item);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}


