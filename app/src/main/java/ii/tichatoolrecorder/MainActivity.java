package ii.tichatoolrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ii.tichatoolrecorder.data.model.Student;

//import ii.tichatoolrecorder.Adaptor.InputAdaptor;

public class MainActivity extends AppCompatActivity {

    public static final String STUDENT_SURNAME = "studentSurname";
    public static final String STUDENT_FIRSTNAME= "studentFirstname";
    public static final String STUDENT_LASTNAME = "studentLastname";
    public static final String STUDENT_ID = "studentid";

    // private RecyclerView tasksRecyclerView;
    // private InputAdaptor tasksAdaptor;
    android.widget.TextView teacherNameTxt, subjectTxt, voiceTxt, classesTxt, surname_textView, firstname_textView, lastname_textView, nameOfSchool, TextView, update_TextView,subject_textView,changeSchool_TextView, helpBtn, aboutbtn;
    ImageView closebtn, searchBtn,UserBtn, cancel, menuuBtn,subjectImageBtn,voiceImageBtn, Addstudent, saveBtn, uploadButton, setSchoolLogo, imageView3;
    ConstraintLayout constraintLayout2,subjectBtn, voiceBtn, classesBtn, downLayout, classesImageBtn , mainID;
    EditText  Surname, Firstname,   Middlename,FirstScore, SecondScore, ThirdScore, FourthScore, Exam;
    Button cancleNtaskBtn, Save;
    android.widget.TextView Total, CA;
    LinearLayout classLy, addClassBtn, linearLayout, subjectLY, addSubjectbtn, addSubImgbtn, linearlayout, menuLaY;
    ScrollView classesScrlView, SubjectScrlView;
    RecyclerView tasksRecyclerView;
    DatabaseReference databaseStudents;
    HelperAdapter helperadapter;
    List<FetchData> fetchData;
    TextView SURNAME;
    TextView FIRSTNAME;
    TextView MIDDLENAME;

    //ScoresHelperAdapter scoresHelperAdapter;
    //List<Scores> ScoresHelperAdapter;
    // DatabaseReference databaseScores;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addstudent = findViewById (R.id.addstudentBtn);

        Total = findViewById(R.id.totalscore_textview);
        CA = findViewById(R.id.cascore_textview);
        SURNAME = findViewById(R.id.Surname);
        FIRSTNAME = findViewById(R.id.FirstName);
        MIDDLENAME = findViewById(R.id.middleName);



        //button

        closebtn = (ImageView) findViewById (R.id.closely);

        uploadButton = (ImageView) findViewById (R.id.uploadBtn);
        UserBtn = findViewById(R.id.UserBtn);

        //Layouts

        mainID = (ConstraintLayout) findViewById (R.id.mainID);
        classesImageBtn =(ConstraintLayout) findViewById (R.id.classesBtn);
        subjectBtn =(ConstraintLayout) findViewById (R.id.subjectBtn);

        //EDITTEXT
        //FirstScore = findViewById(R.id.firstscore2);
        //    SecondScore = findViewById(R.id.secondscore2);
        //    ThirdScore = findViewById(R.id.thirdscore2);
        //     FourthScore = findViewById(R.id.fourthscore2);
        //    Exam = findViewById(R.id.examscore2);

        //DATABASE
        databaseStudents = FirebaseDatabase.getInstance().getReference("students");
        //databaseScores = FirebaseDatabase.getInstance().getReference("scores");

        tasksRecyclerView= findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData = new ArrayList<>();
        // ScoresHelperAdapter = new ArrayList<>();


        // Intent intent = getIntent();
        //String id = intent.getStringExtra (MainActivity.STUDENT_ID);
        //String surname = intent.getStringExtra (MainActivity.STUDENT_SURNAME);
        //String FirstName = intent.getStringExtra (MainActivity.STUDENT_FIRSTNAME);
        //String lastname = intent.getStringExtra (MainActivity.STUDENT_LASTNAME);

//        SURNAME.setText(surname);
        //      FIRSTNAME.setText(FirstName);
        //    MIDDLENAME.setText(lastname);



        databaseStudents.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fetchData.clear();


                for (DataSnapshot studentSnapshot: snapshot.getChildren()){
                    FetchData data = studentSnapshot.getValue (FetchData.class);
                    fetchData.add(data);




                }

                helperadapter = new HelperAdapter (fetchData);
                tasksRecyclerView.setAdapter(helperadapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

      /* databaseScores.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 ScoresHelperAdapter.clear();

                 for (DataSnapshot scoresSnapshot : snapshot.getChildren()) {
                     Scores data1 = scoresSnapshot.getValue(Scores.class);
                     ScoresHelperAdapter.add(data1);
                 }
                 ScoresHelperAdapter scoresAdapter= new ScoresHelperAdapter (MainActivity.this, ScoresHelperAdapter);
                // tasksRecyclerView.setAdapter(scoresAdapter);

             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });  */

        //setting adaptor recyclerview
        //tasksAdaptor = new InputAdaptor(this);
        //  tasksRecyclerView.setAdapter(tasksAdaptor);



        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upload upT = new Upload();
                getSupportFragmentManager().beginTransaction().replace(R.id.FragToloadInput, upT).commit();
            }
        });

        Addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                }






        });

        UserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, landingpage.class);
                startActivity(i);
            }
        });






        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classLy.setVisibility(View.GONE);
                subjectLY.setVisibility(View.GONE);
                closebtn.setVisibility(View.GONE);
                menuLaY.setVisibility(View.GONE);

                Surname.getText().clear();
                Firstname.getText().clear();
                Middlename.getText().clear();




            }
        });




    }

    private void addStudent(){

        String surname= Surname.getText().toString().trim();
        String firstname = Firstname.getText().toString().trim();
        String middlename = Middlename.getText().toString().trim();
        //String  studentClass =  Classes.getText().toString().trim();


        if(TextUtils.isEmpty(surname)){
            Surname.setError("Surname is required");
        }
        if(TextUtils.isEmpty(firstname)){
            Firstname.setError("Firstname is required");

        }
        if(TextUtils.isEmpty(middlename)){
            Middlename.setError("Middlename is required");

        }

        else {
            String id = databaseStudents.push().getKey();
            Student student = new Student (id,surname,firstname,middlename);

            databaseStudents.child(id).setValue(student);
            Toast.makeText(this, "Student details Added", Toast.LENGTH_SHORT).show();



            //startActivity(new Intent (getApplicationContext(), MainActivity.class));
           // addpuLY.setVisibility(View.GONE);

            Intent intent = new Intent (getApplicationContext(), MainActivity.class);
            startActivity(intent);
            //intent.putExtra(STUDENT_ID, student.getStudentid());
            //intent.putExtra(STUDENT_FIRSTNAME, student.getStudentFirstname());
            //intent.putExtra(STUDENT_SURNAME, student.getStudentSurname());
            //intent.putExtra(STUDENT_LASTNAME, student.getStudentLastname());




            Surname.getText().clear();
            Firstname.getText().clear();
            Middlename.getText().clear();
            //Class.getText().clear();


        }


    }}
