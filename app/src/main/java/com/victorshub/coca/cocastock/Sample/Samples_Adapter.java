package com.victorshub.coca.cocastock.Sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.victorshub.coca.cocastock.Model.Report;
import com.victorshub.coca.cocastock.R;

import java.util.ArrayList;

/**
 * Created by BENGEOS-PC on 3/28/2016.
 */
public class Samples_Adapter extends RecyclerView.Adapter<Samples_Adapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Report> report;
    private static MyClickListener myClickListener;
    private static Context myContext;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView Title,Content, shop,production_date, expiration_date,sampled_on,remaining_day;
        TextView dateTime;
        ImageView Image;

        public DataObjectHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.report_title_name);
            shop = (TextView) itemView.findViewById(R.id.report_shop_name1);
            production_date = (TextView) itemView.findViewById(R.id.report_production_date);
            expiration_date = (TextView) itemView.findViewById(R.id.report_expirtaion_date);
            sampled_on = (TextView) itemView.findViewById(R.id.report_sampled_on);
            remaining_day = (TextView) itemView.findViewById(R.id.report_remaining_day1);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // myClickListener.onItemClick(getAdapterPosition(), v);
            Intent intent = new Intent(myContext,Add_Sample_Page.class);
         //   myContext.startActivity(intent);
            Toast.makeText(myContext, "Position: " + getPosition(), Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
    public static void setOnItemClickListener(MyClickListener myClickListener) {
        myClickListener = myClickListener;
    }
    public Samples_Adapter(Context context, ArrayList<Report> samples){
        this.report = samples;
        this.myContext = context;
    }
    @Override
    public int getItemCount() {
        return report.size();
    }
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_list_item,parent,false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }
    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        String expiration_date = report.get(position).getExpiration_date().toString();
        String production_date = report.get(position).getDate();
        String shop_name = report.get(position).getShop_name();
        String remaining_day = report.get(position).getRemaining_day();
        String sampled_on = report.get(position).getSample_taken_date();

        holder.expiration_date.setText(expiration_date);
        holder.production_date.setText(production_date);
        holder.shop.setText(shop_name);
        holder.remaining_day.setText(remaining_day);
        holder.sampled_on.setText(sampled_on);


    }
    public void addItem(Report news){
        report.add(news);
    }
    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
