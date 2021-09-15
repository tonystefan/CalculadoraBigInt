package com.example.calculadorabigint;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Stack<String> stack1 = new Stack<String>();

    EditText v1, v2;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void soma(View view) {
        char[] x,y;
        int z[] = new int[30];
        String r1 = "";
        String vetor2 = "",vetor1 = "";
        v1 = (EditText) findViewById(R.id.valor1);
        stack1.push(v1.getText().toString());
        String n1 = stack1.pop();
        v2 = (EditText) findViewById(R.id.valor2);
        stack1.push(v2.getText().toString());
        String n2 = stack1.pop();

        x = n1.toCharArray();
        y = n2.toCharArray();
        for(int i = n1.length()-1; i >= 0; i--){
            vetor1 += x[i];
        }
        for(int i = n2.length()-1; i >= 0; i--){
            vetor2 += y[i];
        }
        x = vetor1.toCharArray();
        y = vetor2.toCharArray();
        for(int i = 0; i < n1.length(); i++){
            z[i] = z[i] + Character.getNumericValue(x[i]);
        }
        for(int i = 0; i < n2.length(); i++){
            z[i] = z[i] + Character.getNumericValue(y[i]);
            z[i + 1] = z[i + 1] + (z[i] / 10);
            z[i] = z[i] - (10 * (z[i] / 10));
        }
        if(n1.length() > n2.length()){
            if(z[n1.length()] != 0){
                r1 += Integer.toString(z[n1.length()]);
            }
            for(int i = n1.length()-1; i >= 0; i--){
                r1 += Integer.toString(z[i]);
            }
        } else {
            if(z[n2.length()] != 0){
                r1 += Integer.toString(z[n2.length()]);
            }
            for(int i = n2.length()-1; i >= 0; i--){
                r1 += Integer.toString(z[i]);
            }
        }
        stack1.push(r1);
        st();
    }

    public void multiplica(View view) {
        char[] x,y;
        int z[] = new int[30];
        String r1 = "";
        v1 = (EditText) findViewById(R.id.valor1);
        stack1.push(v1.getText().toString());
        String n1 = stack1.pop();
        v2 = (EditText) findViewById(R.id.valor2);
        stack1.push(v2.getText().toString());
        String n2 = stack1.pop();

        y = n2.toCharArray();
        x = n1.toCharArray();
        for(int i = n1.length()-1; i >= 0; i--){
            for(int j = n2.length()-1; j >= 0; j--){
                z[j+i] = z[j+i] + Character.getNumericValue(x[i]) * Character.getNumericValue(y[j]);
                if(j+i-1 >= 0) {
                    z[j + i - 1] = z[j + i - 1] + (z[j + i] / 10);
                    z[j + i] = z[j + i] - (10 * (z[j + i] / 10));
                }
            }
        }
        for (int i = 0; i <= n2.length() + n1.length() - 2; i++){
            r1 += Integer.toString(z[i]);
        }
        stack1.push(r1);
        st();
    }


    public void st() {
        TextView t3 = (TextView) findViewById(R.id.text3);
        t3.setText(stack1.toString());
    }
}

