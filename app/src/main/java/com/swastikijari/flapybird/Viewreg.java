package com.swastikijari.flapybird;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Viewreg extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewreg);
        b1=findViewById(R.id.cs);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Viewreg.this,Course_view.class));
            }
        });
    }
    public void view(View view)
    {
        Intent in1 = new Intent(Viewreg.this,FacLogin.class);
        startActivity(in1);
    }
    public void register(View view){
        Intent in1 = new Intent(Viewreg.this,NewUser.class);
        startActivity(in1);

    }

}


