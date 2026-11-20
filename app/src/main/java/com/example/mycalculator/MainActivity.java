package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Button
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    // Edit text
    EditText editTextN1, editTextN2;
    TextView textView;

    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize objects
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        // Add to onClick Listeners
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    // Helper function for parsing from string to int
    public int getIntFromText(EditText editText){
        // Check if empty
        if (editText.getText().toString().isEmpty()){
            // If yes then show "Enter Number" message
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        else{
            // Otherwise store the value
            return Integer.parseInt(editText.getText().toString());
        }
    }

    // When the buttons are pressed this function is called
    @Override
    public void onClick(View view) {
        num1 = getIntFromText(editTextN1);
        num2 = getIntFromText(editTextN2);
        int id = view.getId();
        if (id == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (id == R.id.btn_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (id == R.id.btn_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (id == R.id.btn_div) {
            if (num1 == 0 && num2 == 0) {
                textView.setText("Answer = ∞");
            } else if (num2 == 0) {
                textView.setText("Answer = ∞");
            } else if (num1 == 0){
                textView.setText("Answer = 0");
            }
                else {
                textView.setText("Answer = " + ((float) num1 / (float) num2));
            }
        }

    }
}