/*===============================================================================
Copyright (c) 2012-2015 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/


package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;


// This activity starts activities which demonstrate the Vuforia features
public class BeginnerActivity extends Activity implements View.OnClickListener
{

    //private String mActivities[] = { "Beginner Words Recognition!!!"};
    private Button mTranslateButton;

    private TextView mAboutTextTitle;
    private TextView mDetectedWord;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.beginner_activity);
        //setListAdapter(adapter);
        mTranslateButton=(Button) findViewById(R.id.translate) ;
        //mTranslateButton.setOnClickListener();
        mTranslateButton.setOnClickListener(this);
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
        mAboutTextTitle.setText("Beginner level Recognition");
        mDetectedWord=(TextView) findViewById(R.id.detectedWord) ;
        mDetectedWord.setText("The Detected Word is : " +"Beginner");
        System.out.println("In on create Beginner Activity");
    }


    @Override
    public void onClick(View view) {
        System.out.println("In on Click beginneractivity.java");
        System.out.println(mTranslateButton.getText());
       // System.out.println("ON CLICK BUTTON...."+view.getId());
        Toast.makeText(BeginnerActivity.this, "THis is my message", Toast.LENGTH_SHORT).show();
    }
    /*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent intent = new Intent(this, AboutScreen.class);
       // intent.putExtra("ABOUT_TEXT_TITLE", mActivities[position]);

        switch (position)
        {
            case 0:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.TextRecognition.TextReco");
                // intent.putExtra("ABOUT_TEXT", "TextReco/TR_about.html");
                break;
        }
        System.out.println("In on List ACTIVITY LAUNCHER");

        startActivity(intent);

    } */
}
