package com.example.amanda.overripepantry;
/**
 * https://code.tutsplus.com/tutorials/android-essentials-creating-simple-user-forms--mobile-1758
 *
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button enterButton = (Button) findViewById(R.id.button_enter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inventory_entry_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /**if (id == R.id.action_settings) {
         *  return true;
         *  } else
         */
        if (id == R.id.inventory_settings) {
            Intent intent = new Intent(InventoryEntry.this, Inventory.class);
            startActivity(intent);
        } else if (id == R.id.home_settings) {
            Intent intent = new Intent(InventoryEntry.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.login_settings) {
            Intent intent = new Intent(InventoryEntry.this, LoginScreen.class);
            startActivity(intent);
        } else if (id == R.id.grocerylists_settings) {
            Intent intent = new Intent(InventoryEntry.this, GroceryLists.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
