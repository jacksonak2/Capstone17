package com.example.amanda.overripepantry;
//http://stackoverflow.com/questions/31844919/what-is-the-best-way-to-create-a-data-table-in-android
//Android Programming The Big Nerd Ranch Guide 2nd edition pg. 177 -> RecyclerView
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Inventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inventory_menu, menu);
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
        if (id == R.id.grocerylists_settings) {
            Intent intent = new Intent(Inventory.this, GroceryLists.class);
            startActivity(intent);
        } else if (id == R.id.home_settings) {
            Intent intent = new Intent(Inventory.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.login_settings) {
            Intent intent = new Intent(Inventory.this, LoginScreen.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

