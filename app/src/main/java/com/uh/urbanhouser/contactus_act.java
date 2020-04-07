package com.uh.urbanhouser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class contactus_act extends AppCompatActivity {


    ImageView img;
    Button back;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_act);


        final TextView txtvw = (TextView) findViewById(R.id.call_call);
        final EditText your_name = (EditText) findViewById(R.id.your_name);
        final EditText your_email = (EditText) findViewById(R.id.your_email);
        final EditText your_subject = (EditText) findViewById(R.id.your_subject);
        final EditText your_message = (EditText) findViewById(R.id.your_message);

        img = findViewById(R.id.imageView);
        Picasso.get().load(R.drawable.get).fit().into(img);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        FloatingActionButton email = findViewById(R.id.post_message);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = your_name.getText().toString();
                String email = your_email.getText().toString();
                String subject = your_subject.getText().toString();
                String message = your_message.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    your_name.setError("Enter Your Name");
                    your_name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    your_email.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(subject)) {
                    your_subject.setError("Enter Your Subject");
                    your_subject.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)) {
                    your_message.setError("Enter Your Message");
                    your_message.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"mayanklaxkar11@gmail.com"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:" + name + '\n' + "Email ID:" + email + '\n' + "Message:" + '\n' + message);

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));


            }
        });

        txtvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:6264204218"));
                startActivity(callIntent);
            }
        });


    }

    private boolean isValidEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}

