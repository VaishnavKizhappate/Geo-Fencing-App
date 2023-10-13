package com.example.geofencing;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rescueadapter  extends RecyclerView.Adapter<Rescueadapter.MyViewHolder>{

    ArrayList<Rescuedatamodel> rescuedatamodelArrayList;
    Context c;
    LayoutInflater inflater;

    public Rescueadapter(Context c, ArrayList<Rescuedatamodel> rescuedatamodelArrayList) {
        this.rescuedatamodelArrayList = rescuedatamodelArrayList;
        this.c = c;
        inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public Rescueadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.viewrescueteam, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Rescueadapter.MyViewHolder holder, int position) {

        holder.district.setText("District: "+rescuedatamodelArrayList.get(position).getDistrict());
        holder.area.setText("Area: "+rescuedatamodelArrayList.get(position).getArea());
        holder.name.setText(rescuedatamodelArrayList.get(position).getName());
        holder.contact.setText("Phone: "+rescuedatamodelArrayList.get(position).getContact());

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+rescuedatamodelArrayList.get(position).getContact());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                c.startActivity(callIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rescuedatamodelArrayList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView district,area,name,contact;
        Button btnCall;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            district= itemView.findViewById(R.id.district);
            area = itemView.findViewById(R.id.area);
            name = itemView.findViewById(R.id.name);
            contact = itemView.findViewById(R.id.contact);
            btnCall = itemView.findViewById(R.id.btnCall);

        }
    }
}


