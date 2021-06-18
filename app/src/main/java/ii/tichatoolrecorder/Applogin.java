package ii.tichatoolrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Applogin extends AppCompatActivity {

    Button Login;
    EditText Email;
    TextInputEditText Password;
    TextView RegisterBtn, RemindMeBtn, forgotpassword;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applogin);

        Email = findViewById (R.id.email_edittext);
        Password = findViewById(R.id.loginEditext);
        RegisterBtn= findViewById(R.id.registerbtn);
        Login = findViewById(R.id.login_btn);
        fAuth = FirebaseAuth.getInstance();
        forgotpassword = findViewById(R.id.forgotpasswordbtn);


    //    if(fAuth.getCurrentUser()!= null){
   //         startActivity(new Intent(getApplicationContext(), MainActivity.class));
     //       finish();
   //     }
               forgotpassword.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       final EditText resetMail = new EditText (v.getContext());
                       AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder( v.getContext());
                       passwordResetDialog.setTitle(" Reset Password?");
                       passwordResetDialog.setMessage("Enter Your Email to Receive Reset Link.");
                       passwordResetDialog.setView(resetMail);

                       passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               //extract email and send request
                               String mail = resetMail.getText().toString();
                               fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                   @Override
                                   public void onSuccess(Void aVoid) {
                                       Toast.makeText(Applogin.this, "Reset Link Sent to your Email", Toast.LENGTH_SHORT).show();
                                   }
                               }).addOnFailureListener(new OnFailureListener() {
                                   @Override
                                   public void onFailure(@NonNull Exception e) {
                                       Toast.makeText(Applogin.this, "Error! Reset Link is not sent"+e.getMessage(), Toast.LENGTH_SHORT).show();
                                   }
                               });
                           }
                       });

                  /*     passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {

                               //close the dialog
                           }
                       });
                  */
                   }
               });
















        Login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String username = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Email.setError("Email or Phone Number is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Password.setError("Password is Required.");
                    return;
                }

                //authenticate the user

                fAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Applogin.this,"Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), landingpage.class));}
                        else{
                            Toast.makeText(Applogin.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }




                });
            }
        });

      /*  Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Applogin.class));
            }
        });  */


    };

}