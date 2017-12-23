package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.spark.submitbutton.SubmitButton;

public class shaow_un_available extends AppCompatActivity {

    SubmitButton unavailable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaow_un_available);

        unavailable=(SubmitButton) findViewById(R.id.unButton);

        unavailable.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //goto account page

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                Intent slideactivity3 = new Intent(shaow_un_available.this, show_available.class);
                                startActivity(slideactivity3);
                                finish();
                            }
                        }, 4000);

                    }
                }
        );
    }
}
