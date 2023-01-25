package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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

//
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
                } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
                    tilPassword.setError("Password is required.");
                    etPassword.requestFocus();
                } else {
                    // Check if user exists in database
                    if (isUserInDatabase()) {
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "No such user Exists", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    private boolean isUserInDatabase() {
        return false;
    }

}