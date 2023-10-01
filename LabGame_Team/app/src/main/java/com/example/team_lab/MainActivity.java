package com.example.team_lab;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static int CURRENT_BALANCE;
    private static int NUM_OF_WINS = 0;
    private static int NUM_OF_LOSSES = 0;

    @SuppressLint("SetTextI18n")
    public void setBalance(int newBalance, TextView tvAmount) {
        CURRENT_BALANCE = newBalance;
        tvAmount.setText("$" + CURRENT_BALANCE);
    }

    public void setWins(int newWins, TextView tvWins) {
        NUM_OF_WINS = newWins;
        tvWins.setText(String.valueOf(NUM_OF_WINS));
    }

    public void setLosses(int newLosses, TextView tvLosses) {
        NUM_OF_LOSSES = newLosses;
        tvLosses.setText(String.valueOf(NUM_OF_LOSSES));
    }

    private void animateProgression(int progress, SeekBar seekBar) {
        final ObjectAnimator animation = ObjectAnimator.ofInt(seekBar, "progress", 0, progress);
        animation.setDuration(3500);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
        seekBar.clearAnimation();
    }

    private void clearResults(RadioGroup radioGroup, EditText etBetAmount, List<MotorBike> motorBikes) {
        radioGroup.clearCheck();
        etBetAmount.setText("");
        for (MotorBike motorBike : motorBikes) {
            motorBike.getSeekBar().setProgress(0);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFinishOnTouchOutside(false);

        TextView tvAmount = findViewById(R.id.tvAmount);
        TextView tvWins = findViewById(R.id.tvWins);
        TextView tvLosses = findViewById(R.id.tvLosses);

        int initBalance = getIntent().getIntExtra("depositAmount", 0);
        setBalance(initBalance, tvAmount);
        setWins(NUM_OF_WINS, tvWins);
        setLosses(NUM_OF_LOSSES, tvLosses);


        Button btnStart = findViewById(R.id.btnStart);
        EditText etBetAmount = findViewById(R.id.etBetAmount);

        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        SeekBar seekBar3 = findViewById(R.id.seekBar3);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);


        List<MotorBike> motorBikes = new ArrayList<>();
        motorBikes.add(new MotorBike(seekBar1, radioButton1));
        motorBikes.add(new MotorBike(seekBar2, radioButton2));
        motorBikes.add(new MotorBike(seekBar3, radioButton3));


        // Make seekbars unable to be changed when touching
        seekBar1.setOnTouchListener((v, event) -> true);
        seekBar2.setOnTouchListener((v, event) -> true);
        seekBar3.setOnTouchListener((v, event) -> true);

        btnStart.setOnClickListener(v -> {
            btnStart.setEnabled(false);
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
            try {

                if (checkedRadioButtonId == -1) {
                    Toast.makeText(MainActivity.this, "You must select one", Toast.LENGTH_SHORT).show();
                    btnStart.setEnabled(true);
                    return;
                }

                String betAmountStr = etBetAmount.getText().toString();
                if (betAmountStr.trim().isEmpty()) {
                    etBetAmount.setError("Please enter bet amount");
                    etBetAmount.requestFocus();
                    btnStart.setEnabled(true);
                    return;
                }
                int betAmount = Integer.parseInt(betAmountStr);
                if (betAmount <= 0) {
                    etBetAmount.setError("Please enter a valid bet amount");
                    etBetAmount.requestFocus();
                    btnStart.setEnabled(true);
                    return;
                }
                if (betAmount > CURRENT_BALANCE) {
                    etBetAmount.setError("You don't have enough money");
                    etBetAmount.requestFocus();
                    btnStart.setEnabled(true);
                    return;
                }

                Collections.shuffle(motorBikes);

                MotorBike rank1 = motorBikes.get(0);
                MotorBike rank2 = motorBikes.get(1);
                MotorBike rank3 = motorBikes.get(2);

                // Animate seekbars progress
                animateProgression(100, findViewById(rank1.getSeekBar().getId()));
                animateProgression(50, findViewById(rank2.getSeekBar().getId()));
                animateProgression(80, findViewById(rank3.getSeekBar().getId()));


                new Handler().postDelayed(() -> {
                    if (rank1.getRadioButton() == checkedRadioButton) {
                        setBalance(CURRENT_BALANCE + betAmount, tvAmount);
                        setWins(NUM_OF_WINS + 1, tvWins);

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("You won!")
                                .setMessage("Result: + $" + betAmount + "\nYour new balance is $" + CURRENT_BALANCE + ".")
                                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                                    clearResults(radioGroup, etBetAmount, motorBikes);
                                })
                                .setCancelable(false)
                                .show();
                    } else {
                        setBalance(CURRENT_BALANCE - betAmount, tvAmount);
                        setLosses(NUM_OF_LOSSES + 1, tvLosses);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("You loose!")
                                .setMessage("Result: - $" + betAmount + "\nYour new balance is $" + CURRENT_BALANCE + ".")
                                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                                    clearResults(radioGroup, etBetAmount, motorBikes);
                                    if (CURRENT_BALANCE <= 0) {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setTitle("You are out of money!")
                                                .setMessage("Please deposit more money to continue.")
                                                .setPositiveButton("Deposit", (d, w) -> {
                                                    Intent intent = new Intent(MainActivity.this, DepositActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                })
                                                .setNegativeButton("Quit game", (d, w) -> {
                                                    finish();
                                                    System.exit(0);
                                                })
                                                .setCancelable(false)
                                                .show();
                                    }
                                })
                                .setCancelable(false)
                                .show();
                    }
                    btnStart.setEnabled(true);
                }, 4000);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

