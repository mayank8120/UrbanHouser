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
public class love_fragment extends Fragment {

    RecyclerView rvFavorite;
    AdapterFavoriteprop mAdapter;
    String articleFavorite[]={"1 BHK","1 BHK","1 BHK","1 BHK","1 BHK"};

    public love_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {View v = inflater.inflate(R.layout.fragment_love_fragment, container, false);
        rvFavorite = v.findViewById(R.id.rvFavorite);
        rvFavorite.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFavorite.setLayoutManager(layoutManager);

        ArrayList<String> favArticle = new ArrayList<>();
        favArticle.add(articleFavorite[0]);
        favArticle.add(articleFavorite[1]);
        favArticle.add(articleFavorite[2]);
        favArticle.add(articleFavorite[3]);
        favArticle.add(articleFavorite[4]);

        mAdapter = new AdapterFavoriteprop(favArticle,getActivity());
        rvFavorite.setAdapter(mAdapter);

        rvFavorite.getAdapter().notifyDataSetChanged();
        rvFavorite.scheduleLayoutAnimation();

        return v;
    }

}
