package com.swastikijari.flapybird;


        import android.content.Intent;
        import android.os.Bundle;
        import android.provider.Settings;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
  int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void baba(View view) {
        FirebaseDatabase fd = FirebaseDatabase.getInstance();
        EditText edi = (EditText) findViewById(R.id.editText5);
        EditText edi1 = (EditText) findViewById(R.id.editText6);
        EditText edi2 = (EditText) findViewById(R.id.editText7);
        EditText edi3=(EditText)findViewById(R.id.editText8);
        String usn = edi.getText().toString().toUpperCase().trim();
        String phon = edi2.getText().toString().trim();
        String pass = edi3.getText().toString().trim();

        //usn
        Pattern p = Pattern.compile("^(1da|1DA){1}[0-9]{2}(CS|cs){1}[0-9]{3}$");//. represents single character
        Matcher m = p.matcher(usn);
        boolean b = m.matches();

        try{
            String last2 =usn.substring(7,9);
            i = Integer.parseInt(last2);
        }
        catch (NumberFormatException e){
            Toast.makeText(Login.this,"Enter a valid Data",Toast.LENGTH_SHORT).show();
            finish();
        }
        catch (StringIndexOutOfBoundsException e){
            Toast.makeText(Login.this,"Enter a valid Data",Toast.LENGTH_SHORT).show();
            finish();
        }


        //phon num
        Pattern p1 = Pattern.compile("[1-9]{1}[0-9]{9}");
        //. represents single character
        Matcher m1 = p1.matcher(phon);
        boolean b1 = m1.matches();
        //password
        Pattern p2 = Pattern.compile("[a-zA-Z0-9]{6,10}");//. represents single character
        Matcher m2 = p2.matcher(pass);
        boolean b2 = m2.matches();
        if(i>=270){
            Toast t1 = Toast.makeText(Login.this, "Usn Not limit is below 270 ", Toast.LENGTH_LONG);
            t1.setGravity(10,10,10);
            t1.show();
            finish();

        }else{
            if(usn.isEmpty()||edi1.getText().toString().isEmpty()||edi2.getText().toString().isEmpty() || edi3.getText().toString().isEmpty()) {
                Toast t1 = Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_LONG);
                t1.show();
                finish();
            } else {
                if(b==true ) {
                    //Log.d("XXXXXXXXXXXXXX", "USn  verified"+usn);

                }
                else{
                    Toast.makeText(Login.this,"Enter a valid usn ",Toast.LENGTH_SHORT).show();
                    finish();
                }


                if(b1==true) {
                 //   Log.d("XXXXXXXXXXXXXX", "phon  verified"+phon);

                }
                else
                {
                    Toast.makeText(Login.this,"Enter a valid Phone number ",Toast.LENGTH_SHORT).show();
                    finish();

                }
                if(b2==true) {

                    //Log.d("XXXXXXXXXXXXXX", "pass  verified"+pass);
                }
                else {
                    Toast.makeText(Login.this,"Enter a valid Password ",Toast.LENGTH_SHORT).show();
                    finish();

                }




                if( b==true && b1==true &&  b2==true){
                    Global.df = fd.getReference().child(usn);
                    Global.df.child("Branch").setValue(edi1.getText().toString());
                    Global.df.child("Phone").setValue(phon);
                    Global.df.child("Password").setValue(pass);
                    startActivity(new Intent(Login.this,Viewreg.class));
                    Toast.makeText(getApplicationContext(), "Successfully Registered",
                            Toast.LENGTH_LONG).show();

                }


            }
        }





                }


            }


