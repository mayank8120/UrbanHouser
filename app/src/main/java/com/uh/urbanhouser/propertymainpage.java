package com.uh.urbanhouser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

public class propertymainpage extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    ImageButton imgbutt;
    Button visitbutt,bookbutt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propertymainpage);

        imgbutt=findViewById(R.id.backbutton);
        visitbutt=findViewById(R.id.visitbutton);
        bookbutt=findViewById(R.id.bookbutton);

        final TextView prpname = findViewById(R.id.propertyname);
        final TextView prpprice = findViewById(R.id.propprice);
        final TextView prplocality = findViewById(R.id.proplocality);
        final TextView cityname = findViewById(R.id.propcity);
        final TextView avaidate = findViewById(R.id.avaidate);
        final TextView propbhk= findViewById(R.id.propbhk);
        final ImageView propertyimageee = findViewById(R.id.propertypictureextend);
        //final TextView owcontact = findViewById(R.id.ownercontact);

        FirebaseAuth auther;
        FirebaseUser currentuser;
        FirebaseDatabase profiledata;
        DatabaseReference ref;
        StorageReference storageRef;

        auther = FirebaseAuth.getInstance();
        currentuser = auther.getCurrentUser();
        profiledata = FirebaseDatabase.getInstance();
        ref = profiledata.getReference("Posts");
        storageRef = getInstance().getReference();

        Query query = ref.orderByChild("pid").equalTo(getIntent().getStringExtra("postid"));
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String pname = "" + ds.child("pid").getValue();
                    String price = "" + ds.child("price").getValue();
                    String proploc = "" + ds.child("locality").getValue();
                    String city = "" + ds.child("city").getValue();
                    String date = "" + ds.child("date").getValue();
                    String pimg = "" + ds.child("pimage").getValue();
                    String bhkcon = "" + ds.child("bhkconfig").getValue();

                    try {
                        Picasso.get().load(pimg).fit().centerCrop().into(propertyimageee);
                    } catch (Exception e) {
                        Picasso.get().load(R.drawable.article1).fit().centerCrop().into(propertyimageee);
                    }
                    prpname.setText(pname);
                    prpprice.setText(price);
                    prplocality.setText(proploc);
                    cityname.setText(city);
                    avaidate.setText(date);
                    propbhk.setText(bhkcon);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        imgbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        visitbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(propertymainpage.this, visit_act.class);
                startActivity(intent);
            }
        });

        bookbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(propertymainpage.this, booking_act.class);
                startActivity(intent);

            }
        });

    }
}
