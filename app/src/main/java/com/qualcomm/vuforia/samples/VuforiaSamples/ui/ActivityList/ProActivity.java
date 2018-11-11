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
public class ProActivity extends Activity implements View.OnClickListener
{

    //private String mActivities[] = { "Pro Words Recognition!!!"};
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
        setContentView(R.layout.pro_activity);
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
        mAboutTextTitle.setText("Pro level Recognition");
        mDetectedWord=(TextView) findViewById(R.id.detectedWord) ;
        mDetectedWord.setText("The Detected Word is : " +"PRO");
        System.out.println("In on create pro activity");
    }


    @Override
    public void onClick(View view) {
       // System.out.println("ON CLICK BUTTON...."+);
        Toast.makeText(ProActivity.this, "THis is my message ", Toast.LENGTH_SHORT).show();
    }
}
