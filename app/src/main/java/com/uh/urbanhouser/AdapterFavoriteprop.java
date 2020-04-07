package com.uh.urbanhouser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFavoriteprop extends RecyclerView.Adapter<AdapterFavoriteprop.ViewHolder> {

    ArrayList<String> list;
    Context context;

    public AdapterFavoriteprop(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.favouriteprops, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context,R.anim.layoutanim);
        viewHolder.tvTitle.setText(list.get(i).toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, propertymainpage.class);
                context.startActivity(intent);
            }
        });
        // viewHolder.rl1.setLayoutAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgArticle;
        public TextView tvTitle,tvDesc;
        public RelativeLayout rl1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgArticle  = itemView.findViewById(R.id.imgArticle);
            tvTitle     = itemView.findViewById(R.id.tvTitle);
            tvDesc      = itemView.findViewById(R.id.tvDesc);
            rl1         = itemView.findViewById(R.id.rl1);
        }
    }
}
