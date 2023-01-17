package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%_^&+=])(?=\\S+$).{8,}$");

    private EditText editTextRegisterFirstName,
            editTextRegisterLastName,
            editTextRegisterEmail,
            editTextRegisterMobile,
            editTextRegisterPwd,
            editTextRegisterConfirmPwd;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        getSupportActionBar().setTitle("Register");

        Toast.makeText(RegisterActivity.this, "You can register now", Toast.LENGTH_LONG).show();

        editTextRegisterFirstName = findViewById(R.id.firstNameEditText);
        editTextRegisterLastName = findViewById(R.id.lastNameEditText);
        editTextRegisterEmail = findViewById(R.id.emailEditText);
        editTextRegisterMobile = findViewById(R.id.phoneNumberEditText);
        editTextRegisterPwd = findViewById(R.id.passwordEditText);
        editTextRegisterConfirmPwd = findViewById(R.id.confirmPasswordEditText);

        Button buttonRegister = findViewById(R.id.registerButton);

        buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.registerButton) {
            String textFirstName = editTextRegisterFirstName.getText().toString();
            String textLastName = editTextRegisterLastName.getText().toString();
            String textEmail = editTextRegisterEmail.getText().toString();
            String textMobile = editTextRegisterMobile.getText().toString();
            String textPwd = editTextRegisterPwd.getText().toString();
            String textConfirmPwd = editTextRegisterConfirmPwd.getText().toString();

            boolean errorOccurred = false;
            if (TextUtils.isEmpty(textFirstName)) {
                Toast.makeText(RegisterActivity.this, "Please enter your first name.", Toast.LENGTH_LONG).show();
                editTextRegisterFirstName.setError("First name is required.");
                editTextRegisterFirstName.requestFocus();
                errorOccurred = true;
            }  if (TextUtils.isEmpty(textLastName)) {
                 Toast.makeText(RegisterActivity.this, "Please enter your last name.", Toast.LENGTH_LONG).show();
                 editTextRegisterLastName.setError("Last name is required.");
                 editTextRegisterLastName.requestFocus();
                errorOccurred = true;

            }  if (TextUtils.isEmpty(textEmail)) {
                 Toast.makeText(RegisterActivity.this, "Please enter your email address.", Toast.LENGTH_LONG).show();
                 editTextRegisterEmail.setError("Email address is required.");
                 editTextRegisterEmail.requestFocus();
                errorOccurred = true;

            }  if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                 Toast.makeText(RegisterActivity.this, "Please re-enter your email address.", Toast.LENGTH_LONG).show();
                 editTextRegisterEmail.setError("Valid email address is required.");
                 editTextRegisterEmail.requestFocus();
                errorOccurred = true;

            }  if (TextUtils.isEmpty(textMobile)) {
                 Toast.makeText(RegisterActivity.this, "Please enter your telephone number.", Toast.LENGTH_LONG).show();
                 editTextRegisterMobile.setError("Telephone number is required.");
                 editTextRegisterMobile.requestFocus();
                errorOccurred = true;

            }  if (textMobile.length()!=10) {
                 Toast.makeText(RegisterActivity.this, "Please re-enter your telephone number.", Toast.LENGTH_LONG).show();
                 editTextRegisterMobile.setError("Valid telephone number is required.");
                 editTextRegisterMobile.requestFocus();
                 errorOccurred = true;

            }  if (TextUtils.isEmpty(textPwd)) {
                 Toast.makeText(RegisterActivity.this, "Please enter your password.", Toast.LENGTH_LONG).show();
                 editTextRegisterPwd.setError("Password is required.");
                 editTextRegisterPwd.requestFocus();
                errorOccurred = true;

            }  if (!PASSWORD_PATTERN.matcher(textPwd).matches()){
                Toast.makeText(RegisterActivity.this, "Your password should have at least 6 characters.", Toast.LENGTH_LONG).show();
                 editTextRegisterPwd.setError("Password too Weak! Be sure to include at least one Lowercase letter, one Uppercase, one Number, one Special character, no Whitespace");
                 editTextRegisterPwd.requestFocus();
                errorOccurred = true;

            }  if (TextUtils.isEmpty(textConfirmPwd)) {
                 Toast.makeText(RegisterActivity.this, "Please enter your password again.", Toast.LENGTH_LONG).show();
                 editTextRegisterConfirmPwd.setError("Password confirmation is required.");
                 editTextRegisterConfirmPwd.requestFocus();
                errorOccurred = true;

            }  if (!textPwd.equals(textConfirmPwd)) {
                 Toast.makeText(RegisterActivity.this, "Please enter the same password.", Toast.LENGTH_LONG).show();
                 editTextRegisterConfirmPwd.setError("Password confirmation is required.");
                 editTextRegisterConfirmPwd.requestFocus();
                 editTextRegisterPwd.clearComposingText();
                 editTextRegisterConfirmPwd.clearComposingText();
                errorOccurred = true;

            }
            if (!errorOccurred) {
//                progressBar.setVisibility(View.VISIBLE);
//                registerUser(textFirstName, textLastName, textEmail, textMobile, textPwd);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
    
//     private void registerUser(String textFirstName, String textLastName, String textEmail, String textMobile, String textPwd) {
//         FirebaseAuth auth = FirebaseAuth.getInstance();
//         auth.createUserWithEmailAndPassword(textEmail, textPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
//             @Override
//             public void onComplete(@NonNull Task<AuthResult> task){
//                 if(task.isSuccessful()){
//                     Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_LONG).show();
//                 }
//             }
//         }
//     }
}