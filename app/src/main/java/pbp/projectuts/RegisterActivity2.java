package pbp.projectuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pbp.projectuts.UnitTest.LoginActivity;
import pbp.projectuts.model.UserDetail;
import pbp.projectuts.util.CustomToast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity2 extends AppCompatActivity {
    EditText emailId, firstName, lastName, telepon, password;
    Button btnSignUp;
    TextView tvSignIn;

    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_register2);

        emailId = findViewById(R.id.editTextEmail);
        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        telepon = findViewById(R.id.editTextTelepon);
        password = findViewById(R.id.editTextPassword);
        btnSignUp = findViewById(R.id.signUpButton);
        tvSignIn = findViewById(R.id.textViewSignIn);


        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailId.getText().toString();
                final String fName = firstName.getText().toString();
                final String lName = lastName.getText().toString();
                final String add = telepon.getText().toString();
                final String pwd = password.getText().toString();

                if (email.isEmpty()) {
                    emailId.setError("Please provide email id");
                    emailId.requestFocus();
                } else if (fName.isEmpty()) {
                    firstName.setError("Please provide your first name");
                    firstName.requestFocus();
                } else if (lName.isEmpty()) {
                    lastName.setError("Please provide your last name");
                    lastName.requestFocus();
                } else if (add.isEmpty()) {
                    telepon.setError("Please provide your number");
                    telepon.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please provide password");
                    password.requestFocus();
                }else if(password.length() < 6){
                    password.setError("Password Must be >= 6 Characters");
                }else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(RegisterActivity2.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity2.this,
                                                "SignUp Unsuccessful, Plaese Try Again!"
                                                        + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    } else {

                                        mFirebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>(){
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()) {
                                                    Toast.makeText(RegisterActivity2.this, "SignUp Successful. Please check your email for verification",
                                                            Toast.LENGTH_LONG).show();
                                                    emailId.setText("");
                                                    password.setText("");
                                                    startActivity(new Intent(RegisterActivity2.this, LoginActivity.class));
                                                    finish();
                                                }else{
                                                    Toast.makeText(RegisterActivity2.this, task.getException().getMessage(),
                                                            Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                        UserDetail userDetail = new UserDetail(fName, lName, add);
                                        String uid = task.getResult().getUser().getUid();
                                        firebaseDatabase.getReference(uid).setValue(userDetail)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Intent intent = new Intent(RegisterActivity2.this,
                                                                MainActivity.class);
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                        intent.putExtra("name", fName + " " + lName);
                                                        startActivity(intent);
                                                    }
                                                });
                                    }

                                }
                            });
                } else {
                    CustomToast.createToast(RegisterActivity2.this, "Error Occurred !", true);
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity2.this, LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }
}
