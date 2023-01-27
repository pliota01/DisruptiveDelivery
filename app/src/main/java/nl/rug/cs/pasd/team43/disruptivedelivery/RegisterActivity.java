package nl.rug.cs.pasd.team43.disruptivedelivery;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.UserInfo;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%_^&+=])(?=\\S+$).{8,}$");

    private FirebaseAuth mAuth;

    private EditText etRegisterFirstName,
            etRegisterLastName,
            etRegisterEmail,
            etRegisterMobile,
            etRegisterPassword,
            etRegisterConfirmPassword,
            etRegisterStreetAndNumber,
            etRegisterZipcode,
            etRegisterCity,
            etRegisterCountry;
//    private ProgressBar progressBar;


    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    UserInfo userInfo;


    private CheckBox cbAgreeToTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        etRegisterFirstName = findViewById(R.id.et_first_name);
        etRegisterLastName = findViewById(R.id.et_last_name);
        etRegisterEmail = findViewById(R.id.et_email);
        etRegisterMobile = findViewById(R.id.et_phone_number);
        etRegisterPassword = findViewById(R.id.et_password);
        etRegisterConfirmPassword = findViewById(R.id.et_confirm_password);

        ConstraintLayout cl = findViewById(R.id.register_address_form);
        etRegisterStreetAndNumber = cl.findViewById(R.id.et_street_and_number);
        etRegisterZipcode = cl.findViewById(R.id.et_zipcode);
        etRegisterCity = cl.findViewById(R.id.et_city);
        etRegisterCountry = cl.findViewById(R.id.et_country);

        Button buttonRegister = findViewById(R.id.btn_register);
        cbAgreeToTerms = findViewById(R.id.cb_register_agree_terms);
        buttonRegister.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        // below line is used to get the
        // instance of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("UserInfo");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_register) {
            String firstNameText = etRegisterFirstName.getText().toString();
            String lastNameText = etRegisterLastName.getText().toString();
            String emailText = etRegisterEmail.getText().toString();
            String phoneNumberText = etRegisterMobile.getText().toString();
            String passwordText = etRegisterPassword.getText().toString();
            String confirmPasswordText = etRegisterConfirmPassword.getText().toString();
            String streetAndNumberText = etRegisterStreetAndNumber.getText().toString();
            String zipcodeText = etRegisterZipcode.getText().toString();
            String cityText = etRegisterCity.getText().toString();
            String countryText = etRegisterCountry.getText().toString();

            if (!errorOccurred(firstNameText, lastNameText, emailText,
                    passwordText, confirmPasswordText, phoneNumberText)) {

                saveLocalData(firstNameText, lastNameText,
                        streetAndNumberText, zipcodeText, cityText, countryText,
                        emailText, phoneNumberText);

//                registerUserInFirebase(firstNameText,
//                        lastNameText,
//                        emailText,
//                        passwordText,
//                        phoneNumberText,
//                        streetAndNumberText,
//                        zipcodeText,
//                        cityText,
//                        countryText);

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }
    }


    private void registerUserInFirebase(String firstNameText,
                                        String lastNameText,
                                        String emailText,
                                        String passwordText,
                                        String phoneNumberText,
                                        String streetAndNumberText,
                                        String zipcodeText,
                                        String cityText,
                                        String countryText) {

        mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");

//                            boolean success = addUserDataToFirebase(firstNameText, lastNameText,
//                                    streetAndNumberText, zipcodeText, cityText, countryText,
//                                    emailText, phoneNumberText);
//                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
//                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, "Storing Data failed. Please try again",
                                        Toast.LENGTH_SHORT).show();
