package com.swastikijari.flapybird;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class FacLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac_login);
    }

    public void onClick(View view) {
        EditText edi = (EditText) findViewById(R.id.editText);
        EditText edi2 = (EditText) findViewById(R.id.editText1);
        if(edi.getText().toString().contentEquals("Rahul")||edi.getText().toString().contentEquals("Mary Cherian") || edi.getText().toString().contentEquals("Lavanya")) {
            if (edi2.getText().toString().contentEquals("drait")) {

                EditText edi1 = (EditText) findViewById(R.id.editText2);
                Global.s1 = edi1.getText().toString();
                Intent in = new Intent(FacLogin.this, Wow.class);
                startActivity(in);
            } else {
                Toast t1 = Toast.makeText(getApplicationContext(), "Incorrect Password",
                        Toast.LENGTH_LONG);
                t1.show();
            }
        } else {
            Toast t2 = Toast.makeText(getApplicationContext(), "Incorrect Username",
                    Toast.LENGTH_LONG);
            t2.show();
        }
    }

    public void onClick1(View view) {
        EditText edi = (EditText) findViewById(R.id.editText);
        EditText edi2 = (EditText) findViewById(R.id.editText1);
        if(edi.getText().toString().contentEquals("Rahul")
                ||edi.getText().toString().contentEquals("MaryCherian")||
                edi.getText().toString().contentEquals("Lavanya")) {
            if (edi2.getText().toString().contentEquals("drait")) {
                Global.fac = edi.getText().toString();
                Intent intent = new Intent(FacLogin.this, Studs.class);
                startActivity(intent);
            }
        }
    }
}
