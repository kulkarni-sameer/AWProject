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
    private TextView mInstructions;

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
        mInstructions=(TextView) findViewById(R.id.steps);
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

        if(ids.equals("Spanish")){
            mAboutTextTitle.setText("Instrucciones:");
            mInstructions.setText("1. Apunte la cámara de su teléfono a la palabra para traducirla al idioma elegido." + "\n"+
                    "\n"+  "2. Después de la detección de la palabra, la aplicación lo llevará automáticamente a la página traducida." +"\n"+
                    "\n"+    "3. La página traducida tendrá botones traducidos." +"\n"+
                    "\n"+  "4. Haga clic en los botones para obtener resultados.");


        }
        else if(ids.equals("Portuguese")){
            mAboutTextTitle.setText("Instruções:");
            mInstructions.setText("1. Aponte a câmera do seu celular para a palavra para traduzi-la para o idioma escolhido." +"\n"+
                    "\n"+     "2. Após a detecção da palavra, o aplicativo levará você para a página traduzida automaticamente." +"\n"+
                    "\n"+  "3. A página traduzida terá botões traduzidos." +"\n"+
                    "\n"+ "4. clique nos botões para obter resultados.");
        }
        else if(ids.equals("Italian")){
            mAboutTextTitle.setText("Istruzioni:");
            mInstructions.setText("1. Puntare la fotocamera del telefono sulla parola per tradurla nella lingua scelta." +"\n"+
                    "\n"+  "2. Dopo il rilevamento della parola, l'applicazione ti porterà automaticamente alla pagina tradotta." +"\n"+
                    "\n"+"3. La pagina tradotta avrà pulsanti tradotti." +"\n"+
                    "\n"+"4. clicca sui pulsanti per ottenere risultati.");


        }
        else if(ids.equals("French")){
            mAboutTextTitle.setText("Instructions:");
            mInstructions.setText("1. Dirigez l'appareil photo de votre téléphone vers le mot pour le traduire dans la langue de votre choix."
                    +"\n"+"\n"+
                    "2. Après détection du mot, l'application vous mènera automatiquement à la page traduite." +"\n"+"\n"+
                    "3. La page traduite aura des boutons traduits." +"\n"+"\n"+
                    "4. cliquez sur les boutons pour obtenir des résultats.");

        }
        else if(ids.equals("German")){
            mAboutTextTitle.setText("Anweisungen:");
            mInstructions.setText("1. Richten Sie Ihre Telefonkamera auf das Wort, um es in die von Ihnen gewählte Sprache zu übersetzen." +"\n"+
                    "\n"+      "2. Nachdem das Wort erkannt wurde, führt Sie die Anwendung automatisch zur übersetzten Seite." +"\n"+
                    "\n"+     "3.Die übersetzte Seite enthält Schaltflächen." +"\n"+
                    "\n"+"4. Klicken Sie auf die Schaltflächen, um Ergebnisse zu erhalten");

        }
        else {
            //pass
        }

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