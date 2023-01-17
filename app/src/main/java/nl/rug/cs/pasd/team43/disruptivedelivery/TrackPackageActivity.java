package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.PackageInfo;

public class TrackPackageActivity extends AppCompatActivity {

    private String[] StatusArray = {"EXP", "REJ", "RFP", "TRN", "DEL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_package);
    }

    private PackageInfo getPackage() {
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
}