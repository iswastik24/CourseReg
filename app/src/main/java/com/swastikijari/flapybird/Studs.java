package com.swastikijari.flapybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Studs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studs);
    }

    public void stud(View view) {
        final FirebaseDatabase fd = FirebaseDatabase.getInstance();
        Global.df = fd.getReference();
        Global.syed = "";


        Global.df.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for( DataSnapshot child1 : dataSnapshot.getChildren())
                {
                    if(Global.fac.contentEquals("Rahul")) {
                        if(child1.child("Elective chosen").getValue().toString().contentEquals("Numerical Methods")) {
                            Global.syed += child1.getKey()+ "\n";



                        }
                    }
                    else
                    if(Global.fac.contentEquals("Mary Cherian")) {
                        if(child1.child("Elective chosen").getValue().toString().contentEquals("Mobile Adhoc Networks")) {
                            Global.syed += child1.getKey()+ "\n";


                        }
                    }
                    else
                    if(Global.fac.contentEquals("Lavanya")) {
                        if(child1.child("Elective chosen").getValue().toString().contentEquals("Distributed Operating Systems")) {
                            Global.syed += child1.getKey()+ "\n";


                        }
                    }
                    TextView t1 = (TextView) findViewById(R.id.textView);
                    t1.setText(Global.syed);

                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError){
            }
        });
    }
}
