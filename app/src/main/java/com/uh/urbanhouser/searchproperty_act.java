package com.uh.urbanhouser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class searchproperty_act extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    RecyclerView recyclerView;
    List<ModelSearchpost> postList;
    AdapterSearchPosts adapterPosts;

    RecyclerView postsrecyclerview;
    boolean[] isOpen = {false};
    TextView noprop;
    Button filterbutt, sortbutt, backbutt;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchproperty_act);

        filterbutt = findViewById(R.id.filterbutton);
        sortbutt = findViewById(R.id.sortbutton);
        backbutt = findViewById(R.id.backbutton);

        backbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        filterbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchproperty_act.this, filterclick_act.class);
                startActivity(intent);
            }
        });

        sortbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] options = {"Price:Low to High", "Price:High to Low", "Relevance", "Popularity"};

                AlertDialog.Builder builder = new AlertDialog.Builder(searchproperty_act.this);
                builder.setTitle("Sort by:");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInter, int which) {

                        if (which == 0) {

                            //pd.setMessage("updating user pic");
                            //profilePhoto = "image";
                            lowtohigh();

                        } else if (which == 1) {

                            //pd.setMessage("updating user name");
                            hightolow();

                        } else if (which == 2) {

                            //pd.setMessage("updating user email");
                            relevance();

                        } else if (which == 3) {

                            //pd.setMessage("updating user phone number");
                            popuplarity();

                        }

                    }
                });
                builder.create().show();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        noprop = findViewById(R.id.noproperty);

        recyclerView = findViewById(R.id.searchrecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        recyclerView.setLayoutManager(layoutManager);

        postList = new ArrayList<>();

        loadPosts();

    }

    private void popuplarity() {

    }

    private void relevance() {

    }

    private void hightolow() {

    }

    private void lowtohigh() {

    }

    private void loadPosts() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Posts");

        Query query = ref;

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    ModelSearchpost modelpost = ds.getValue(ModelSearchpost.class);

                    //String date=intent.getStringExtra("daterequired");
                    //Toast.makeText(searchproperty_act.this, modelpost.getFurnishstatus()+":", Toast.LENGTH_SHORT).show();
                    /*int da = 0;
                    if(date=="Immediate"){
                        da=1;
                        Toast.makeText(searchproperty_act.this, "hello", Toast.LENGTH_SHORT).show();
                    }
                    else if(date=="Within 15 days"){
                        da=15;
                    }
                    else if(date=="within 30 days"){
                        da=30;
                    }
                    else if(date=="after 30 days"){
                        da=30;
                    }*/

                    /*int date_int=Integer.parseInt(date);
                    String getdays=modelpost.getDay();
                    String getmonths=modelpost.getMonth();
                    String getyears=modelpost.getYear();
                    int mainday=Integer.parseInt(getdays);
                    int mainmonth=Integer.parseInt(getmonths);
                    int mainyear=Integer.parseInt(getyears);
                    Calendar c = (Calendar) Calendar.getInstance();
                    c.add (Calendar.DAY_OF_MONTH, date_int);
                    Calendar vacant = (Calendar) Calendar.getInstance();
                    vacant.set(Calendar.YEAR,mainyear);
                    vacant.set(Calendar.MONTH,mainmonth);
                    vacant.set(Calendar.DAY_OF_MONTH,mainday);*/

                    Intent intent = getIntent();
                    String cityname = intent.getStringExtra("city");
                    String localityname = intent.getStringExtra("locality");
                    String bhkcon = intent.getStringExtra("bhkconf");
                    String furnish = intent.getStringExtra("furnishstatus");

                    String maxpric = intent.getStringExtra("maxprice");
                    String mainpric = modelpost.getPrice();
                    int mainprice = Integer.parseInt(mainpric);
                    int maxprice = Integer.parseInt(maxpric);

                    if (
                            (modelpost.getCity().toLowerCase().trim().contains(cityname.toLowerCase().trim()))
                                    && (modelpost.getLocality().toLowerCase().trim().contains(localityname.toLowerCase().trim()))
                                    && (modelpost.getBhkconfig().toLowerCase().trim().contains(bhkcon.toLowerCase().trim()))
                                    && (modelpost.getFurnishstatus().toLowerCase().trim().contains(furnish.toLowerCase().trim()))
                                    && (mainprice <= maxprice)
                    ) {
                        postList.add(modelpost);
                        noprop.setVisibility(View.INVISIBLE);
                    }

                    adapterPosts = new AdapterSearchPosts(searchproperty_act.this, postList);
                    recyclerView.setAdapter(adapterPosts);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(searchproperty_act.this, "" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
