package com.example.navee.minicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTextView = findViewById(R.id.resultTextView);
        Bundle extras =getIntent().getExtras();

        String resultCheck = extras.getString("check");
        String result = extras.get("result").toString();

        switch (resultCheck) {
            case "+":
                resultTextView.setText("addition is:" + result);
                break;
            case "-":
                resultTextView.setText("subtraction is:" + result);
                break;
            case "*":

                resultTextView.setText("multiplication is:" + result);
                break;
        }
    }
}
