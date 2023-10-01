package com.example.team_lab;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class MotorBike {
    private SeekBar seekBar;
    private RadioButton radioButton;

    public MotorBike(SeekBar seekBar, RadioButton radioButton) {
        this.seekBar = seekBar;
        this.radioButton = radioButton;
    }

    public SeekBar getSeekBar() {
        return seekBar;
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

}
