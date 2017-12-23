package com.ueeprototype.ueeprototype;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private static String emailText,pwText;
    EditText text,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text = (EditText) findViewById(R.id.emailEditText);
        pw = (EditText) findViewById(R.id.passwordEditText);
        Button signIn = (Button) findViewById(R.id.signinBtn);

        checkAndRequestPermissions();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailText = text.getText().toString().trim();
                pwText = pw.getText().toString().trim();
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(
                        getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();

                if(emailText.equalsIgnoreCase("it15135687@sliit.lk") && pwText.equalsIgnoreCase("123")){
                    Intent slideactivity2 = new Intent(v.getContext(), MainActivity.class);
                    startActivity(slideactivity2, bndlanimation);
                    finish();
                }
                else if(emailText.equalsIgnoreCase("saman.g@sliit.lk") && pwText.equalsIgnoreCase("123")){
                    Intent slideactivity1 = new Intent(v.getContext(), LecturerHomeActivity.class);
                    startActivity(slideactivity1, bndlanimation);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private  boolean checkAndRequestPermissions() {

        int CALL_PHONE = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (CALL_PHONE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CALL_PHONE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }

        return true;

    }

}
