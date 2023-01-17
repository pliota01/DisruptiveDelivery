package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvForgotPassword;
    private TextView tvDontHaveAccount;
    private Button logInBtn;

    private TextInputLayout tilEmail, tilPassword;
    private EditText etEmail, etPassword;
    private boolean isEmailValid, isPasswordValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        logInBtn = findViewById(R.id.loginButton);
        tvForgotPassword = findViewById(R.id.forgotPasswordTextView);
        tvDontHaveAccount = findViewById(R.id.dontHaveAccountTextView);
        etEmail = findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_login_password);
        tilEmail = findViewById(R.id.til_login_email);
        tilPassword = findViewById(R.id.til_login_password);

        logInBtn.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        tvDontHaveAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dontHaveAccountTextView) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
        if (id == R.id.loginButton) {
             if (TextUtils.isEmpty(etEmail.getText().toString())) {
                 Toast.makeText(LoginActivity.this, "Please enter your email address.", Toast.LENGTH_LONG).show();
                 tilEmail.setError("Email address is required.");
                 etEmail.requestFocus();
             } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
                 Toast.makeText(LoginActivity.this, "Please re-enter your email address.", Toast.LENGTH_LONG).show();
                 tilEmail.setError("Valid email address is required.");
                 etEmail.requestFocus();
             }  else if (TextUtils.isEmpty(etPassword.getText().toString())) {
                 Toast.makeText(LoginActivity.this, "Please enter your password.", Toast.LENGTH_LONG).show();
                 tilPassword.setError("Password is required.");
                 etPassword.requestFocus();
             } else {
                 Intent intent = new Intent(this, MainActivity.class);
                 startActivity(intent);
             }
        }
    }

}