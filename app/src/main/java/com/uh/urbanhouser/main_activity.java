package com.uh.urbanhouser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class main_activity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedlistener);
        home_fragment fragment1=new home_fragment();
        FragmentTransaction ft1=getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.contentpage,fragment1);
        ft1.commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedlistener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.home_nav_but:
                    home_fragment fragment1=new home_fragment();
                    FragmentTransaction ft1=getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.contentpage,fragment1);
                    ft1.commit();
                    return true;
                case R.id.star_nav_but:
                    premium_fragment fragment2=new premium_fragment();
                    FragmentTransaction ft2=getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.contentpage,fragment2);
                    ft2.commit();
                    return true;
                case R.id.bookmark_nav_but:
                    love_fragment fragment3=new love_fragment();
                    FragmentTransaction ft3=getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.contentpage,fragment3);
                    ft3.commit();
                    return true;
                case R.id.profile_nav_but:
                    profile_fragment fragment4=new profile_fragment();
                    FragmentTransaction ft4=getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.contentpage,fragment4);
                    ft4.commit();
                    return true;
            }

            return false;
        }
    };
}
