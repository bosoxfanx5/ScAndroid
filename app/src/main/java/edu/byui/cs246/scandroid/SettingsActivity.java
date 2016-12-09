package edu.byui.cs246.scandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.samples.vision.face.multitracker.MultiTrackerActivity;
import com.google.android.gms.samples.vision.face.multitracker.R;

public class SettingsActivity extends AppCompatActivity {

    public String SERVER_SETTINGS = "ServerSettings";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);

        EditText ipET = (EditText) findViewById(R.id.ipET);
        String ip = settings.getString("IP", "");
        ipET.setText(ip);


        EditText portET = (EditText) findViewById(R.id.portET);
        String port = settings.getString("Port", "8000");
        portET.setText(port);
    }

    public void closeSettings(View view) {
        Intent intent = new Intent(SettingsActivity.this, MultiTrackerActivity.class);
        startActivity(intent);
    }

    public void saveSettings(View view) {
        EditText ipET = (EditText) findViewById(R.id.ipET);
        String ip = ipET.getText().toString();
        EditText portET = (EditText) findViewById(R.id.portET);
        String port = portET.getText().toString();

        SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("IP", ip);
        editor.putString("Port", port);

        Log.i("Info", "Info log on SeverSettings");

        editor.commit();
    }
}
