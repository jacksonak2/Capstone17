package com.example.amanda.overripepantry;
/**
 * https://code.tutsplus.com/tutorials/android-essentials-creating-simple-user-forms--mobile-1758
 *
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventoryEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void enterItem(View button) {
        final EditText itemField = (EditText) findViewById(R.id.editItemName);
        String itemName = itemField.getText().toString();

        final EditText brandField = (EditText) findViewById(R.id.editNameBrand);
        String brandName = brandField.getText().toString();

        final EditText quantityField = (EditText) findViewById(R.id.editQuantity);
        double quantity = Double.parseDouble(quantityField.getText().toString());

        final EditText unitField = (EditText) findViewById(R.id.editQuantityUnit);
        String unit = unitField.getText().toString();

        final EditText dateField = (EditText) findViewById(R.id.editExpirationDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date expDate;
        try {
            expDate = dateFormat.parse(dateField.getText().toString());
        } catch(ParseException e) {
            System.out.print("Error in the Date.");
            expDate = null;
        }

    }

}
