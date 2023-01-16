package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_info) {
            // User chose the "Settings" item, show the app settings UI...
            Toast.makeText(MainActivity.this, "Info Selected", Toast.LENGTH_SHORT).show();
            InformationFragment infoFragment = new InformationFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main, infoFragment).addToBackStack("InfoFragment").commit();
            return true;
        }
        if (id == R.id.item_profile) {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.item_settings) {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            Toast.makeText(MainActivity.this, "Settings Selected", Toast.LENGTH_SHORT).show();
           return true;
        }
        if (id == R.id.item_log_out) {
            // Delete all local data and go to log in activity

            Toast.makeText(MainActivity.this, "Log Out Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}