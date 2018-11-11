/*===============================================================================
Copyright (c) 2012-2015 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/


package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;


// This activity starts activities which demonstrate the Vuforia features
public class ProActivity extends ListActivity
{

    private String mActivities[] = { "Pro Words Recognition!!!"};


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activities_list_text_view, mActivities);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activities_list);
        setListAdapter(adapter);
        System.out.println("In on create ACTIVITY LAUNCHER");
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent intent = new Intent(this, AboutScreen.class);
        intent.putExtra("ABOUT_TEXT_TITLE", mActivities[position]);

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

    }
}
