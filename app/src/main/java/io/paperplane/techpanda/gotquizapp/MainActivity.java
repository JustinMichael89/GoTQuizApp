package io.paperplane.techpanda.gotquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view)
    {
        int score = 0;

        // Here we check for correct answers to the radioBtn questions
        RadioButton question1Option2Btn = (RadioButton) findViewById(R.id.Q1O2_RadBtn);
        boolean q1CorrectAnswer = question1Option2Btn.isChecked();

        if(q1CorrectAnswer)
        {
            score = score +1;
        }

        RadioButton question2Option3Btn = (RadioButton) findViewById(R.id.Q2O3_RadBtn);
        boolean q2CorrectAnswer = question2Option3Btn.isChecked();

        if(q2CorrectAnswer)
        {
            score = score +1;
        }

        RadioButton question3Option1Btn = (RadioButton) findViewById(R.id.Q3O1_RadBtn);
        boolean q3CorrectAnswer = question3Option1Btn.isChecked();

        if(q3CorrectAnswer)
        {
            score = score +1;
        }

        RadioButton question4Option2Btn = (RadioButton) findViewById(R.id.Q4O2_RadBtn);
        boolean q4CorrectAnswer = question4Option2Btn.isChecked();

        if(q4CorrectAnswer)
        {
            score = score +1;
        }

        // Here we check for correct answers to the CheckBox question 5
        CheckBox question5Option1ChkBox = (CheckBox) findViewById(R.id.Q5O1);
        boolean Q5O1IsChecked = question5Option1ChkBox.isChecked();

        CheckBox question5Option2ChkBox = (CheckBox) findViewById(R.id.Q5O2);
        boolean Q5O2IsNotChecked = !question5Option2ChkBox.isChecked();

        CheckBox question5Option3ChkBox = (CheckBox) findViewById(R.id.Q5O3);
        boolean Q5O3IsChecked = question5Option3ChkBox.isChecked();

        CheckBox question5Option4ChkBox = (CheckBox) findViewById(R.id.Q5O4);
        boolean Q5O4IsChecked = question5Option4ChkBox.isChecked();

        CheckBox question5Option5ChkBox = (CheckBox) findViewById(R.id.Q5O5);
        boolean Q5O5IsNotChecked = !question5Option5ChkBox.isChecked();

        // Here we run a check to make sure all the correct answers are chosen
        if(Q5O1IsChecked && Q5O3IsChecked && Q5O4IsChecked && Q5O2IsNotChecked && Q5O5IsNotChecked)
        {
            score = score +1;

        }

        // Here we check for correct answers to the CheckBox question 5
        CheckBox question6Option1ChkBox = (CheckBox) findViewById(R.id.Q6O1);
        boolean Q6O1IsChecked = question6Option1ChkBox.isChecked();

        CheckBox question6Option2ChkBox = (CheckBox) findViewById(R.id.Q6O2);
        boolean Q6O2IsNotChecked = !question6Option2ChkBox.isChecked();

        CheckBox question6Option3ChkBox = (CheckBox) findViewById(R.id.Q6O3);
        boolean Q6O3IsChecked = question6Option3ChkBox.isChecked();

        CheckBox question6Option4ChkBox = (CheckBox) findViewById(R.id.Q6O4);
        boolean Q6O4IsNotChecked = !question6Option4ChkBox.isChecked();

        CheckBox question6Option5ChkBox = (CheckBox) findViewById(R.id.Q6O5);
        boolean Q6O5IsChecked = question6Option5ChkBox.isChecked();

        // Here we run a check to make sure all the correct answers are chosen
        if(Q6O1IsChecked && Q6O3IsChecked && Q6O4IsNotChecked && Q6O2IsNotChecked && Q6O5IsChecked)
        {
            score = score +1;

        }

        // Clearing the toast in the event there is a display
        if (mToast != null)   {
            mToast.cancel();
        }
        // Displaying quiz results via toast message
        mToast = customToastStyle(this, getResults(score), Toast.LENGTH_LONG );
        mToast.show();

    }

    private String getResults(int score) {
        if (score == 0)
        {
            return getString(R.string.badResult, score);
        }
        else if (score <= 5)
        {
            return getString(R.string.okayResult, score);
        }
        else
        {
            return getString(R.string.perfectResult, score);
        }
    }

    private Toast customToastStyle(Context context, String message, int toastDuration) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(context);
        toast.setDuration(toastDuration);
        toast.setView(layout);
        return toast;

    }

}
