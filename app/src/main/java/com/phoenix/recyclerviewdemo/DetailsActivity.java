package com.phoenix.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            ((TextView)findViewById(R.id.dTitle)).setText(extras.getString("name"));
            ((TextView)findViewById(R.id.dDescription)).setText(extras.getString("description"));
        }
    }
}
