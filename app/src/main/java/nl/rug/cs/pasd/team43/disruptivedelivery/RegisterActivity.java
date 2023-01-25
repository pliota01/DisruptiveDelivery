package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%_^&+=])(?=\\S+$).{8,}$");

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

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_register) {
            String firstNameText = etRegisterFirstName.getText().toString();
            String lastNameText = etRegisterLastName.getText().toString();
            String emailText = etRegisterEmail.getText().toString();
            String phoneNumberText = etRegisterMobile.getText().toString();
            String textPwd = etRegisterPassword.getText().toString();
            String textConfirmPwd = etRegisterConfirmPassword.getText().toString();

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

            } else if (TextUtils.isEmpty(textPwd)) {
                Toast.makeText(RegisterActivity.this, "Please enter your password.", Toast.LENGTH_LONG).show();
                etRegisterPassword.setError("Password is required.");
                etRegisterPassword.requestFocus();
                errorOccurred = true;

            } else if (!PASSWORD_PATTERN.matcher(textPwd).matches()) {
                Toast.makeText(RegisterActivity.this, "Your password should have at least 6 characters.", Toast.LENGTH_LONG).show();
                etRegisterPassword.setError("Password too Weak! Be sure to include at least one Lowercase letter, one Uppercase, one Number, one Special character, no Whitespace");
                etRegisterPassword.requestFocus();
                errorOccurred = true;

            } else if (TextUtils.isEmpty(textConfirmPwd)) {
                Toast.makeText(RegisterActivity.this, "Please enter your password again.", Toast.LENGTH_LONG).show();
                etRegisterConfirmPassword.setError("Password confirmation is required.");
                etRegisterConfirmPassword.requestFocus();
                errorOccurred = true;

            } else if (!textPwd.equals(textConfirmPwd)) {
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
            if (!errorOccurred) {
//                progressBar.setVisibility(View.VISIBLE);
//                registerUser(firstNameText, lastNameText, emailText, phoneNumberText, textPwd);

                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_profile), MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.preference_first_name), firstNameText);
                editor.putString(getString(R.string.preference_last_name), lastNameText);
                editor.putString(getString(R.string.preference_email), emailText);
//                editor.putString("Password", textPwd);
                editor.putString(getString(R.string.preference_phone_number), phoneNumberText);

                String streetAndNumberText = etRegisterStreetAndNumber.getText().toString();
                String zipcodeText = etRegisterZipcode.getText().toString();
                String cityText = etRegisterCity.getText().toString();
                String countryText = etRegisterCountry.getText().toString();

                if (!streetAndNumberText.isEmpty() && !zipcodeText.isEmpty() && !cityText.isEmpty() && !countryText.isEmpty()){
                    editor.putString(getString(R.string.preference_street_and_number), streetAndNumberText);
                    editor.putString(getString(R.string.preference_zipcode), zipcodeText);
                    editor.putString(getString(R.string.preference_city), cityText);
                    editor.putString(getString(R.string.preference_country), countryText);
                }
                editor.apply();

                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
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