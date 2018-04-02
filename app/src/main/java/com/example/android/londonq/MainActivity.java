package com.example.android.londonq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the submitScore button is clicked.
     */
    public void submitScore(View view) {
        RadioButton firtsQuestionRb = findViewById(R.id.Fr);
        boolean France = firtsQuestionRb.isChecked();

        RadioButton secondQuestionRb = findViewById(R.id.UK);
        boolean UnitedKingdom = secondQuestionRb.isChecked();

        RadioButton thirdQuestionRb = findViewById(R.id.Es);
        boolean esRadioButton = thirdQuestionRb.isChecked();

        RadioButton firstQuestion1Rb = findViewById(R.id.teen);
        boolean teen = firstQuestion1Rb.isChecked();

        RadioButton secondQuestion1Rb = findViewById(R.id.twenty);
        boolean twenty = secondQuestion1Rb.isChecked();

        RadioButton thirdQuestion1Rb = findViewById(R.id.seven);
        boolean seven = thirdQuestion1Rb.isChecked();

        CheckBox firtsQuestionCb = findViewById(R.id.bigBen);
        boolean bigBen = firtsQuestionCb.isChecked();

        CheckBox secondQuestionCb = findViewById(R.id.eifelTower);
        boolean eifelTower = secondQuestionCb.isChecked();

        CheckBox thirdQuestionCb = findViewById(R.id.towerBridge);
        boolean towerBridge = thirdQuestionCb.isChecked();

        CheckBox fourthQuestionCb = findViewById(R.id.colosseum);
        boolean colosseum = fourthQuestionCb.isChecked();

        EditText firstQuestionEt = findViewById(R.id.edit_text);
        String editText = firstQuestionEt.getText().toString();

        score = calculateScore(France, UnitedKingdom, esRadioButton, teen, twenty, seven, bigBen, eifelTower, towerBridge, colosseum, editText);
        displayScore("Your Score is " + score);
        if (score > 2) {
            Toast.makeText(this, "Your score is average", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Your score is weak", Toast.LENGTH_LONG).show();
        }
        if (score == 4) {
            Toast.makeText(this, "Your score is perfect!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method calculates the score
     */
    private int calculateScore(boolean France, boolean UnitedKingdom, boolean esRadioButton, boolean teen, boolean twenty, boolean seven, boolean bigBen, boolean eifelTower, boolean towerBridge, boolean colosseum, String editText) {
        recreate();
        // France checkBox is check
        if (France) {
        }
        // UnitedKingDom check box is check
        if (UnitedKingdom) {
            score++;
        }
        // esRadioButton is check
        if (esRadioButton) {
        }
        // teenButton is check
        if (teen) {
            // twentyButton is check
        }
        if (twenty) {
            // sevenButton is check
        }
        if (seven) {
            score++;
        }
        if (editText().equalsIgnoreCase("London")) {
            score++;
        }
        CheckBox firstCheck = findViewById(R.id.bigBen);
        CheckBox secondCheck = findViewById(R.id.eifelTower);
        CheckBox thirdCheck = findViewById(R.id.towerBridge);
        CheckBox fourthCheck = findViewById(R.id.colosseum);
        if (firstCheck.isChecked() && thirdCheck.isChecked() && !secondCheck.isChecked() && !fourthCheck.isChecked()) {
            score++;
        }
        //Calculate total score
        return score;
    }

    // Make sure that user can only choose two checkboxes only not more
    public void checkTwoBoxes(View view) {
        CheckBox firstCheck = findViewById(R.id.bigBen);
        CheckBox secondCheck = findViewById(R.id.eifelTower);
        CheckBox thirdCheck = findViewById(R.id.towerBridge);
        CheckBox fourthCheck = findViewById(R.id.colosseum);
        if (firstCheck.isChecked() && secondCheck.isChecked()) {
            thirdCheck.setChecked(false);
            fourthCheck.setChecked(false);
        }
        if (secondCheck.isChecked() && thirdCheck.isChecked()) {
            firstCheck.setChecked(false);
            fourthCheck.setChecked(false);
        }
        if (thirdCheck.isChecked() && fourthCheck.isChecked()) {
            firstCheck.setChecked(false);
            secondCheck.setChecked(false);
        }
    }

    /**
     * This method displays the given score on the screen.
     */
    private void displayScore(String message) {
        TextView displayScore = findViewById(R.id.score_view);
        displayScore.setText(message);
    }

    /**
     * Extract String fom editText
     */
    private String editText() {
        EditText London = findViewById(R.id.edit_text);
        return London.getText().toString();
    }
}

