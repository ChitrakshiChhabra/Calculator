package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private Button all_clear, clear;
    private Button percent, division , multiply, minus, plus, equal;
    private Button one, two, three,four, five,six;
    private Button seven, eight, nine, zero, dot;
    private String removeLastChar(String s)
    {
    //returns the string after removing the last character
        return s.substring(0, s.length() - 1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.answer);
        all_clear = findViewById(R.id.AC);
        clear = findViewById(R.id.C);
        percent = findViewById(R.id.percent);
        division = findViewById(R.id.division);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        equal = findViewById(R.id.equal);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zeroes);
        dot = findViewById(R.id.point);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                screen.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("0");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append(".");
            }
        });

        all_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String old = screen.getText().toString();
                old = removeLastChar(old);
                screen.setText(old);
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("%");
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("÷");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("×");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("-");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.append("+");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputs = (String) screen.getText().toString();
                if (inputs.isEmpty())
                    Toast.makeText(MainActivity.this, "Nothing to evaluate", Toast.LENGTH_SHORT).show();
                else
                {
                    char operation = 0;
                    String num1 = "", num2 = "";
                    boolean first = true;
                    for(int i = 0; i < inputs.length(); i++)
                   {

                       if(inputs.charAt(i) == '+'|| inputs.charAt(i) == '÷'|| inputs.charAt(i) == '×'|| inputs.charAt(i) == '-'|| inputs.charAt(i) == '%'){
                           operation = inputs.charAt(i);
                           first = false;
                           continue;
                       }

                       if (first){
                           num1+= inputs.charAt(i);
                           continue;
                       }
                       else{
                           num2+= inputs.charAt(i);
                       }

                   }

//                    screen.setText("Op:" + operation + " " + "num1:" + num1 + " " + "num2:" + num2);

                    int number_one = Integer.parseInt(num1);
                    int number_two = Integer.parseInt(num2);
                    int answer = 0;

                    if (operation == '+')
                        answer = number_one + number_two;
                    else if (operation == '-')
                        answer = number_one - number_two;
                    else if (operation == '×')
                        answer = number_one * number_two;
                    else if (operation == '÷')
                        answer = number_one/number_two;
                    else if (operation == '%') {
                        double f = number_one;
                        double s = number_two;
                        double ans = (f * s) / 100;
                        screen.setText(String.valueOf(ans));
                    }
                    else
                        answer = number_one;

                    if (operation!='%')
                        screen.setText(String.valueOf(answer));


                }




            }
        });



    }
}