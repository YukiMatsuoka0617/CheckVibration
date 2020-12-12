package com.example.vibrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener,View.OnLongClickListener, SeekBar.OnSeekBarChangeListener {
    Button bt1;
    Vibrator vib;
    SeekBar seekBar;
    SeekBar seekBar2;
    SeekBar seekBar3;
    int ms =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.button1);

        bt1.setOnClickListener(this);
        bt1.setOnLongClickListener(this);

        vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        seekBar = findViewById(R.id.seekbar1);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setProgress(0);
        seekBar.setMax(10);

        seekBar2 = findViewById(R.id.seekbar2);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar2.setProgress(0);
        seekBar2.setMax(20);

        seekBar3 = findViewById(R.id.seekbar3);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar3.setProgress(0);
        seekBar3.setMax(1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                vib.vibrate(ms);
                break;
        }

    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                break;
        }
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seekbar1:
                ms =i;
                bt1.setText(ms+"ms");
                break;
            case R.id.seekbar2:
                ms =i*5;
                bt1.setText(ms+"ms");
                break;
            case R.id.seekbar3:
                ms =i;
                bt1.setText(ms+"ms");
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}