package com.uh.urbanhouser;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class faq_act extends AppCompatActivity {

    FirebaseAuth auther;
    FirebaseUser currentuser;
    FirebaseDatabase database_profile = FirebaseDatabase.getInstance();
    DatabaseReference ref;
    DatabaseReference profileref = database_profile.getReference("questions");
    ExpandableListView expandableListView;
    ExpandableListViewAdapter adapter;
    List<String> lisdataheader;
    HashMap<String, List<String>> listHashMap;
    Button backbutton;
    FloatingActionButton sendbutton;
    EditText question;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_act);

        sendbutton = findViewById(R.id.sendquestion);
        question = findViewById(R.id.question);

        auther = FirebaseAuth.getInstance();
        currentuser = auther.getCurrentUser();


        backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        expandableListView = findViewById(R.id.expandablelistview);
        initdat();

        adapter = new ExpandableListViewAdapter(this, lisdataheader, listHashMap);
        expandableListView.setAdapter(adapter);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postquestion = question.getText().toString();
                /*FirebaseUser currentUser = mAuth.getCurrentUser();
                String uid = currentUser.getUid();
                Toast.makeText(faq_act.this,uid,Toast.LENGTH_SHORT).show();*/

                if (TextUtils.isEmpty(postquestion)) {
                    FirebaseUser currentUser = auther.getCurrentUser();
                    String uid = currentUser.getUid();
                    Toast.makeText(faq_act.this, uid, Toast.LENGTH_SHORT).show();
                    question.setError("Enter your problem");
                    question.requestFocus();
                    return;
                } else {
                    uploadData(postquestion);

                    /*Intent intent = new Intent(faq_act.this, main_activity.class);
                    startActivity(intent);*/


                    /*HashMap<String, Object> result = new HashMap<>();
                    result.put("question", postquestion);

                    ref.child(currentuser.getUid()).updateChildren(result)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(faq_act.this, "Sent.......", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(faq_act.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });*/
                    /*FirebaseUser currentUser = mAuth.getCurrentUser();
                    String uid = currentUser.getUid();

                    HashMap<Object, String> hashMap = new HashMap<>();

                    hashMap.put("question", postquestion);
                    hashMap.put("uid", uid);


                    profileref.child(uid).setValue(hashMap);*/
                }


            }
        });

    }

    private void uploadData(final String postquestion) {
        final String timestamp = String.valueOf(System.currentTimeMillis());
        FirebaseUser currentUser = auther.getCurrentUser();
        String uid = currentUser.getUid();
        HashMap<Object, String> hashMap = new HashMap<>();

        hashMap.put("question", postquestion);
        hashMap.put("timestamp", timestamp);
        hashMap.put("userid", uid);


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("questions");
        ref.child(timestamp).setValue(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        //pd.dismiss();
                        Toast.makeText(faq_act.this, "Question submitted successfully..........", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(faq_act.this, main_activity.class);
                        startActivity(intent);


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        //pd.dismiss();
                        Toast.makeText(faq_act.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }

    private void initdat() {


        lisdataheader = new ArrayList<>();
        listHashMap = new HashMap<>();

        lisdataheader.add("Are your services genuine?");
        lisdataheader.add("Why should we trust you?");
        lisdataheader.add("What if tenant faces any issue?");
        lisdataheader.add("What if the landlord is not satisfied?");
        lisdataheader.add("What would happen if tenant creates issues regarding payment?");
        lisdataheader.add("What if the tenant does not follow the terms and conditions of the owner?");

        List<String> edmtDev = new ArrayList<>();
        edmtDev.add("We assure you that our services are 100% genuine, from our side we are trying our best to provide you ROOMMET services as best as possible,even after that if any problem arises feel free to contact us directly from contact us page.");

        List<String> androidStudio = new ArrayList<>();
        androidStudio.add("We focus on quality and not quantity,you should totally trust us as our policy is customer satisfaction rather then business.");
        /*androidStudio.add("Google Map");
        androidStudio.add("Chat Application");
        androidStudio.add("Firebase ");*/

        List<String> xamarin = new ArrayList<>();
        xamarin.add("Owner as well as the tenant is free to contact us directly.We are happy to help our customer 24*7.");
        /*xamarin.add("Xamarin Google Map");
        xamarin.add("Xamarin Chat Application");
        xamarin.add("Xamarin Firebase ");*/

        List<String> uwp = new ArrayList<>();
        uwp.add("Before using our services please make sure you read our terms & conditions properly and in case you face any dissatisfaction just make a call to us.");

        List<String> ten = new ArrayList<>();
        ten.add("The owner is free to take any actions against the tenant following our terms and conditions.ROOMMET will not be responsible for any type of disputes between owner and tenant related to rent.");

        List<String> own = new ArrayList<>();
        own.add("The first action will be a notice to the tenant and if the same is repeated then then the written notice can be sent to the tenant via ROOMMET to leave the room within specified time period.");

        listHashMap.put(lisdataheader.get(0), edmtDev);
        listHashMap.put(lisdataheader.get(1), androidStudio);
        listHashMap.put(lisdataheader.get(2), xamarin);
        listHashMap.put(lisdataheader.get(3), uwp);
        listHashMap.put(lisdataheader.get(4), ten);
        listHashMap.put(lisdataheader.get(5), own);

    }
}
