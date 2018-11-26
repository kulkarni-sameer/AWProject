/*===============================================================================
Copyright (c) 2012-2015 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/


package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.os.AsyncTask;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;

import java.util.Locale;


// This activity starts activities which demonstrate the Vuforia features
public class ItalianActivity extends Activity implements View.OnClickListener
{

    //private String mActivities[] = { "Beginner Words Recognition!!!"}
    private Button mTranslateButton;
    private Button mPronunciateButton;
    private TextView mAboutTextTitle;
    private TextView mWelcomeTitle;
    private TextView mDetectedWord;
    private String translated_word;
    private TextToSpeech mTTS; //for TextToSpeech Service
    private String detected_word;
    private static final String API_KEY = "AIzaSyDsEHZptaJ730UVPB9ePrnGGYJfEclXJ64";
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
        mTranslateButton.setText("Tradurre (Translate)");
        mPronunciateButton=(Button) findViewById(R.id.pronunciation);
        mPronunciateButton.setOnClickListener(this);
        mPronunciateButton.setText("Pronunciare (Pronounce)");
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
        mAboutTextTitle.setText("Italian Translation");
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        mWelcomeTitle = (TextView) findViewById(R.id.welcomeText);
        mWelcomeTitle.setText("Benvenuto, " +username +"!");
        mDetectedWord=(TextView) findViewById(R.id.detectedWord) ;
        detected_word= getIntent().getStringExtra("detectedword");






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
                // mTranslateButton.setVisibility(View.GONE);
                // startARActivity();
                speak();
                break;

            case R.id.translate:
                final TextView textView = (TextView) findViewById(R.id.detectedWord);
                final Handler textViewHandler = new Handler();


                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        TranslateOptions options = TranslateOptions.newBuilder()
                                .setApiKey(API_KEY)
                                .build();
                        Translate translate = options.getService();
                        final Translation translation =
                                translate.translate(detected_word,
                                        Translate.TranslateOption.targetLanguage("it"));
                        textViewHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                //  if (textView != null) {
                                //   textView.setText(translation.getTranslatedText());
                                // Toast.makeText(getApplicationContext(), translation.getTranslatedText(),
                                //       Toast.LENGTH_LONG).show();
                                translated_word = translation.getTranslatedText();
                                System.out.println(translation.getTranslatedText());
                                mDetectedWord.setText("\n" +
                                        "La parola tradotta è (The translated word is) : " +translated_word);
                                // }
                            }
                        });
                        return null;
                    }
                }.execute();
        }
        System.out.println("In on Click beginner activity.java");

        // Toast.makeText(SpanishActivity.this, "THis is my message", Toast.LENGTH_SHORT).show();
    }
    public void speak(){
        // String text=mDetectedWord.getText().toString();
        //mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        System.out.println("Only the word " + detected_word);
        //speak the word detected
        mTTS.speak(translated_word,TextToSpeech.QUEUE_FLUSH,null );
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
