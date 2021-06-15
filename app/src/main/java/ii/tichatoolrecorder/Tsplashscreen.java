package ii.tichatoolrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Tsplashscreen extends AppCompatActivity {

    TextView textView, the_iibuilder;
    ImageView Tichatool_imageView,from_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsplashscreen);
SharedPreferences sharedPreferences;
        //comfirm this code
      //  SharedPreferences settings=getSharedPreferences("prefs",0);
      //  boolean firstRun=settings.getBoolean("firstRun",false);
      //  if(firstRun==false){
        //    SharedPreferences.Editor editor=settings.edit();
         //   editor.putBoolean("firstRun",true);
         //   editor.commit();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(Tsplashscreen.this, Applogin.class);
                startActivity(i);
                finish();

                //add a else here if app isn't registered it should launch this activity

            }
        },  1000);
    }
}

