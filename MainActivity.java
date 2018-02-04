package com.example.android.happinessbarometer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        EditText yourName = (EditText) findViewById(R.id.name);
        String myName = yourName.getText().toString();

        CheckBox Y1 = (CheckBox) findViewById(R.id.Y1);
        boolean YY1 = Y1.isChecked();

        CheckBox Y2 = (CheckBox) findViewById(R.id.Y2);
        boolean YY2 = Y2.isChecked();

        CheckBox Y3 = (CheckBox) findViewById(R.id.Y3);
        boolean YY3 = Y3.isChecked();

        CheckBox Y4 = (CheckBox) findViewById(R.id.Y4);
        boolean YY4 = Y4.isChecked();

        CheckBox Y5 = (CheckBox) findViewById(R.id.Y5);
        boolean YY5 = Y5.isChecked();

        CheckBox Y6 = (CheckBox) findViewById(R.id.Y6);
        boolean YY6 = Y6.isChecked();

        CheckBox Y7 = (CheckBox) findViewById(R.id.Y7);
        boolean YY7 = Y7.isChecked();

        int result = calculateResult(YY1, YY2, YY3, YY4, YY5, YY6, YY7);
        String priceMessage = createOrderSummary(result, myName);

        if (result >= 4) {
            setContentView(R.layout.activity_main2);
            ImageView afterEatingImageView = (ImageView) findViewById(R.id.android_image_view);
            afterEatingImageView.setImageResource(R.drawable.happy);
            displayMessage(priceMessage);
        } else {
            setContentView(R.layout.activity_main2);
            ImageView afterEatingImageView = (ImageView) findViewById(R.id.android_image_view);
            afterEatingImageView.setImageResource(R.drawable.sad);
            displayMessage(priceMessage); }

    }

    private String createOrderSummary(int result, String myName){

        String priceMessage = "Name: " + myName
                + "\nScore: "
                + result;

        if (result >= 4) {
            priceMessage = priceMessage + "\nCongrats, you are very happy!!";
        } else {
            priceMessage = priceMessage + "\nDon't worry, tomorrow will be a better day :)";}

        return priceMessage;
    }

    private int calculateResult(boolean YY1, boolean YY2, boolean YY3, boolean YY4, boolean YY5, boolean YY6, boolean YY7) {

        int result = 0;

        if (YY1) {
            result = result + 1;
        }
        if (YY2) {
            result = result + 1;
        }
        if (YY3) {
            result = result + 1;
        }
        if (YY4) {
            result = result + 1;
        }
        if (YY5) {
            result = result + 1;
        }
        if (YY6) {
            result = result + 1;
        }
        if (YY7) {
            result = result + 1;
        }
        return result;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.summary);
        orderSummaryTextView.setText(message);
    }

}
