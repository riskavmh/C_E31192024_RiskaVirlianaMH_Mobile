package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //inisiasi object
    private Button buttonPindahActivity, buttonPindahActivityDenganData, buttonDialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View
        buttonPindahActivity = findViewById(R.id.buttonPindahActivity);
        //handle button click
        buttonPindahActivity.setOnClickListener(this);

        //View
        buttonPindahActivityDenganData = findViewById(R.id.buttonPindahActivityDenganData);
        //handle button click
        buttonPindahActivityDenganData.setOnClickListener(this);

        //View
        buttonDialNumber = findViewById(R.id.buttonDialNumber);
        //handle button click
        buttonDialNumber.setOnClickListener(this); }
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttonPindahActivity:
                        Intent moveIntent = new Intent(this, MoveActivity.class);
                        startActivity(moveIntent);
                        break;
                    case R.id.buttonPindahActivityDenganData:
                        Intent moveWithDataIntent = new Intent(this, MoveWithDataActivity.class);
                        moveWithDataIntent.putExtra("extra_name", "Riska Virliana M H");
                        moveWithDataIntent.putExtra("extra_age",5);
                        startActivity(moveWithDataIntent);
                        break;
                    case R.id.buttonDialNumber:
                        String phoneNumber = "082335344634";
                        Intent dialphone = new Intent(Intent.ACTION_DIAL, Uri.parse("telp:"+phoneNumber));
                        startActivity(dialphone);
                        break;
                    case R.id.buttonMaps:
                        Intent maps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-8.208222, 113.686913"));
                        startActivity(maps);
                        break;
                    case R.id.buttonSMS:
                        Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: 082335344634"));
                        sms.putExtra("sms_body", "Assalamualaikum");
                        startActivity(sms);
                        break;
                    case R.id.buttonShare:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_TEXT, "Mari Belajar Android");
                        startActivity(Intent.createChooser(share, "Share Link"));
                        break;
                }
            }
        }
