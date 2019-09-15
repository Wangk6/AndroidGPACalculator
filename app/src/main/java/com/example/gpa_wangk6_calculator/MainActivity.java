package com.example.gpa_wangk6_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int gradeOne, gradeTwo, gradeThree, gradeFour, gradeFive, totalGrade;

    EditText gradeOneInput, gradeTwoInput, gradeThreeInput, gradeFourInput, gradeFiveInput;
    TextView displayGPA;
    Button calculateGrade, clearBtn;
    ConstraintLayout currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gradeOneInput = (EditText) findViewById(R.id.editTxtGradeOne);
        gradeTwoInput = (EditText) findViewById(R.id.editTxtGradeTwo);
        gradeThreeInput = (EditText) findViewById(R.id.editTxtGradeThree);
        gradeFourInput = (EditText) findViewById(R.id.editTxtGradeFour);
        gradeFiveInput = (EditText) findViewById(R.id.editTxtGradeFive);
        displayGPA = (TextView) findViewById(R.id.txtDisplayGPA);
        calculateGrade = (Button) findViewById(R.id.btnCalculateGPA);
        clearBtn = (Button) findViewById(R.id.btnClearForm);
        currentLayout = (ConstraintLayout) findViewById(R.id.mainLayout);

        //Clear Button Click Listener
        clearBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                resetEntireForm();
            }
        });

        //Calculate Button Click listener
        calculateGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(calculateGrade.getText() == "CLEAR FORM"){
                    resetEntireForm();
                }
                else if(gradeOneInput.getText().toString().length() > 0 && gradeTwoInput.getText().toString().length() > 0 && gradeThreeInput.getText().toString().length() > 0 &&
                        gradeFourInput.getText().toString().length() > 0 && gradeFiveInput.getText().toString().length() > 0) {
                    gradeOne = Integer.valueOf(gradeOneInput.getText().toString());
                    gradeTwo = Integer.valueOf(gradeTwoInput.getText().toString());
                    gradeThree = Integer.valueOf(gradeThreeInput.getText().toString());
                    gradeFour = Integer.valueOf(gradeFourInput.getText().toString());
                    gradeFive = Integer.valueOf(gradeFiveInput.getText().toString());

                    calculateGrade();
                    setClearForm();
                }
                else{
                    //If empty
                    displayGPA.setText("Fill all Fields");
                }
            }
        });

        //Text Change listener
        gradeOneInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(calculateGrade.getText() == "CLEAR FORM"){
                    setCalculateForm();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        gradeTwoInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(calculateGrade.getText() == "CLEAR FORM"){
                    setCalculateForm();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        gradeThreeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(calculateGrade.getText() == "CLEAR FORM"){
                    setCalculateForm();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        gradeFourInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(calculateGrade.getText() == "CLEAR FORM"){
                    setCalculateForm();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        gradeFiveInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(calculateGrade.getText() == "CLEAR FORM"){
                    setCalculateForm();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    //Name: checkGrade
    //Purpose: Sets the background color depending on grade and displays overall GPA
    public void calculateGrade(){
        totalGrade = (gradeOne + gradeTwo + gradeThree + gradeFour + gradeFive) / 5;
        if (totalGrade <= 60){ //red
            currentLayout.setBackgroundColor(Color.RED);
        }
        else if(totalGrade >= 61 && totalGrade <= 79){
            currentLayout.setBackgroundColor(Color.YELLOW);
        }
        else if(totalGrade >= 80 && totalGrade <= 100){
            currentLayout.setBackgroundColor(Color.GREEN);
        }
        displayGPA.setText("Total GPA: " + totalGrade);
    }

    //Name: setCalculateForm
    //Purpose: Resets the form back to the calculation stage not resetting the values in boxes
    public void setCalculateForm(){
        calculateGrade.setText("CALCULATE");
        currentLayout.setBackgroundColor(Color.WHITE);
        displayGPA.setText("");
    }

    //Name: setClearForm
    //Purpose: Sets the form to be readily cleared
    public void setClearForm(){
        calculateGrade.setText("CLEAR FORM");
    }

    //Name: resetEntireForm
    //Purpose: Resets the entire form back to original state
    public void resetEntireForm(){
        gradeOneInput.setText("");
        gradeTwoInput.setText("");
        gradeThreeInput.setText("");
        gradeFourInput.setText("");
        gradeFiveInput.setText("");
        displayGPA.setText("");
        setCalculateForm();
    }

}
