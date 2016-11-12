package com.example.gyleodhis.pikachapchap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChoose = (Button)findViewById(R.id.btn_choose);

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start details activity
                Intent myIntent = new Intent(MainActivity.this, Details.class);
                startActivity(myIntent);
            }
        });
    }
}
