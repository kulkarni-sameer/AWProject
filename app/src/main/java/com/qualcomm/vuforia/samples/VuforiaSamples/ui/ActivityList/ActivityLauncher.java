package com.qualcomm.vuforia.samples.VuforiaSamples.ui.ActivityList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ActivityLauncher extends Activity implements OnClickListener
{

    private Button mStartButton;
    private TextView mAboutTextTitle;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    private String username;
    private String ids;
    private ListView mStepsListView;
    private String[] steps=new String[]{
           "Step 1: Point your phone camera on the word to translate it in your chosen language.",
           "Step 2: After detection of the word,the application will take to a translated page .",
           "Step 3: The translated page will have translated buttons too."
   };
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.initial_screen);

        //setListAdapter(new ArrayAdapter<String>(this, R.layout.initial_screen, steps));

        //ListView lv = getListView();
        //lv.setTextFilterEnabled(true);
        mStartButton = (Button) findViewById(R.id.button_submit);
        mStartButton.setOnClickListener(this);
        mAboutTextTitle = (TextView) findViewById(R.id.about_text_title);
        mStepsListView=(ListView) findViewById(R.id.steps);
        List<String> stepsList=new ArrayList<>(Arrays.asList(steps));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.initial_screen_text_view,stepsList){
            @Override
            public View getView (int position, View convertView, ViewGroup parent){
                View view = super.getView(position,convertView,parent);

                // Get the Layout Parameters for ListView Current Item View
                ViewGroup.LayoutParams params = view.getLayoutParams();

                // Set the height of the Item View
                params.height = 200;  // earlier was 100
                view.setLayoutParams(params);

        return view;
            }

        };
        mStepsListView.setAdapter(arrayAdapter);
        mStepsListView.setDividerHeight(10);
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
       // mWelcomeTitle.setText("Bienvenue, " +username +"!");
        mAboutTextTitle.setText("Instructions for using the Application, "+ username+"!");

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