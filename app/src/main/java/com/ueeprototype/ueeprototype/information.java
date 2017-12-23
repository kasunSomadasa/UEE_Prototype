package com.ueeprototype.ueeprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.spark.submitbutton.SubmitButton;

public class information extends AppCompatActivity {

    Button delete;
    SubmitButton submitB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        delete=(Button) findViewById(R.id.button5);
        delete=(Button) findViewById(R.id.button6);

        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //goto account page
                        showDialog();
                    }
                }
        );


        submitB=(SubmitButton) findViewById(R.id.submitButton);

        submitB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                Intent slideactivity3 = new Intent(information.this,LecturerInfoActivity.class);
                                startActivity(slideactivity3);
                                finish();
                            }
                        }, 4000);
                        //goto account page

                    }
                }
        );
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Delete...");
        builder.setMessage("Are you sure to delete ?");
        builder.setInverseBackgroundForced(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(information.this, "Deleted... ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
