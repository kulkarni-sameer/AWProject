/*===============================================================================
Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States 
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/

package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;


public class AboutScreen extends Activity implements OnClickListener
{
    private static final String LOGTAG = "AboutScreen";
    
    //private WebView mAboutWebText;
    private Button mStartButton;
    private RadioGroup mSelectedRadioButton;
    private RadioButton mselectedRadioButton;
    private TextView mAboutTextTitle;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    private EditText mUserNameText;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        System.out.println(" Beginning of ON Create AboutScreen.java----");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.about_screen);
        
        Bundle extras = getIntent().getExtras();
        //String webText = extras.getString("ABOUT_TEXT");
        mClassToLaunchPackage = getPackageName();
        mClassToLaunch = "app.TextRecognition.TextReco";
        
      //  mAboutWebText = (WebView) findViewById(R.id.about_html_text);
        
       // AboutWebViewClient aboutWebClient = new AboutWebViewClient();
       // mAboutWebText.setWebViewClient(aboutWebClient);



        mSelectedRadioButton=(RadioGroup) findViewById(R.id.RadioGroup);
        mUserNameText=(EditText) findViewById(R.id.UserNameText);
        mStartButton = (Button) findViewById(R.id.button_submit);
        mStartButton.setOnClickListener(this);
        //System.out.println("UserName Field:...."+mUserNameText.getText().toString());
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
      //  mAboutTextTitle.setText(extras.getString("ABOUT_TEXT_TITLE"));

        System.out.println("End of ON Create AboutScreen.java----");
    }

    
    // Starts the chosen activity
    private void startARActivity()
    {
        Intent i = new Intent();
        i.setClassName(mClassToLaunchPackage, mClassToLaunch);
        int radioID=mSelectedRadioButton.getCheckedRadioButtonId();
        mselectedRadioButton=(RadioButton) findViewById(radioID);
        System.out.println("ID...."+radioID);
        System.out.println("Selected Radio Button : ....."+mselectedRadioButton.getText());
        String content = mUserNameText.getText().toString();
        i.putExtra("Username",content);
        i.putExtra("Selected_Level",mselectedRadioButton.getText().toString());
        i.putExtra("par1",mClassToLaunchPackage);
        i.putExtra("par2",mClassToLaunch);
        //i.putExtra("SelectedRadioButton", "mSelected");
        System.out.println("Goes to Text Reco.java");

        startActivity(i);
    }
    
    
    @Override
    public void onClick(View v)
    {  System.out.println("In on Click About SCreen.java");
        System.out.println("ON CLICK BUTTON...."+v.getId());
        switch (v.getId())
        {
            case R.id.button_submit:

                Intent intent = new Intent(AboutScreen.this,
                        ActivityLauncher.class);
                int radioID=mSelectedRadioButton.getCheckedRadioButtonId();
                mselectedRadioButton=(RadioButton) findViewById(radioID);
                System.out.println("ID...."+radioID);
                System.out.println("Selected Radio Button : ....."+mselectedRadioButton.getText());
                String content = mUserNameText.getText().toString();
                intent.putExtra("Username",content);
                intent.putExtra("Selected_Level",mselectedRadioButton.getText().toString());
                intent.putExtra("par1",mClassToLaunchPackage);
                intent.putExtra("par2",mClassToLaunch);
                intent.putExtra("par3",mSelectedRadioButton.getCheckedRadioButtonId());
                //i.putExtra("SelectedRadioButton", "mSelected");
                System.out.println("Goes to Text Reco.java");
                startActivity(intent);
        }
    }
    
//    private class AboutWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);
//            return true;
//        }
//    }
}
