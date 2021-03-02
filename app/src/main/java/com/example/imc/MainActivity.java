package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nameTextField, weightTextField, heightTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextField = findViewById(R.id.name);
        weightTextField = findViewById(R.id.weight);
        heightTextField = findViewById(R.id.height);
    }

    public void calculateImc(View v){
        Intent i = new Intent(this, ImcActivity.class);

        String name = nameTextField.getText().toString();
        Double weight = Double.parseDouble(weightTextField.getText().toString());
        Double height = Double.parseDouble(heightTextField.getText().toString());

        i.putExtra("name", name);
        i.putExtra("weight", weight);
        i.putExtra("height", height);
        startActivity(i);
    }
}


