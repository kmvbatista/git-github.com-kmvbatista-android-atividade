package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    String name;
    Double weight, height;
    TextView textViewName, textViewWheights, textViewHeight, textViewImc, imcResult;
    DecimalFormat df = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        weight = bundle.getDouble("weight");
        height = bundle.getDouble("height");

        textViewName = findViewById(R.id.nameText);
        textViewWheights = findViewById(R.id.weightText);
        textViewHeight = findViewById(R.id.heightText);
        textViewImc = findViewById(R.id.textIMC);
        imcResult = findViewById(R.id.imcResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textViewName.setText(name);
        textViewWheights.setText(weight.toString());
        textViewHeight.setText(height.toString());
        handleImcResult();
    }

    private void handleImcResult() {
        Double imc = getImc(weight, height);
        textViewImc.setText(df.format(imc));
        imcResult.setText(getResultText(imc));
    }

    private String getResultText(Double imc) {
        if(imc < 18.5)
            return "Abaixo do peso";
        if(imc < 24.9)
            return "Peso ideal";
        if(imc < 29.9)
            return "Levemente acima do peso";
        if(imc < 34.9)
            return "Obesidade grau I";
        if(imc < 39.9)
            return "Obesidade grau II (severa)";
        return "Obesidade grau III (mórbida)";
    }

    private Double getImc(Double weight, Double height){
        Double imc = weight / (height*height);
        return imc;
    }
}

