package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.Order;

public class TrackPackageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTrackPackage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_package);
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

    protected String returnStatus(String[] StatusArray) {
//        Random rand = new Random();
//        int upperbound = 4;
//        int int_random = rand.nextInt(upperbound);
//        for (int i = 0; i < 4; i++) {
//            if (i == int_random) {
//                return StatusArray[i];
//            }
//        }
        return StatusArray[0];
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_track_package) {

        }

         //Intent intent = new Intent(this, MainActivity.class);
         //startActivity(intent);
    }
}