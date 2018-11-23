/*===============================================================================
Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/

package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;


public class ActivityLauncher extends Activity implements OnClickListener
{

    private Button mStartButton;
    private TextView mAboutTextTitle;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.initial_screen);
        mStartButton = (Button) findViewById(R.id.button_submit);
        mStartButton.setOnClickListener(this);
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_submit:
                Intent intent = new Intent(this, AboutScreen.class);
                intent.putExtra("ABOUT_TEXT_TITLE", "Text Recognition Application");
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.TextRecognition.TextReco");
                startActivity(intent);
        }
    }

}
