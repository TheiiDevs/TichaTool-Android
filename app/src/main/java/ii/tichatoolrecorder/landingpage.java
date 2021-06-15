package ii.tichatoolrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class landingpage extends AppCompatActivity {

    RecyclerView SchoolRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);


        SchoolRecyclerView = findViewById(R.id.schoolRecyclerView);
    }
}