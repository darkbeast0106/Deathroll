package com.darkbeast0106.deathroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rollButton;
    EditText rollNumber;
    TextView rollResult;
    String resultText;
    Random rnJesus;
    int rollCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollInputText = rollNumber.getText().toString();
                if (rollInputText.trim().isEmpty()){
                    return;
                }
                int rollLimit = Integer.parseInt(rollInputText);
                if (rollLimit < 2){
                    return;
                }
                int roll = rnJesus.nextInt(rollLimit)+1;
                rollCount++;
                if (!resultText.equals("")){
                    resultText += "\n";
                }
                resultText += rollCount+".  "+roll;
                if (roll == 1){
                    resultText += "\n________________";
                }
                rollResult.setText(resultText);
                rollNumber.setText(roll+"");
            }
        });
    }

    private void init() {
        rollButton = findViewById(R.id.rollButton);
        rollNumber = findViewById(R.id.rollNumber);
        rollResult = findViewById(R.id.rollResult);
        resultText = "";
        rnJesus = new Random();
        rollCount = 0;
    }
}
