package com.example.navee.minicalculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button addition;
    Button subtraction;
    Button multiplication;
    Button equal;
    EditText firstNumber;
    EditText secondNumber;
    TextView mode;
    Integer result;
    Integer firstNum;
    Integer secondNum;
    String check = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition = findViewById(R.id.additionButton);
        subtraction = findViewById(R.id.subtractionButton);
        multiplication = findViewById(R.id.multiplyButton);
        equal = findViewById(R.id.equalButton);
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);


        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = "+";
                resetButtonColors();
                addition.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = "-";
                resetButtonColors();
                subtraction.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = "*";
                resetButtonColors();
                multiplication.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        setTitle("Calculator");
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((firstNum==null)||(secondNum==null)) {
                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_SHORT).show();
                    return;
                }
                firstNum = Integer.parseInt(firstNumber.getText().toString());
                secondNum = Integer.parseInt(secondNumber.getText().toString());

                switch (check) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("check", check);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
        }


    private void resetButtonColors () {
        subtraction.setBackgroundColor(getResources().getColor(R.color.colorGray));
        addition.setBackgroundColor(getResources().getColor(R.color.colorGray));
        multiplication.setBackgroundColor(getResources().getColor(R.color.colorGray));
    }
}
