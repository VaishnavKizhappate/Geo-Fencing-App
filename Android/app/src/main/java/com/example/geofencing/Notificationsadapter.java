package com.example.geofencing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Notificationsadapter extends RecyclerView.Adapter<Notificationsadapter.MyViewHolder>{

    ArrayList<Notificationsdatamodel> notificationsdatamodelArrayList;
    Context c;
    LayoutInflater inflater;

    public Notificationsadapter(Context c, ArrayList<Notificationsdatamodel> notificationsdatamodelArrayList) {
        this.notificationsdatamodelArrayList = notificationsdatamodelArrayList;
        this.c = c;
        inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.viewdrivers, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Notificationsadapter.MyViewHolder holder, int position) {

        holder.title.setText(notificationsdatamodelArrayList.get(position).getTitle());
        holder.notifications.setText(notificationsdatamodelArrayList.get(position).getNotifications());
        holder.date.setText(notificationsdatamodelArrayList.get(position).getDate());


    }

    @Override
    public int getItemCount() {
        return notificationsdatamodelArrayList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,notifications,date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            notifications = itemView.findViewById(R.id.notifications);
            date = itemView.findViewById(R.id.date);

        }
    }
}
