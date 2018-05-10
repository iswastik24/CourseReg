package com.swastikijari.flapybird;


        import android.content.Intent;
        import android.os.Bundle;
        import android.provider.Settings;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
public class NewUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }
    public void reg(View view){
        Intent ini2 = new Intent(NewUser.this,Login.class);
        startActivity(ini2);
    }
    public void onClick(View view) {
        final FirebaseDatabase fd = FirebaseDatabase.getInstance();
        DatabaseReference dd = fd.getReference();
        final EditText edi1 = (EditText) findViewById(R.id.editText);
        final EditText edi12 = (EditText) findViewById(R.id.editText1);
        if (edi1.getText().toString().isEmpty() || edi12.getText().toString().isEmpty()) {
            Toast t1 = Toast.makeText(getApplicationContext(), "Please enter valid USN and Password", Toast.LENGTH_LONG); t1.show();

        }
        dd.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(edi1.getText().toString()))
                {
                    if(dataSnapshot.child(edi1.getText().toString()).child("Password").getValue().toString().contentEquals(edi12.getText().toString())) {
                        Global.df = fd.getReference(edi1.getText().toString());
                        Intent ini3 = new Intent(NewUser.this, Register.class);
                        startActivity(ini3);
                    }
                    else
                    {
                        Toast t5=Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_LONG); t5.show();
                    }
                }
                else
                {
                    Toast t4 = Toast.makeText(getApplicationContext(),"Please Register",Toast.LENGTH_LONG); t4.show();
                }
            }
             @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        }); {
        }
    }
}

