package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.spark.submitbutton.SubmitButton;

public class show_available extends AppCompatActivity {

    SubmitButton available;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_available);

        available=(SubmitButton) findViewById(R.id.avaButton);

        available.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                Intent slideactivity3 = new Intent(show_available.this, shaow_un_available.class);
                                startActivity(slideactivity3);
                                finish();
                            }
                        }, 4000);
                        //goto account page

                    }
                }
        );
    }
}
