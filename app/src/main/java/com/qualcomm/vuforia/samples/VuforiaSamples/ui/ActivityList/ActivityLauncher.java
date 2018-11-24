package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;


public class ActivityLauncher extends Activity implements OnClickListener
{

    private Button mStartButton;
    private TextView mAboutTextTitle;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    private String username;
    private String ids;

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
        Bundle extras = getIntent().getExtras();
        System.out.println("***********************");
        System.out.println(extras.getString("par1"));
        System.out.println(extras.getString("par2"));
        System.out.println(extras.getInt("par3"));
        System.out.println("***********************");
        System.out.println("Goes to Text Reco.java");
        mClassToLaunchPackage = "com.qualcomm.vuforia.samples.VuforiaSamples";
         mClassToLaunch = "com.qualcomm.vuforia.samples.VuforiaSamples.app.TextRecognition.TextReco";
        ids = extras.getString("Selected_Level");
        username = extras.getString("Username");

    }

    private void startARActivity()
    {
        Intent i = new Intent();
        i.setClassName(mClassToLaunchPackage, mClassToLaunch);
//        int radiID=mSelectedRadioButton.getCheckedRadioButtonId();
//        mselectedRadioButton=(RadioButton) findViewById(ids);
//        System.out.println("ID...."+ids);
//        System.out.println("Selected Radio Button : ....."+mselectedRadioButton.getText());
        String content = username;
        i.putExtra("Username",content);
        i.putExtra("Selected_Level",ids);
        i.putExtra("par1",mClassToLaunchPackage);
        i.putExtra("par2",mClassToLaunch);
        //i.putExtra("SelectedRadioButton", "mSelected");
        System.out.println("Goes to Text Reco.java");

        startActivity(i);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_submit:
//                Intent intent = new Intent(this, AboutScreen.class);
//                intent.putExtra("ABOUT_TEXT_TITLE", "Text Recognition Application");
//                intent.putExtra("ACTIVITY_TO_LAUNCH",
//                        "app.TextRecognition.TextReco");
//                startActivity(intent);
                startARActivity();
                break;
        }
    }

}