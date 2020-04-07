package com.uh.urbanhouser;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class profile_fragment extends Fragment {

    Button faqview,contactusview,logoutview,aboutview,privacyview,nextbutton;
    LinearLayout profileviewtxt;

    public profile_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        faqview=view.findViewById(R.id.faqs);
        contactusview=view.findViewById(R.id.contactus);
        //profileviewtxt=view.findViewById(R.id.profileopentext);
        //nextbutton=view.findViewById(R.id.nxtbutton);
        aboutview=view.findViewById(R.id.aboutus);
        privacyview=view.findViewById(R.id.privacypolicy);
        profileviewtxt=view.findViewById(R.id.profileopentext);
        logoutview=view.findViewById(R.id.logoutbutton);

        faqview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), faq_act.class);
                startActivity(intent);
            }
        });
        profileviewtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), profile_act.class);
                startActivity(intent);
            }
        });
        contactusview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), contactus_act.class);
                startActivity(intent);
            }
        });

        logoutview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setMessage("Are you sure you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(getActivity(), login_act.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                getActivity().finish();

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


            }
        });

        return view;
    }


}