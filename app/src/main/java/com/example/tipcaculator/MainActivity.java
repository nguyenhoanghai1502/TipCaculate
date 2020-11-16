package com.example.tipcaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private static final NumberFormat currencyFormat= NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat= NumberFormat.getPercentInstance();

    private double percent =0.15;
    private TextView percentTextview;
    private TextView tipTextview;
    private TextView totalTextview;
    private EditText amountEditText;
    private SeekBar percentSeekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        percentSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percent=i/100.0;
                percentTextview.setText(currencyFormat.format(percent));
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate();
            }
        });
    }
    private void calculate() {
        percentTextview.setText(percentFormat.format(percent));
        double billAmount=Double.parseDouble(amountEditText.getText().toString());
        double tip=billAmount*percent;
        double total=billAmount+tip;

        tipTextview.setText(currencyFormat.format(tip));
        totalTextview.setText(currencyFormat.format(total));
    }

    private void Anhxa() {
        percentTextview=(TextView) findViewById(R.id.percentTextView);
        tipTextview=(TextView) findViewById(R.id.tipTextView);
        totalTextview=(TextView) findViewById(R.id.totalTextView);
        tipTextview.setText(currencyFormat.format(0));
        totalTextview.setText(currencyFormat.format(0));
        amountEditText=(EditText) findViewById(R.id.amountEditText);
        percentSeekbar=(SeekBar) findViewById(R.id.percentSeekBar);
    }
}