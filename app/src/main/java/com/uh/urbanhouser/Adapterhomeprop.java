package com.uh.urbanhouser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterhomeprop extends RecyclerView.Adapter<Adapterhomeprop.ViewHolder> {

    ArrayList<String> list;
    Context context;

    public Adapterhomeprop(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.homeprops, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(list.get(i).toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, propertymainpage.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgArticle;
        public TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgArticle  = itemView.findViewById(R.id.imgArticle);
            tvTitle     = itemView.findViewById(R.id.tvTitle);
        }
    }
}
