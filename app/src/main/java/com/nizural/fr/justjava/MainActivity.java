package com.nizural.fr.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Declaration of quantity variable
     */
    private int quantity = 0;
    private int pricePerCup = 10;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Total: " + calculatePrice() + "€\nThank you!";
        displayMessage(priceMessage);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        displayQuantity(++quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        displayQuantity(--quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the message.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * this method calculate the price
     *
     * @return the order's price
     */
    private int calculatePrice(){
        return quantity * pricePerCup;
    }
}