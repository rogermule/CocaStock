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
        //product 1
        Report a = new Report();
        a.setId("1");
        a.setDate("12/12/2015");
        a.setProduct_name("Coca Bottle");
        a.setRemaining_day("60");
        a.setShop_name("Shemsu Product");
        a.setExpiration_date("3/3/2016");
        a.setSample_taken_date("2/2/2016");
        a.setPicture(R.drawable.coca_bottle+"");
        bb.add(a);

        Report b = new Report();
        //product 2
        b.setId("2");
        b.setDate("12/12/2015");
        b.setProduct_name("Coca Plastic");
        b.setRemaining_day("60");
        b.setShop_name("Shemsu Product");
        b.setExpiration_date("3/3/2016");
        b.setSample_taken_date("2/2/2016");
        b.setPicture(R.drawable.coca_plastic+"");
        bb.add(b);

        //product 3
        Report c = new Report();
        c.setId("3");
        c.setDate("12/12/2015");
        c.setProduct_name("Sprite Bottle");
        c.setRemaining_day("Remaining days: 10");
        c.setShop_name("Shemsu Product");
        c.setExpiration_date("3/3/2016");
        c.setSample_taken_date("2/2/2016");
        c.setPicture(R.drawable.sprite_bottle+"");
        bb.add(c);

        //product 4
        Report d = new Report();
        d.setId("4");
        d.setDate("12/12/2015");
        d.setProduct_name("Sprite Plastic");
        d.setRemaining_day("Remaining days: 100");
        d.setShop_name("Shemsu Product");
        d.setExpiration_date("3/3/2016");
        d.setSample_taken_date("2/2/2016");
        d.setPicture(R.drawable.sprite_plastic+"");
        bb.add(d);

        //product 5
        Report e = new Report();
        e.setId("5");
        e.setDate("12/12/2015");
        e.setProduct_name("Fanta Bottle");
        e.setRemaining_day("Remaining days: 60");
        e.setShop_name("Shemsu Product");
        e.setExpiration_date("3/3/2016");
        e.setSample_taken_date("2/2/2016");
        e.setPicture(R.drawable.fanta_bottle+"");
        bb.add(e);

        //product 6
        Report f = new Report();
        f.setId("6");
        f.setDate("12/12/2015");
        f.setProduct_name("Fanta Plastic");
        f.setRemaining_day("Remaining days: 40");
        f.setShop_name("Shemsu Product");
        f.setExpiration_date("3/3/2016");
        f.setSample_taken_date("2/2/2016");
        f.setPicture(R.drawable.fanta_plastic+"");
        bb.add(f);

        mAdapter = new Samples_Adapter(getActivity(),bb);
        myRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
