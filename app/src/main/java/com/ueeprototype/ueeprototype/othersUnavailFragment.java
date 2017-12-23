package com.ueeprototype.ueeprototype;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class othersUnavailFragment extends Fragment {

    Context superContext;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public othersUnavailFragment() {
    }

    public void setContext(Context context) {
        this.superContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_others_unavail, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.unavailable_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new UnvailableRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((UnvailableRecyclerViewAdapter) mAdapter).setOnItemClickListener(new UnvailableRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(final int position, View v) {

                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.custom_popup);
                dialog.setTitle("Contact");
                // set the custom dialog components - text, image and button
                TextView nameText = (TextView) dialog.findViewById(R.id.nameTextView);
                TextView emailText = (TextView) dialog.findViewById(R.id.EmailTextView);
                TextView Mobiletext = (TextView) dialog.findViewById(R.id.mobileNoTxtView);

                nameText.setText("Name : "+getDataSet().get(position).getName());
                emailText.setText("Email: "+getDataSet().get(position).getEmail());
                Mobiletext.setText("Tel  : "+getDataSet().get(position).getMobileNo());

                Button emailBtn= (Button) dialog.findViewById(R.id.emailFab);
                Button callBtn= (Button) dialog.findViewById(R.id.callFab);

                emailBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(false);
                        builder.setTitle("Warning...");
                        builder.setMessage("This lecturer is unavailable now.Are sure to put an email?");
                        builder.setInverseBackgroundForced(true);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                try {

                                    Intent intent = new Intent(Intent.ACTION_SEND);
                                    intent.setType("plain/text");
                                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "saman.g@sliit.lk" });
                                    intent.putExtra(Intent.EXTRA_SUBJECT, "Get an appointment");
                                    intent.putExtra(Intent.EXTRA_TEXT, "Sir,Can I get an appointment on today.");
                                    startActivity(Intent.createChooser(intent, ""));

                                }catch (Exception e){
                                    e.printStackTrace();
                                }

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
                });

                callBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(false);
                        builder.setTitle("Warning...");
                        builder.setMessage("This lecturer is unavailable now.Are sure to get a call?");
                        builder.setInverseBackgroundForced(true);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                try {

                                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                                    callIntent.setData(Uri.parse("tel:"+getDataSet().get(position).getMobileNo()));
                                    startActivity(callIntent);

                                }catch (Exception e){
                                    e.printStackTrace();
                                }

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
                });

                dialog.show();

            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        results.add(0,new DataObject("Mr.Kamal udayanga","778596445","fghfghf@sliit.lk"));
        results.add(1,new DataObject("Mr.Amashi Perera","365245115", "gfhhrt@sliit.lk"));
        results.add(2,new DataObject("Mr.Ruwan Nethmal","878968541", "htyty@sliit.lk"));

        return results;
    }
}
