package ii.tichatoolrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class landingpage extends AppCompatActivity {

    RecyclerView SchoolRecyclerView;
    ImageButton reqbackbtn;
    ConstraintLayout reqbtn;
    LinearLayout requestLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

        //buttons
        reqbtn = findViewById(R.id.requestLybtn);
        reqbackbtn = findViewById(R.id.requestbackBtn);

        //layouts
        requestLy = (LinearLayout) findViewById(R.id.requestLY);


        SchoolRecyclerView = findViewById(R.id.schoolRecyclerView);



        reqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLy.setVisibility(View.VISIBLE);

            }
        });

        reqbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLy.setVisibility(View.GONE);

            }
        });
    }
}