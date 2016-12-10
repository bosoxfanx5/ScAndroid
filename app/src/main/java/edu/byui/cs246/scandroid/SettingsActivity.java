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

//this activity controls all settings changes
public class SettingsActivity extends AppCompatActivity {

    //string to point to preference file
    public String SERVER_SETTINGS = "ServerSettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        try {
            //open shared preference file - LOCAL TO ACTIVITY!!
            SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);

            //ip
            EditText ipET = (EditText) findViewById(R.id.ipET);
            String ip = settings.getString("IP", "");
            ipET.setText(ip);

            //port
            EditText portET = (EditText) findViewById(R.id.portET);
            String port = settings.getString("Port", "8000");
            portET.setText(port);

        } catch (Exception ex2) {
            Log.e("Error:", "Shared Prferences Not Avialable: " + ex2.getMessage());
            exit(0);
        }
    }

    //create intent to move back to the MTA
    public void closeSettings(View view) {
        Intent intent = new Intent(SettingsActivity.this, MultiTrackerActivity.class);
        startActivity(intent);
    }

    //save all settings in the activity to a shared prference file
    public void saveSettings(View view) {
        //retrieve values from the UI
        EditText ipET = (EditText) findViewById(R.id.ipET);
        String ip = ipET.getText().toString();
        EditText portET = (EditText) findViewById(R.id.portET);
        String port = portET.getText().toString();

        //Open sever settings file
        SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);
        SharedPreferences.Editor editor = settings.edit(); //editor used to modify values
        editor.putString("IP", ip);     //set ip
        editor.putString("Port", port); //set port

        //commit changes made to the stored variables
        editor.commit();
    }

    //outward facing getter to expose any settings stuck in the activities preferences
    public String retrieve(String variable) {
        SharedPreferences settings = getSharedPreferences(SERVER_SETTINGS, 0);
        return settings.getString(variable, "");
    }
}
