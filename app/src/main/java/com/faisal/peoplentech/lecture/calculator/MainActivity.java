package com.faisal.peoplentech.lecture.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tvHistory;
    private EditText tvDisplay;
    private HorizontalScrollView hzDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHistory = findViewById(R.id.tvHistory);
        tvDisplay = findViewById(R.id.tvDisplay);
        hzDisplay = findViewById(R.id.hzDisplay);




    }

    public void btn0(View view) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "0";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn1(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "1";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn2(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "2";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn3(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "3";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn4(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "4";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn5(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "5";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn6(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "6";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn7(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "7";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn8(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "8";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btn9(View v) {
        String preText = tvDisplay.getText().toString();
        String finalText = preText + "9";
        tvDisplay.setText(finalText);
        tvDisplay.setSelection(finalText.length());
        tvDisplay.focusSearch(finalText.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
    }

    public void btnDot(View v) {
        String preText = tvDisplay.getText().toString();
        if (TextUtils.isEmpty(preText)) {
            tvDisplay.setText("0.");
        } else {
            if (isAddSign(preText)) {
                String finalText = preText + ".";
                tvDisplay.setText(finalText);
                tvDisplay.setSelection(finalText.length());
                tvDisplay.focusSearch(finalText.length());
                hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
            }
        }
    }

    public void btnC(View view) {
        tvHistory.setText("");
        tvDisplay.setText("");
    }

    public void btnAdd(View view) {
        String preText = tvDisplay.getText().toString();
        if (isAddSign(preText)) {
            String finalText = preText + "+";
            tvDisplay.setText(finalText);
            tvDisplay.setSelection(finalText.length());
            tvDisplay.focusSearch(finalText.length());
            hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
        }
    }

    public void btnSub(View view) {
        String preText = tvDisplay.getText().toString();
        if (isAddSign(preText)) {
            String finalText = preText + "-";
            tvDisplay.setText(finalText);
            tvDisplay.setSelection(finalText.length());
            tvDisplay.focusSearch(finalText.length());
            hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
        }
    }

    public void btnMul(View view) {
        String displayText = tvDisplay.getText().toString();
        if (isAddSign(displayText)) {
            displayText += "\u00D7";
            tvDisplay.setText(displayText);
            tvDisplay.setSelection(displayText.length());
            tvDisplay.focusSearch(displayText.length());
            hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
        }
    }

    public void btnDiv(View view) {
        String displayText = tvDisplay.getText().toString();
        if (isAddSign(displayText)) {
            displayText += "\u00F7";
            tvDisplay.setText(displayText);
            tvDisplay.setSelection(displayText.length());
            tvDisplay.focusSearch(displayText.length());
            hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);
        }
    }

    public void btnEqual(View view) {
        String displayText = tvDisplay.getText().toString();
        if (!isAddSign(displayText)) {
            displayText = displayText.substring(0, displayText.length() - 1);
        }
        Double result = new Calculator().getResult(displayText);
        displayText += "=";
        tvHistory.setText(displayText);
        displayResult(result);
    }

    private boolean isAddSign(String str) {
        if (!str.isEmpty()) {
            char ch = str.charAt(str.length() - 1);
            return !(ch == '.' || ch == '+' || ch == '-' || ch == '\u00D7' || ch == '\u00F7');
        }
        return false;
    }

    private void displayResult(Double d){
        int i = d.intValue();
        if(d != (double)i) tvDisplay.setText(new DecimalFormat("##.######").format(d));
        else tvDisplay.setText(String.valueOf(i));
        String text = tvDisplay.getText().toString();
        tvDisplay.setSelection(text.length());
        tvDisplay.focusSearch(text.length());
        hzDisplay.fullScroll(HorizontalScrollView.SCROLL_AXIS_HORIZONTAL);

    }


}
