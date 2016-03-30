package com.victorshub.coca.cocastock.Shop;

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

import com.victorshub.coca.cocastock.Model.Shop;
import com.victorshub.coca.cocastock.R;

import java.util.ArrayList;

/**
 * Created by BENGEOS-PC on 3/27/2016.
 */
public class Shops_Page extends Fragment {
    private static RecyclerView myRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static Context myContext;
    private FloatingActionButton AddShop;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_list_page,container,false);
        myContext = getActivity();
        myRecyclerView = (RecyclerView) view.findViewById(R.id.shop_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);

        AddShop = (FloatingActionButton) view.findViewById(R.id.add_shop);
        AddShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, Add_Shop_Page.class);
                myContext.startActivity(intent);
            }
        });
        ArrayList<Shop> bb = new ArrayList<>();

        //shop 1
        Shop a = new Shop();
        a.setOwner("Shemsu");
        a.setName("Shemsu Mini Market");
        a.setLocation("Gurid Shola");
        a.setLast_sampled_on("2/2/2016");
        bb.add(a);

        //shop 2
        Shop b = new Shop();
        b.setOwner("Abraham");
        b.setName("Abrahm & friends Shop");
        b.setLocation("Megenagna");
        b.setLast_sampled_on("2/2/2016");
        bb.add(b);

        //shop 2
        Shop c = new Shop();
        c.setOwner("Biruk");
        c.setName("Ethiopia Shop");
        c.setLocation("Bole");
        c.setLast_sampled_on("2/2/2016");
        bb.add(c);

        //shop 2
        Shop d = new Shop();
        d.setOwner("Alganesh");
        d.setName("Michot Lehulachin Shop");
        d.setLocation("Shiro Meda");
        d.setLast_sampled_on("2/2/2016");
        bb.add(d);

        mAdapter = new Shops_Adapter(getActivity(),bb);
        myRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
