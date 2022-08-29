package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    String operation;
    Boolean onOperationClick;
    Double first,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                if (textview.getText().toString().equals("0")) {
                    textview.setText("0");
                } else {
                    textview.append("0");
                }
                break;
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_point:
                if (!textview.getText().toString().contains(".")) {
                    textview.append(".");
                }
                break;
            case R.id.btn_clear:
                textview.setText("0");
                first = 0.0;
                two = 0.0;
                break;
        }

    }
    private void setNumber(String number) {
        if (textview.getText().toString().equals("0")) {
            textview.setText(number);
        } else if (onOperationClick) {
            textview.setText(number);
        } else {
            textview.append(number);
        }
        onOperationClick = false;
    }
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                operation = "+";
                first = Double.parseDouble(textview.getText().toString());
                onOperationClick = true;
                break;
            case R.id.btn_minus:
                operation = "-";
                first = Double.parseDouble(textview.getText().toString());
                onOperationClick = true;
                break;
            case R.id.btn_multiplication:
                operation = "*";
                first = Double.parseDouble(textview.getText().toString());
                onOperationClick = true;
                break;
            case R.id.btn_division:
                operation = "/";
                first = Double.parseDouble(textview.getText().toString());
                onOperationClick = true;
                break;
            case R.id.btn_percent:
                operation = "/";
                first = Double.parseDouble(textview.getText().toString());
                Double resullt = Double.valueOf(0);
                onOperationClick = true;
                switch (operation) {
                    case "/":
                        resullt = first / 100;
                        break;
                }
                textview.setText(new DecimalFormat("##.#######").format(resullt));
                break;
            case R.id.btn_plus_or_minus:
                operation = "+/-";
                first = Double.parseDouble(textview.getText().toString());
                Double resultS = Double.valueOf(0);
                onOperationClick = true;
                switch (operation) {
                    case "+/-":
                        resultS = first *= -1;
                        break;
                }
                textview.setText(new DecimalFormat("##.#######").format(resultS));
                break;
            case R.id.btn_equal:
                two = Double.parseDouble(textview.getText().toString());
                Double result = Double.valueOf(0);
                switch (operation) {
                    case "+":
                        result = first + two;
                        break;
                    case "-":
                        result = first - two;
                        break;
                    case "x":
                        result = first * two;
                        break;
                    case "/":
                        result = first / two;
                        break;
                    case "//":
                        result = first / 100;
                        break;
                }
                textview.setText(new DecimalFormat("##.#######").format(result));
                onOperationClick = true;
                break;
        }
    }

}