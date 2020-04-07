package com.uh.urbanhouser;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class premium_fragment extends Fragment {


    public premium_fragment() {
        // Required empty public constructor
    }

    private RecyclerView rvMyArticle;
    private Adapterhomeprop mAdapter;
    String articles[]={"1 BHK","1 BHK","1 BHK"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_premium_fragment, container, false);
        rvMyArticle = v.findViewById(R.id.rvMyArticle);
        rvMyArticle.setHasFixedSize(true);
        rvMyArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*secrecycler=v.findViewById(R.id.secrecycler);
        secrecycler.setHasFixedSize(true);*/


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rvMyArticle.setLayoutManager(layoutManager);


        /*RecyclerView.LayoutManager layoutManagerr = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        secrecycler.setLayoutManager(layoutManagerr);*/

        ArrayList<String> dataArticles = new ArrayList<>();
        dataArticles.add(articles[0]);
        dataArticles.add(articles[1]);
        dataArticles.add(articles[2]);

        mAdapter    = new Adapterhomeprop(dataArticles,getActivity());
        //myadapterss =new AdapterMyArticlesss(dataArticles,getActivity());
        rvMyArticle.setAdapter(mAdapter);
        //secrecycler.setAdapter(myadapterss);

        return v;
    }
}
