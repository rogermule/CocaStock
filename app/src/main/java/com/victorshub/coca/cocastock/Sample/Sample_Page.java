package com.victorshub.coca.cocastock.Sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.victorshub.coca.cocastock.Model.Report;
import com.victorshub.coca.cocastock.R;

import java.util.ArrayList;

/**
 * Created by BENGEOS-PC on 3/28/2016.
 */
public class Sample_Page extends Fragment {
    private static RecyclerView myRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static Context myContext;
    private FloatingActionButton AddSample;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report_list_page,container,false);
        myContext = getActivity();
        myRecyclerView = (RecyclerView) view.findViewById(R.id.sample_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);

        AddSample = (FloatingActionButton) view.findViewById(R.id.add_sample);
        AddSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, Add_Sample_Page.class);
                myContext.startActivity(intent);
            }
        });


        /*
        ArrayList<Sample> bb = new ArrayList<>();
        bb.add(new Sample());
        bb.add(new Sample());
        bb.add(new Sample());
        bb.add(new Sample());*/

        ArrayList<Report> bb = new ArrayList<Report>();
        Report a = new Report();
        a.setId("1");
        a.setDate("12/12/2015");
        a.setProduct_name("Coca");
        a.setRemaining_day("60");
        a.setShop_name("Shemsu Product");
        a.setExpiration_date("3/3/2016");
        a.setSample_taken_date("2/2/2016");
        a.setPicture(R.drawable.coaca_shop+"");
        bb.add(a);

        mAdapter = new Samples_Adapter(getActivity(),bb);
        myRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
