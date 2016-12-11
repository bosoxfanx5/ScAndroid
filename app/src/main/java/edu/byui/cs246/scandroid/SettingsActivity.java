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

import static java.lang.System.exit;

public class SettingsActivity extends AppCompatActivity {

    public String SERVER_SETTINGS = "ServerSettings";
    //public XMLRPCSender updatedVal = new XMLRPCSender();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        try {
            //open shared preference file
            SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);

            //ip
            EditText ipET = (EditText) findViewById(R.id.ipET);
            String ip = settings.getString("IP", "");
            ipET.setText(ip);

            //port
            EditText portET = (EditText) findViewById(R.id.portET);
            String port = settings.getString("Port", "8000");
            portET.setText(port);

            XMLRPCSender updatedVal = XMLRPCSender.getInstance();
            updatedVal.ip = ip;
            updatedVal.port = port;

        } catch (Exception ex2) {
            Log.e("Error:", "Shared Prferences Not Avialable: " + ex2.getMessage());
            exit(0);
        }
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

        XMLRPCSender instance = XMLRPCSender.getInstance();
//        Log.i("InstanceBefore", "IP:"+ instance.ip + "Port:"  + instance.port);
        instance.ip = ip;
        instance.port = port;
//        XMLRPCSender instance2 = XMLRPCSender.getInstance();
//        Log.i("InstanceAfter", "IP:"+ instance2.ip + "Port:"  + instance2.port);
    }

    public String retrieve(String variable) {
        SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);
        return settings.getString(variable, "");
    }
}
