package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LecturerInfoActivity extends AppCompatActivity {

    Button infor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_info);

        infor=(Button) findViewById(R.id.button3);

        infor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //goto account page
                        Intent intent = new Intent(LecturerInfoActivity.this, information.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }
}
