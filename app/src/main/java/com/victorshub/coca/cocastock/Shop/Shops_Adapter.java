package com.victorshub.coca.cocastock.Shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.victorshub.coca.cocastock.Model.Shop;
import com.victorshub.coca.cocastock.R;

import java.util.ArrayList;

/**
 * Created by BENGEOS-PC on 3/27/2016.
 */
public class Shops_Adapter extends RecyclerView.Adapter<Shops_Adapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Shop> shop;
    private static MyClickListener myClickListener;
    private static Context myContext;

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_owner, tv_location, tv_last_sampled;
        TextView dateTime;
        ImageView Image;

        public DataObjectHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.shop_name);
            tv_owner = (TextView) itemView.findViewById(R.id.shop_owner);
            tv_location = (TextView) itemView.findViewById(R.id.shop_location);
            tv_last_sampled = (TextView) itemView.findViewById(R.id.shop_last_sampled_on);

            Log.i(LOG_TAG, "Adding Listener");
        }
    }
    public Shops_Adapter(Context context, ArrayList<Shop> shops){
        this.shop = shops;
        this.myContext = context;
    }
    @Override
    public int getItemCount() {
        return shop.size();
    }
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item,parent,false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }
    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        String name = shop.get(position).getName().toString();
        String owner = shop.get(position).getOwner().toString();
        String location = shop.get(position).getLocation();
        String last_sample = shop.get(position).getLast_sampled_on();

        holder.tv_name.setText(name);
        holder.tv_owner.setText(owner);
        holder.tv_location.setText(location);
        holder.tv_last_sampled.setText(last_sample);

    }
    public void addItem(Shop news){
        shop.add(news);
    }
    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}
