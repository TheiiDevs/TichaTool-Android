package ii.tichatoolrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

//class Users {


    //public String username;
    //public String email;

   // public Users() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
   // }

  //  public Users(String username, String email) {
    //    this.username = username;
      //  this.email = email;
  //  }

//}
public class Users extends AppCompatActivity {
    TextView Lfirstname, FirstScore_Textview, SecondScore_Textview, ThirdScore_Textview, FourthScore_Textview, Exam;
    ConstraintLayout FullNameDisplay;
    Button backFullname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        Lfirstname= findViewById (R.id.taskLfirstname);
        FullNameDisplay = findViewById (R.id. fullNameDisplay);
        backFullname = findViewById (R.id.    backFullnamebtn );
        FirstScore_Textview = findViewById(R.id.firstscore_textview);
                SecondScore_Textview = findViewById(R.id.secondscore_textview);
                ThirdScore_Textview = findViewById(R.id.thirdscore_textview);
                FourthScore_Textview= findViewById(R.id.fourthscore_textview);
                Exam = findViewById(R.id.examscore_textview);



        Lfirstname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullNameDisplay.setVisibility(View.VISIBLE);
            }
        });

        backFullname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullNameDisplay.setVisibility(View.GONE);
            }
        });

        Intent intent = getIntent();
        String id = intent.getStringExtra (InputLayout.SCORESID);
        String firstscore = intent.getStringExtra (InputLayout.FIRST_SCORE);
        String secondscore = intent.getStringExtra (InputLayout.SECOND_SCORE);
        String thirdscore = intent.getStringExtra (InputLayout.THIRD_SCORE);
        String fourthscore = intent.getStringExtra (InputLayout.FOURTH_SCORE);
        String exam = intent.getStringExtra (InputLayout.EXAM);


        FirstScore_Textview.setText(firstscore);
        SecondScore_Textview.setText(secondscore);
        ThirdScore_Textview.setText(thirdscore);
        FourthScore_Textview.setText(fourthscore);
        Exam.setText(exam);

    }
}