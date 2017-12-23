package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.spark.submitbutton.SubmitButton;

import java.util.ArrayList;

public class EmailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Button email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        email=(Button) findViewById(R.id.button);

        email.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //goto account page

                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("plain/text");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "kasun@gamil.com" });
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Get an appointment");
                        intent.putExtra(Intent.EXTRA_TEXT, "Sir, Can I get an appointment on today.");
                        startActivity(Intent.createChooser(intent, ""));
                    }
                }
        );

/*
        mRecyclerView = (RecyclerView) findViewById(R.id.email_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new emailRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
*/
    }

    private ArrayList<EmailDataObject> getDataSet() {
        ArrayList results = new ArrayList<EmailDataObject>();
        results.add(0,new EmailDataObject("shamal.s@sliit.lk","2017-12-13"));
        results.add(1,new EmailDataObject("ashenas@gmail.com","2017-12-12"));
        results.add(2,new EmailDataObject("Kasun.s@sliit.lk","2017-12-11"));

        return results;
    }
}