//                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed. Please try again",
                                    Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                        }
                    }
                });
    }

    private boolean errorOccurred(String firstNameText,
                                  String lastNameText,
                                  String emailText,
                                  String passwordText,
                                  String confirmPasswordText,
                                  String phoneNumberText) {
        boolean errorOccurred = false;


        if (TextUtils.isEmpty(firstNameText)) {
            Toast.makeText(RegisterActivity.this, "Please enter your first name.", Toast.LENGTH_LONG).show();
            etRegisterFirstName.setError("First name is required.");
            etRegisterFirstName.requestFocus();
            errorOccurred = true;
        } else if (TextUtils.isEmpty(lastNameText)) {
            Toast.makeText(RegisterActivity.this, "Please enter your last name.", Toast.LENGTH_LONG).show();
            etRegisterLastName.setError("Last name is required.");
            etRegisterLastName.requestFocus();
            errorOccurred = true;

        } else if (TextUtils.isEmpty(emailText)) {
            Toast.makeText(RegisterActivity.this, "Please enter your email address.", Toast.LENGTH_LONG).show();
            etRegisterEmail.setError("Email address is required.");
            etRegisterEmail.requestFocus();
            errorOccurred = true;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            Toast.makeText(RegisterActivity.this, "Please re-enter your email address.", Toast.LENGTH_LONG).show();
            etRegisterEmail.setError("Valid email address is required.");
            etRegisterEmail.requestFocus();
            errorOccurred = true;

        } else if (TextUtils.isEmpty(phoneNumberText)) {
            Toast.makeText(RegisterActivity.this, "Please enter your telephone number.", Toast.LENGTH_LONG).show();
            etRegisterMobile.setError("Telephone number is required.");
            etRegisterMobile.requestFocus();
            errorOccurred = true;

        } else if (phoneNumberText.length() != 10) {
            Toast.makeText(RegisterActivity.this, "Please re-enter your telephone number.", Toast.LENGTH_LONG).show();
            etRegisterMobile.setError("Valid telephone number is required.");
            etRegisterMobile.requestFocus();
            errorOccurred = true;

        } else if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(RegisterActivity.this, "Please enter your password.", Toast.LENGTH_LONG).show();
            etRegisterPassword.setError("Password is required.");
            etRegisterPassword.requestFocus();
            errorOccurred = true;

        } else if (!PASSWORD_PATTERN.matcher(passwordText).matches()) {
            Toast.makeText(RegisterActivity.this, "Your password should have at least 6 characters.", Toast.LENGTH_LONG).show();
            etRegisterPassword.setError("Password too Weak! Be sure to include at least one Lowercase letter, one Uppercase, one Number, one Special character, no Whitespace");
            etRegisterPassword.requestFocus();
            errorOccurred = true;

        } else if (TextUtils.isEmpty(confirmPasswordText)) {
            Toast.makeText(RegisterActivity.this, "Please enter your password again.", Toast.LENGTH_LONG).show();
            etRegisterConfirmPassword.setError("Password confirmation is required.");
            etRegisterConfirmPassword.requestFocus();
            errorOccurred = true;

        } else if (!passwordText.equals(confirmPasswordText)) {
            Toast.makeText(RegisterActivity.this, "Please enter the same password.", Toast.LENGTH_LONG).show();
            etRegisterConfirmPassword.setError("Password confirmation is required.");
            etRegisterConfirmPassword.requestFocus();
            etRegisterPassword.clearComposingText();
            etRegisterConfirmPassword.clearComposingText();
            errorOccurred = true;
        } else if (!cbAgreeToTerms.isChecked()) {
            Toast.makeText(RegisterActivity.this, "Please agree to our Term and Conditions", Toast.LENGTH_LONG).show();
            errorOccurred = true;
        }


        return errorOccurred;
    }


    private void saveLocalData(String fName,
                               String lName,
                               String streetAndNum,
                               String zipcode,
                               String city,
                               String country,
                               String email, String phoneNumberText) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_profile), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.preference_first_name), fName);
        editor.putString(getString(R.string.preference_last_name), lName);
        editor.putString(getString(R.string.preference_email), email);
//                editor.putString("Password", passwordText);
        editor.putString(getString(R.string.preference_phone_number), phoneNumberText);

        if (!streetAndNum.isEmpty() && !zipcode.isEmpty() && !city.isEmpty() && !country.isEmpty()) {
            editor.putString(getString(R.string.preference_street_and_number), streetAndNum);
            editor.putString(getString(R.string.preference_zipcode), zipcode);
            editor.putString(getString(R.string.preference_city), city);
            editor.putString(getString(R.string.preference_country), country);
        }
        editor.apply();
    }

    private boolean addUserDataToFirebase(String fName,
                                       String lName,
                                       String streetAndNum,
                                       String zipcode,
                                       String city,
                                       String country,
                                       String email, String phoneNumberText) {
        AtomicBoolean success = new AtomicBoolean(false);

        userInfo = new UserInfo(fName, lName, streetAndNum, zipcode, city, country, email, phoneNumberText);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                FirebaseUser user = mAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(userInfo).addOnCompleteListener(task -> {
                    user.sendEmailVerification();
                    Toast.makeText(RegisterActivity.this, "User Data Stored", Toast.LENGTH_SHORT).show();
                    success.set(true);
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(RegisterActivity.this, "Failed to Store User Data" + error, Toast.LENGTH_SHORT).show();
                success.set(false);
            }
        });
        return success.get();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}