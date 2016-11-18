package edu.byui.cs246.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAdvanceClick(View view) {
        TextView t = (TextView) view.findViewById(R.id.textView);
        t.setText(Integer.toString(++count));
    }

    public void onSaveCountClick(View view) {

    }
}
