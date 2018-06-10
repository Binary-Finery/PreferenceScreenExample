package spencerstudios.com.preferencescreenexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, PreferenceScreen.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buttonClick(View view) {

        int id = view.getId();

        String string = "";

        if (id == R.id.btn_one) {
            boolean isWafi = sharedPreferences.getBoolean("i_am_wafi", false);
            string = isWafi ? "it's you, Wafi" : "so, where's Wafi?";

        } else if (id == R.id.btn_two){
            boolean isGay = sharedPreferences.getBoolean("likes_bobs_and_vagene", false);
            string = isGay ? "your choice dude" : "you like pussy, great bro!";
        }
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_LONG).show();
    }
}
