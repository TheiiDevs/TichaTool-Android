package ii.tichatoolrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ii.tichatoolrecorder.data.model.Scores;

public class InputLayout extends AppCompatActivity {

    public static final String FIRST_SCORE = "firstScore";
    public static final String SECOND_SCORE= "secondScore";
    public static final String THIRD_SCORE = "thirdScore";
    public static final String FOURTH_SCORE = "fourthScore";
    public static final String EXAM = "exam";
    public static final String SCORESID = "scoresId";


    DatabaseReference databaseScores;
    TextView Lfirstname;
    ConstraintLayout FullNameDisplay;
    Button backFullname;
    TextView Surnamee,FirstNamee, MiddleNamee, SaveInput, CancelInput;
    EditText FirstScore, SecondScore, ThirdScore, FourthScore, Exam;
    List<Scores> scores;
    ScoresHelperAdapter scoresHelperAdapter;
    RecyclerView tasksRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputlayout);

        Lfirstname= findViewById (R.id.taskLfirstname);
        FullNameDisplay = findViewById (R.id. fullNameDisplay);
        backFullname = findViewById (R.id.    backFullnamebtn );
        Surnamee= findViewById (R.id.SurnameDisplay);
        FirstNamee= findViewById (R.id.FirstNameDisplay);
        MiddleNamee= findViewById (R.id.middleNameDisplay);
        SaveInput = findViewById(R.id.saveinputBtn);
        FirstScore = findViewById(R.id.fourhtscore);
        SecondScore = findViewById(R.id.firstscore);
        ThirdScore = findViewById(R.id.secondscore);
        FourthScore = findViewById(R.id.thirdhscore);
        Exam = findViewById(R.id.examscore);
        CancelInput = findViewById(R.id.cancelinput);

        tasksRecyclerView= findViewById(R.id.tasksRecyclerView);
        //tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        scores = new ArrayList<>();

        String id = intent.getStringExtra (MainActivity.STUDENT_ID);
        String surname = intent.getStringExtra (MainActivity.STUDENT_SURNAME);
        String FirstName = intent.getStringExtra (MainActivity.STUDENT_FIRSTNAME);
        String lastname = intent.getStringExtra (MainActivity.STUDENT_LASTNAME);

        Surnamee.setText(surname);
        FirstNamee.setText(FirstName);
        MiddleNamee.setText(lastname);

        databaseScores= FirebaseDatabase.getInstance().getReference("scores").child(id);

        CancelInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent (getApplicationContext(), MainActivity.class));

            }
        });

        SaveInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveScores();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseScores.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                scores.clear();

                for (DataSnapshot scoresSnapshot : snapshot.getChildren()) {
                    Scores data = scoresSnapshot.getValue(Scores.class);
                    scores.add(data);
                }
                ScoresHelperAdapter scoresHelperAdapter = new ScoresHelperAdapter(InputLayout.this, scores);
                //tasksRecyclerView.setAdapter(scoresHelperAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void saveScores(){
        String Firstscore = FirstScore.getText().toString();
        int firstscore1 =Integer.parseInt(Firstscore);

        String Secondscore =SecondScore.getText().toString();
        int secondscore1 =Integer.parseInt(Secondscore);

        String Thirdscore = ThirdScore.getText().toString();
        int thirdscore1 =Integer.parseInt(Thirdscore);

        String Fourthscore = FourthScore.getText().toString();
        int fourthscore1 =Integer.parseInt(Fourthscore);

        String Examm = Exam.getText().toString();
        int examscore =Integer.parseInt(Examm);


        if(TextUtils.isEmpty(Firstscore)){
            FirstScore.setError("Input Score");

        }
        if(TextUtils.isEmpty(Secondscore)){
            SecondScore.setError("Input Score");

        }
        if(TextUtils.isEmpty(Thirdscore)){
            ThirdScore.setError("Input Score");

        }
        if(TextUtils.isEmpty(Fourthscore)){
            FourthScore.setError(" Input Score");

        }
        if(TextUtils.isEmpty(Examm)){
            Exam.setError(" Input Score");

        }
        else {
            String id = databaseScores.push().getKey();
            Scores scores = new Scores(id,Firstscore,Secondscore,Thirdscore,Fourthscore,Examm);
            databaseScores.child(id).setValue(scores);
            Toast.makeText(this, "Scores Updates Successfully", Toast.LENGTH_SHORT).show();





            // startActivity(new Intent (getApplicationContext(), MainActivity.class));
            Intent intent = new Intent (getApplicationContext(), MainActivity.class);

            intent.putExtra(SCORESID, scores.getScoresId());
            intent.putExtra(FIRST_SCORE, scores.getFirstScore());
            intent.putExtra(SECOND_SCORE, scores.getSecondScore());
            intent.putExtra(THIRD_SCORE, scores.getThirdScore());
            intent.putExtra(FOURTH_SCORE, scores.getFourthScore());
            intent.putExtra(EXAM, scores.getExam());


            startActivity(intent);






            FirstScore.getText().clear();
            SecondScore.getText().clear();
            ThirdScore.getText().clear();
            FourthScore.getText().clear();
            Exam.getText().clear();;
        }


    }

}
