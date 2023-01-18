package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.Order;
import nl.rug.cs.pasd.team43.disruptivedelivery.model.Status;

public class TrackPackageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTrackPackage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_package);

        Button btnTrackPackage = findViewById(R.id.btn_track_package);
        btnTrackPackage.setOnClickListener(this);
    }

    private Order getOrder() {
//        expected_deliver_datetime	Expected Deliver Datetime[...]
//        actual_deliver_datetime	Actual Deliver Datetime[...]
//        order_id*	integer
//        title: Order Id
//        cost_in_cents*	Cost In Cents[...]
//        status	Status[...]
//        id*	integer
        return null;
    }

    protected String returnStatus() {
        Random rand = new Random();
        int upperbound = 4;
        int int_random = rand.nextInt(upperbound);
        return Status.values()[int_random].toString();

    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_track_package) {
            TextView tv = findViewById(R.id.tv_package_status);
            // If code in database
            tv.setText(returnStatus());
            tv.setVisibility(View.VISIBLE);
        }

         //Intent intent = new Intent(this, MainActivity.class);
         //startActivity(intent);
    }
}