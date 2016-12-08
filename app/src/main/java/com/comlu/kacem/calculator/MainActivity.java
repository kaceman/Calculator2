package com.comlu.kacem.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnPlus, btnMoins, btnDiviser, btnMulti;
    Button btnEgale, btnClear, btnPoint, btnEffacer;

    double num1, num2;

    boolean boolPlus = false, boolMoins = false, boolDiviser = false, boolMulti = false;
    boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btn0 = (Button) findViewById(R.id.zero);
        btn1 = (Button) findViewById(R.id.un);
        btn2 = (Button) findViewById(R.id.deux);
        btn3 = (Button) findViewById(R.id.trois);
        btn4 = (Button) findViewById(R.id.quatre);
        btn5 = (Button) findViewById(R.id.cinq);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.sept);
        btn8 = (Button) findViewById(R.id.huit);
        btn9 = (Button) findViewById(R.id.neuf);


        btnPlus = (Button) findViewById(R.id.plus);
        btnMoins = (Button) findViewById(R.id.moins);
        btnDiviser = (Button) findViewById(R.id.diviser);
        btnMulti = (Button) findViewById(R.id.multi);


        btnEgale = (Button) findViewById(R.id.egale);
        btnClear = (Button) findViewById(R.id.clear);
        btnPoint = (Button) findViewById(R.id.point);
        btnEffacer = (Button) findViewById(R.id.effacer);

        result = (TextView) findViewById(R.id.result);

    }


    public void effacer(View view) {
        String rslt = result.getText().toString();
        result.setText(rslt.substring(0, rslt.length() - 1));
    }

    public void clear(View view) {
        result.setText("0");
        num1 = 0;
        num2 = 0;
        boolPlus = false;
        boolMoins = false;
        boolDiviser = false;
        boolMulti = false;
        first = true;
    }

    public void diviser(View view) {
        num1 = Double.parseDouble(result.getText().toString());
        first = true;
        boolMoins = false;
        boolDiviser = true;
        boolMulti = false;
        boolPlus = false;
    }

    public void sept(View view) {
        afficheNum("7");
    }

    public void huit(View view) {
        afficheNum("8");
    }

    public void neuf(View view) {
        afficheNum("9");
    }

    public void multi(View view) {
        num1 = Double.parseDouble(result.getText().toString());
        first = true;
        boolMoins = false;
        boolDiviser = false;
        boolMulti = true;
        boolPlus = false;
    }

    public void quatre(View view) {
        afficheNum("4");
    }

    public void cinq(View view) {
        afficheNum("5");
    }

    public void six(View view) {
        afficheNum("6");
    }

    public void moins(View view) {
        num1 = Double.parseDouble(result.getText().toString());
        first = true;
        boolMoins = true;
        boolDiviser = false;
        boolMulti = false;
        boolPlus = false;
    }

    public void un(View view) {
        afficheNum("1");
    }

    public void deux(View view) {
        afficheNum("2");
    }

    public void trois(View view) {
        afficheNum("3");
    }

    public void plus(View view) {
        num1 = Double.parseDouble(result.getText().toString());
        first = true;
        boolMoins = false;
        boolDiviser = false;
        boolMulti = false;
        boolPlus = true;
    }

    public void zero(View view) {
        String rslt = result.getText().toString();
        if (!rslt.equals("0")) afficheNum("0");
    }

    public void point(View view) {
        String rslt = result.getText().toString();
        if (!rslt.contains(".")) {
            result.setText(rslt + ".");
        }
    }

    public void egale(View view) {
        num2 = Double.parseDouble(result.getText().toString());
        if (boolPlus) {
            result.setText(String.valueOf(num1 + num2));
        } else if (boolMoins) {
            result.setText(String.valueOf(num1 - num2));
        } else if (boolDiviser) {
            if (num2 != 0)
                result.setText(String.valueOf(num1 / num2));
            else
                result.setText("Erreur!");
        } else if (boolMulti) {
            result.setText(String.valueOf(num1 * num2));
        }

        boolMoins = false;
        boolDiviser = false;
        boolMulti = false;
        boolPlus = false;
    }

    public void afficheNum(String num) {
        String rslt = result.getText().toString();
        if (rslt.equals("0")) {
            result.setText(num);
            Log.i("message", "A");
        } else if (boolPlus || boolDiviser || boolMoins || boolMulti) {
            if (first) {
                result.setText(num);
                first = false;
                Log.i("message", "B");
            } else {
                result.setText(rslt + num);
            }
        } else {
            result.setText(rslt + num);
        }
    }
}
