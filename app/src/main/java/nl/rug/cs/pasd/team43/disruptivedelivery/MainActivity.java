package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendPackage = (Button) findViewById(R.id.btn_send_package);
        btnSendPackage.setOnClickListener(this);
        Button btnTrackPackage = (Button) findViewById(R.id.btn_track_package);
        btnTrackPackage.setOnClickListener(this);

//        TODO Check if user is a delivery driver and if so add more stuff like the maps and
//         also see where there have been requests for package pickups

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_send_package) {
            Intent intent = new Intent(this, SendPackageActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_track_package) {
            Intent intent = new Intent(this, TrackPackageActivity.class);
            startActivity(intent);
        }

    }
}