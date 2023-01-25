package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.TestOnly;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);


        Log.i("Api Response", "Retrieved orders from Api");
//        try {
//            whenGetRequest_thenCorrect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


//    @TestOnly
//    public void whenGetRequest_thenCorrect() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .header("Token", "63ZhgHoqG8DDBVgwJnN7")
//                .url("https://pasd-webshop-api.onrender.com/api/openapi.json" + "/date")
//                .build();
//
//        final Response[] response = {null};
//        new Thread() {
//            public void run() {
//                Call call = client.newCall(request);
//                Thread thread = new Thread();
//                try {
//                    response[0] = call.execute();
//                    Log.e("Response", response[0].toString());
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }.start();

//        assert response[0].code() == 200;
}
