/*===============================================================================
Copyright (c) 2012-2015 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/


package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;

import java.util.Locale;


// This activity starts activities which demonstrate the Vuforia features
public class GermanActivity extends Activity implements View.OnClickListener
{

    //private String mActivities[] = { "Beginner Words Recognition!!!"}
    private Button mTranslateButton;
    private Button mPronunciateButton;
    private TextView mAboutTextTitle;
    private TextView mDetectedWord;
    private TextToSpeech mTTS; //for TextToSpech Service
    private String detected_word;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.beginner_activity);
        mTranslateButton=(Button) findViewById(R.id.translate) ;
        mTranslateButton.setOnClickListener(this);
        mPronunciateButton=(Button) findViewById(R.id.pronunciation);
        mPronunciateButton.setOnClickListener(this);
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
        mAboutTextTitle.setText("German Recognition");
        mDetectedWord=(TextView) findViewById(R.id.detectedWord) ;
        detected_word= getIntent().getStringExtra("detectedword");
        mDetectedWord.setText("The Detected Word is : " +detected_word);
        mTTS=new TextToSpeech(this, new TextToSpeech.OnInitListener() { //TextToSpeech Class
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS){   //if inistializatio is successful
                    int lang=mTTS.setLanguage(Locale.US);  //Language setting up
                    if(lang==TextToSpeech.LANG_MISSING_DATA
                            || lang==TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("Text_Speech","Language Not Supported");
                    }
                    else{

                    }
                } else{
                    Log.e("Text_Speech","Initialization Failed");
                }
            }
        });
        System.out.println("In on create Beginner Activity");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.pronunciation:
                mTranslateButton.setVisibility(View.GONE);
                // startARActivity();
                speak();
                break;
        }
        System.out.println("In on Click beginner activity.java");

        // Toast.makeText(SpanishActivity.this, "THis is my message", Toast.LENGTH_SHORT).show();
    }
    public void speak(){
        // String text=mDetectedWord.getText().toString();
        //mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        System.out.println("Only the word " + detected_word);
        //speak the word detected
        mTTS.speak(detected_word,TextToSpeech.QUEUE_FLUSH,null );
        //QueueFlush : current text gets cancelled to speak the new one

    }

    @Override
    protected void onDestroy() {
        if(mTTS!=null){
            mTTS.stop();
            mTTS.shutdown();}
        super.onDestroy();

    }
}
