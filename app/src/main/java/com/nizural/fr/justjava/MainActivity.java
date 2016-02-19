package com.nizural.fr.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Declaration of mQuantity variable
     */
    private int mQuantity = 0;
    private int mCoffePrice = 5;
    private final Context context = this;
    CheckBox mWhiskyCheckBox;
    CheckBox mRhumCheckBox;
    EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWhiskyCheckBox = (CheckBox) findViewById(R.id.whisky_checkbox);
        mRhumCheckBox = (CheckBox) findViewById(R.id.rhum_checkbox);
        mNameEditText = (EditText) findViewById(R.id.edit_text_name);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (mQuantity < 100){
            displayQuantity(++mQuantity);
        } else {
            showToast(getString(R.string.max_coffe_reached));
        }
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(context, message,Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if(mQuantity > 0){
            displayQuantity(--mQuantity);
        } else {
            showToast(getString(R.string.min_coffe_reached));
        }
    }

    /**
     * This method displays the given mQuantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the message.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method calculate the price
     *
     * @return the order's price
     */
    private int calculatePrice(){
        int pricePerCoffe = mCoffePrice;
        if(mWhiskyCheckBox.isChecked()){
            pricePerCoffe += 1;
        }
        if(mRhumCheckBox.isChecked()){
            pricePerCoffe += 2;
        }
        return mQuantity * pricePerCoffe;
    }

    /**
     * This method creates the order summary String
     *
     * @param priceOfOrder the total price of the order
     * @return the order summary
     */
    private String createOrderSummary(int priceOfOrder){
        String orderSummary = getString(R.string.user) + mNameEditText.getText() + "\n";
        if(mWhiskyCheckBox.isChecked()){
            orderSummary += getString(R.string.add_whisky) + "\n";
        }
        if(mRhumCheckBox.isChecked()){
            orderSummary += getString(R.string.add_rhum) + "\n";
        }
        orderSummary += getString(R.string.quantity) + mQuantity + "\n";
        orderSummary += getString(R.string.total) + priceOfOrder + "\n";
        orderSummary += getString(R.string.thanks);
        return orderSummary;
    }
}