package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentEmail extends AppCompatActivity {

    Button email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_email);

        email=(Button) findViewById(R.id.email_button);

        email.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //goto account page

                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("plain/text");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "saman.g@sliit.lk" });
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Appointment");
                        intent.putExtra(Intent.EXTRA_TEXT, "you can on today at 4.00pm");
                        startActivity(Intent.createChooser(intent, ""));
                    }
                }
        );
    }
}
