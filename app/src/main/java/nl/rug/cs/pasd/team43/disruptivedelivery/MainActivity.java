package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MenuProvider {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_profile), MODE_PRIVATE);
        if (!sharedPreferences.contains(getString(R.string.preference_first_name))) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendPackage = (Button) findViewById(R.id.btn_send_package);
        btnSendPackage.setOnClickListener(this);
        Button btnTrackPackage = (Button) findViewById(R.id.btn_track_package);
        btnTrackPackage.setOnClickListener(this);

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


//        TODO Check if user is a delivery driver and if so add more stuff like the maps and
//         also see where there have been requests for package pickups

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_send_package) {
            Intent intent = new Intent(MainActivity.this, SendPackageActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_track_package) {
            Intent intent = new Intent(MainActivity.this, TrackPackageActivity.class);
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
//            Toast.makeText(MainActivity.this, "Info Selected", Toast.LENGTH_SHORT).show();
            Log.i("MainActivity", "ActionBar Information Clicked");
            InformationFragment infoFragment = new InformationFragment();
            onCreateMenu(toolbar.getMenu(), getMenuInflater());
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main, infoFragment).addToBackStack(getString(R.string.fragment_tag_info)).commit();
            return true;
        }
        if (id == R.id.item_profile) {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            Log.i("MainActivity", "ActionBar Profile Clicked");
            ProfileFragment profileFragment = new ProfileFragment();
            onCreateMenu(toolbar.getMenu(), getMenuInflater());
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main, profileFragment).addToBackStack(getString(R.string.fragment_tag_profile)).commit();
            return true;
        }
        if (id == R.id.item_settings) {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            Log.i("MainActivity", "ActionBar Settings Clicked");
            SettingsFragment settingsFragment = new SettingsFragment();
            onCreateMenu(toolbar.getMenu(), getMenuInflater());
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main, settingsFragment).addToBackStack(getString(R.string.fragment_tag_settings)).commit();
            return true;
        }
        if (id == R.id.item_log_out) {
            // Delete all local data and go to log in activity

            Log.i("MainActivity", "ActionBar Log Out Clicked");
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_profile), MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
//            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        MenuItem info = menu.findItem(R.id.item_info);
        info.setVisible(!info.isVisible());
        MenuItem profile = menu.findItem(R.id.item_profile);
        profile.setVisible(!profile.isVisible());
        MenuItem settings = menu.findItem(R.id.item_settings);
        settings.setVisible(!settings.isVisible());
        MenuItem logout = menu.findItem(R.id.item_log_out);
        logout.setVisible(!logout.isVisible());
        if (toolbar.getNavigationIcon() == null) {
            Log.i("MainActivity", "onCreateMenu: Add back button on ActionBar");
            toolbar.setNavigationIcon(R.drawable.baseline_arrow_back);
            toolbar.setNavigationOnClickListener(view -> onBackPressed());
        } else {
            Log.i("MainActivity", "onCreateMenu: Remove back button from ActionBar");
            toolbar.setNavigationIcon(null);
        }

    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        return onOptionsItemSelected(menuItem);
    }


    @Override
    public void onBackPressed() {
        Fragment infoFrag = getSupportFragmentManager().findFragmentByTag(getString(R.string.fragment_tag_info));
        Fragment profileFrag = getSupportFragmentManager().findFragmentByTag(getString(R.string.fragment_tag_profile));
        Fragment settingsFrag = getSupportFragmentManager().findFragmentByTag(getString(R.string.fragment_tag_settings));

        if (!(infoFrag != null && infoFrag.isVisible() && profileFrag != null
                && profileFrag.isVisible() && settingsFrag != null && settingsFrag.isVisible())) {
            onCreateMenu(toolbar.getMenu(), getMenuInflater());
        }
        super.onBackPressed();
    }
}