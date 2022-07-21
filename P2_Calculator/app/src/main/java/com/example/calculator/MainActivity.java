package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button badd,bsub,beq,bclr,bdiv,bmul;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button)findViewById(R.id.button0);
        b0.setOnClickListener(this);
        b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(this);
        badd = (Button) findViewById(R.id.buttonadd);
        badd.setOnClickListener(this);
        bsub = (Button) findViewById(R.id.buttonsub);
        bsub.setOnClickListener(this);
        bdiv = (Button) findViewById(R.id.buttondiv);
        bdiv.setOnClickListener(this);
        bmul = (Button) findViewById(R.id.buttonmul);
        bmul.setOnClickListener(this);
        beq = (Button) findViewById(R.id.buttoneq);
        beq.setOnClickListener(this);
        result = (EditText) findViewById(R.id.resultant);
        result.setText(" ");
        bclr = (Button) findViewById(R.id.clear);
        bclr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals((b0)))
            result.append("0");
        if(v.equals((b1)))
            result.append("1");
        if(v.equals((b2)))
            result.append("2");
        if(v.equals((b3)))
            result.append("3");
        if(v.equals((b4)))
            result.append("4");
        if(v.equals((b5)))
            result.append("5");
        if(v.equals((b6)))
            result.append("6");
        if(v.equals((b7)))
            result.append("7");
        if(v.equals((b8)))
            result.append("8");
        if(v.equals((b9)))
            result.append("9");
        if(v.equals((badd)))
            result.append("+");
        if(v.equals((bsub)))
            result.append("-");
        if(v.equals((bmul)))
            result.append("*");
        if(v.equals((bdiv)))
            result.append("/");
        if(v.equals((bclr)))
            result.setText("");
        if(v.equals((beq))){
            try{
                String value = result.getText().toString();
                if(value.contains("+")){
                    String[] operands = value.split(Pattern.quote("+"));
                    if(operands.length == 2){
                        Double op1 = Double.parseDouble(operands[0]);
                        Double op2 = Double.parseDouble(operands[1]);
                        Double res = op1 + op2;
                        result.setText(""+res);
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid input", Toast.LENGTH_LONG).show();
                    }

                }
                if(value.contains("-")){
                    String[] operands = value.split(Pattern.quote("-"));
                    if(operands.length == 2){
                        Double op1 = Double.parseDouble(operands[0]);
                        Double op2 = Double.parseDouble(operands[1]);
                        Double res = op1 - op2;
                        result.setText(""+res);
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid input", Toast.LENGTH_LONG).show();
                    }


                }
                if(value.contains("/")){
                    String[] operands = value.split(Pattern.quote("/"));
                    if(operands.length == 2){
                        Double op1 = Double.parseDouble(operands[0]);
                        Double op2 = Double.parseDouble(operands[1]);
                        Double res = op1 / op2;
                        result.setText(""+res);
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid input", Toast.LENGTH_LONG).show();
                    }


                }
                if(value.contains("*")){
                    String[] operands = value.split(Pattern.quote("*"));
                    if(operands.length == 2){
                        Double op1 = Double.parseDouble(operands[0]);
                        Double op2 = Double.parseDouble(operands[1]);
                        Double res = op1 * op2;
                        result.setText(""+res);
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Invalid input", Toast.LENGTH_LONG).show();
                    }


                }
            }
            catch (Exception c){

            }
        }
    }
}