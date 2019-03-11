package com.example.savingscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    EditText edtSalary, edtSavingsPerWeek;
    TextView textMonthlyIncome, textWeeklyIncome, textHourlyIncome, textMonthlySavings, textYearlySavings, textTenYearSavings, textTwentyFiveYearSavings;
    Button btnCalculate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        calculateLogic();
        clearLogic();




    }

    private void calculateLogic(){


        btnCalculate = findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculation();
                dismissKeyboard();
            }
        });


    }

    private void clearLogic(){

        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAppLogic();
                dismissKeyboard();
            }
        });
    }

    private void mathCalculation(){
        edtSalary = findViewById(R.id.edtSalary);
        edtSavingsPerWeek = findViewById(R.id.edtSavingsPerWeek);

        textMonthlyIncome = findViewById(R.id.textMonthlyIncome);
        textWeeklyIncome = findViewById(R.id.textWeeklyIncome);
        textHourlyIncome = findViewById(R.id.textHourlyIncome);

        textMonthlySavings = findViewById(R.id.textMonthlySavings);
        textYearlySavings = findViewById(R.id.textYearlySavings);
        textTenYearSavings = findViewById(R.id.textTenYearSavings);
        textTwentyFiveYearSavings = findViewById(R.id.textTwentyFiveYearSavings);

        String text1 = edtSalary.getText().toString().trim();
        String text2 = edtSavingsPerWeek.getText().toString().trim();

        Double salary = 0d;
        Double weeklySavings = 0d;

        if(text1.equals("") || text2.equals("")){
            salary = 0d;
            weeklySavings = 0d;
        }else if(text1.equals("")){
            salary = 0d;
            weeklySavings = 0d;
        }
        else if(text2.equals("")){
            salary = 0d;
            weeklySavings = 0d;
        }
        else{

            Double salary1 = Double.parseDouble(edtSalary.getText().toString());
            Double weeklySavings1 = Double.parseDouble(edtSavingsPerWeek.getText().toString());

            salary = salary1;
            weeklySavings = weeklySavings1;

        }



        Double salaryMonthly, salaryWeekly, salaryHourly, savingsMonthly, savingsYearly, savingsTenYears, savingsTwentyFiveYears;

        salaryMonthly = salary /12;
        salaryWeekly = salary /52;
        salaryHourly = salaryWeekly / 40;

        savingsMonthly = weeklySavings * 4;
        savingsYearly = savingsMonthly * 12;
        savingsTenYears = savingsYearly * 10;
        savingsTwentyFiveYears = savingsYearly * 25;

        String salaryMonthlyStr = String.format("%1.2f", salaryMonthly);
        String salaryWeeklyStr = String.format("%1.2f", salaryWeekly);
        String salaryHourlyStr = String.format("%1.2f", salaryHourly);

        String savingsMonthlyStr = String.format("%1.2f", savingsMonthly);
        String savingsYearlyStr = String.format("%1.2f", savingsYearly);
        String savingsTenYearsStr = String.format("%1.2f", savingsTenYears);
        String savingsTwentyFiveYearsStr = String.format("%1.2f", savingsTwentyFiveYears);

        textMonthlyIncome.setText("Monthly Income: $" + salaryMonthlyStr);
        textWeeklyIncome.setText("Weekly Income: $" + salaryWeeklyStr);
        textHourlyIncome.setText("Hourly Income: $" + salaryHourlyStr);

        textMonthlySavings.setText("Monthly Savings: $" + savingsMonthlyStr);
        textYearlySavings.setText("Yearly Savings: $" + savingsYearlyStr);
        textTenYearSavings.setText("Ten Years Savings: $" + savingsTenYearsStr);
        textTwentyFiveYearSavings.setText("Twenty Five Years Savings: $" + savingsTwentyFiveYearsStr);


    }

    private void dismissKeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtSalary.getWindowToken(), 0);
    }

    private void clearAppLogic(){

        edtSalary = findViewById(R.id.edtSalary);
        edtSavingsPerWeek = findViewById(R.id.edtSavingsPerWeek);

        textMonthlyIncome = findViewById(R.id.textMonthlyIncome);
        textWeeklyIncome = findViewById(R.id.textWeeklyIncome);
        textHourlyIncome = findViewById(R.id.textHourlyIncome);

        textMonthlySavings = findViewById(R.id.textMonthlySavings);
        textYearlySavings = findViewById(R.id.textYearlySavings);
        textTenYearSavings = findViewById(R.id.textTenYearSavings);
        textTwentyFiveYearSavings = findViewById(R.id.textTwentyFiveYearSavings);

        edtSavingsPerWeek.setText("");
        edtSalary.setText("");

        textMonthlyIncome.setText("Monthly Income");
        textWeeklyIncome.setText("Weekly Income");
        textHourlyIncome.setText("Hourly Income");

        textMonthlySavings.setText("Monthly Savings");
        textYearlySavings.setText("Yearly Savings");
        textTenYearSavings.setText("Ten Years Savings");
        textTwentyFiveYearSavings.setText("Twenty Five Years Savings");
    }




}
