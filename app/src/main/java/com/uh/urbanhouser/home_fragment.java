package com.uh.urbanhouser;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class home_fragment extends Fragment {

    TextView filteropens;
    Toolbar toolbar;
    ActionBar actionBar;
    ImageView img;

    private RecyclerView rvMyArticle;
    private Adapterhomeprop mAdapter;
    String articles[]={"1 BHK Villa","1 BHK Villa","1 BHK Villa","1 BHK Villa","1 BHK Villa"};

    public home_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home_fragment, container, false);


        /*actionBar.setTitle("roommet");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);*/

        img=v.findViewById(R.id.mainimg);
        rvMyArticle = v.findViewById(R.id.rvMynewArticle);
        rvMyArticle.setHasFixedSize(true);

        Picasso.get().load(R.drawable.homedesign).fit().centerCrop().into(img);


        filteropens=v.findViewById(R.id.editText);
        filteropens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), filterclick_act.class);
                startActivity(intent);
            }
        });

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rvMyArticle.setLayoutManager(layoutManager);

        ArrayList<String> dataArticles = new ArrayList<>();
        dataArticles.add(articles[0]);
        dataArticles.add(articles[1]);
        dataArticles.add(articles[2]);
        dataArticles.add(articles[3]);
        dataArticles.add(articles[4]);

        /*mAdapter = new AdapterArticles(dataArticles, getActivity());
        rvMyArticle.setAdapter(mAdapter);*/
        mAdapter    = new Adapterhomeprop(dataArticles,getActivity());
        //myadapterss =new AdapterMyArticlesss(dataArticles,getActivity());
        rvMyArticle.setAdapter(mAdapter);

        //rvMyArticle.setPadding(130,100,130,100);

        /*final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvMyArticle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder = rvMyArticle.findViewHolderForAdapterPosition(0);
                RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);
                rl1.animate().scaleY(1).scaleX(1).setDuration(350).setInterpolator(new AccelerateInterpolator()).start();
            }
        },100);*/

        /*rvMyArticle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View v = snapHelper.findSnapView(layoutManager);
                int pos = layoutManager.getPosition(v);

                RecyclerView.ViewHolder viewHolder = rvMyArticle.findViewHolderForAdapterPosition(pos);
                RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    rl1.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
                }else{
                    rl1.animate().setDuration(350).scaleX(0.75f).scaleY(0.75f).setInterpolator(new AccelerateInterpolator()).start();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/

        return v;
    }

}
