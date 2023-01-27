package nl.rug.cs.pasd.team43.disruptivedelivery;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private TextView tvForgotPassword;
    private TextView tvDontHaveAccount;
    private Button logInBtn;

    private TextInputLayout tilEmail, tilPassword;
    private EditText etEmail, etPassword;


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

//        mAuth = FirebaseAuth.getInstance();


//        TextView tvOkHttp = findViewById(R.id.tv_okhttp_results);

//        OkHttpClient client = new OkHttpClient();
////        String url = "https://reqres.in/api/users?page=2";
//        String url = "https://pasd-webshop-api.onrender.com/docs#/orders/orders_get_api_order__get";
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    final String myResponse = response.body().string();
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            tvOkHttp.setText(myResponse);
//                        }
//                    });
//                }
//            }
//        });

//        try {
//            String response = getResponseFromHttpUrl();
//            TextView tvOkHttp = findViewById(R.id.tv_okhttp_results);
//            tvOkHttp.setText(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    /**
//     * Gets the response from http Url request
//     * @return
//     * @throws IOException
//     */
//    public static String getResponseFromHttpUrl() throws IOException {
//
//        URL url = new URL("https://pasd-webshop-api.onrender.com/api/order/");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.addRequestProperty("Accept","application/json");
//        connection.addRequestProperty("Content-Type","application/json");
//        connection.addRequestProperty("Authorization","63ZhgHoqG8DDBVgwJnN7");
//
//        try {
//            InputStream in = connection.getInputStream();
//
//            Scanner scanner = new Scanner(in);
//            scanner.useDelimiter("\\A");
//
//            boolean hasInput = scanner.hasNext();
//            if (hasInput) {
//                return scanner.next();
//            } else {
//                return null;
//            }
//        } finally {
//            connection.disconnect();
//        }
//    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dontHaveAccountTextView) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
        if (id == R.id.loginButton) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            if (email.matches("employee@dd.com")) {
                Intent intent = new Intent(this, EmployeeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } else {
                if (TextUtils.isEmpty(email)) {
                    tilEmail.setError("Email address is required.");
                    etEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    tilEmail.setError("Valid email address is required.");
                    etEmail.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    tilPassword.setError("Password is required.");
                    etPassword.requestFocus();
                } else {
//                    mAuth.signInWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Sign in success, update UI with the signed-in user's information
//                                        Log.d(TAG, "signInWithEmail:success");
//                                        FirebaseUser user = mAuth.getCurrentUser();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
//                                    } else {
//                                        // If sign in fails, display a message to the user.
//                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
//                                        Toast.makeText(LoginActivity.this, "Authentication failed. Please try again",
//                                                Toast.LENGTH_SHORT).show();
////                            updateUI(null);
//                                    }
//                                }
//                            });
                }
            }
        }
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            reload();
//        }
//    }

//    private void reload() {
//        // User is already signed in so go to Main
//        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//    }

}