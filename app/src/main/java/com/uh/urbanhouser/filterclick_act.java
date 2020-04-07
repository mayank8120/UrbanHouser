package com.uh.urbanhouser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class filterclick_act extends AppCompatActivity {

    Spinner spinnerDropDownViewcity, spinnerDropDownViewlocality;
    String[] spinnerValueHoldValuecitylist = {"Indore", "city unavailable"};
    String[] spinnerValueHoldValuelocality = {"Bhawarkuan", "rajiv gandhi"};

    Button sbut;
    SeekBar seekBar;
    TextView maxprice;

    RadioGroup radioGroup, radioGroup2, radioGroupfurnish;
    RadioButton radioButton, radioButton2, radioButtonfurnish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filterclick_act);

        maxprice = findViewById(R.id.maxprice);
        radioGroup = findViewById(R.id.radioGroup);
        //radioGroup2 = findViewById(R.id.radioGrouptwo);
        radioGroupfurnish = findViewById(R.id.radioGroupgfurnished);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                maxprice.setText("Rs " + progress);
                final int abc = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        //Toast.makeText(filterclick_act.this,"progress "+abc, Toast.LENGTH_SHORT).show();

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        sbut = findViewById(R.id.searchbutton);
        sbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int radioId = radioGroup.getCheckedRadioButtonId();
                //radioButton = findViewById(radioId);

                /*Toast.makeText(filterclick_act.this, "Availability status " + radioButtonfurnish.getText(),
                        Toast.LENGTH_SHORT).show();*/
                //String bhk=radioButton.toString();
                /*String max=maxprice.getText().toString().trim();
                String intValue = max.replaceAll("[^0-9]", "");
                String abcd=intValue.toString().trim();*/
                /*Toast.makeText(filterclick_act.this, "maxprice" +radioButton2.getText().toString().trim(),
                        Toast.LENGTH_SHORT).show();*/

                String max=maxprice.getText().toString().trim();
                String intValue = max.replaceAll("[^0-9]", "");
                String abcd=intValue.toString().trim();
                //Toast.makeText(filterclick_act.this, "city " +abcd, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(filterclick_act.this, searchproperty_act.class);
                intent.putExtra("city",spinnerDropDownViewcity.getSelectedItem().toString());
                intent.putExtra("locality",spinnerDropDownViewlocality.getSelectedItem().toString());
                intent.putExtra("bhkconf",radioButton.getText().toString().trim());
                intent.putExtra("furnishstatus",radioButtonfurnish.getText().toString().trim());
                intent.putExtra("maxprice",abcd);

                //intent.putExtra("bhkconfigure",bhk);
                /*



                intent.putExtra("furnishstatus",radioButtonfurnish.getText().toString().trim());*/
                //intent.putExtra("daterequired",radioButton2.getText().toString().trim());

                startActivity(intent);
            }
        });


        spinnerDropDownViewlocality = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(filterclick_act.this, android.R.layout.simple_list_item_1, spinnerValueHoldValuelocality);
        spinnerDropDownViewlocality.setAdapter(adapter);

        spinnerDropDownViewlocality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(filterclick_act.this, spinnerDropDownViewlocality.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                //String spinnercityy=spinnerDropDownView.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        spinnerDropDownViewcity = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adaptercity = new ArrayAdapter<>(filterclick_act.this, android.R.layout.simple_list_item_1, spinnerValueHoldValuecitylist);
        spinnerDropDownViewcity.setAdapter(adaptercity);

        spinnerDropDownViewcity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(filterclick_act.this, spinnerDropDownViewcity.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                //String spinnercityy=spinnerDropDownViewcity.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        //int radioid2 = radioGroup2.getCheckedRadioButtonId();
        int radioidfurnish= radioGroupfurnish.getCheckedRadioButtonId();


        //radioButton2 = findViewById(radioid2);
        radioButton = findViewById(radioId);
        radioButtonfurnish= findViewById(radioidfurnish);
        /*Toast.makeText(this, "Gender preference " + radioButton3.getText(),
                Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "BHK config " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Availability status " + radioButton2.getText(),
                Toast.LENGTH_SHORT).show();*/

    }


}
