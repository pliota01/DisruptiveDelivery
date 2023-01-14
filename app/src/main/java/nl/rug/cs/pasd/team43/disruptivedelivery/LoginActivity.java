package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

    private TextView forgotPasswordTV;
    private TextView dontHaveAccountTV;
    private Button logInBtn;
    private TextInputLayout emailError, passwordError;
    private EditText email, password;
    private boolean isEmailValid, isPasswordValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        logInBtn = findViewById(R.id.loginButton);
        forgotPasswordTV = findViewById(R.id.forgotPasswordTextView);
        dontHaveAccountTV = findViewById(R.id.dontHaveAccountTextView);
        email = findViewById(R.id.loginEmailEditText);
        password = findViewById(R.id.loginPasswordEditText);
        emailError = findViewById(R.id.loginEmailError);
        passwordError = findViewById(R.id.loginPasswordError);

        logInBtn.setOnClickListener(this);
        forgotPasswordTV.setOnClickListener(this);
        dontHaveAccountTV.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}