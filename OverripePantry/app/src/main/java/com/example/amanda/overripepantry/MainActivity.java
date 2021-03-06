package com.example.amanda.overripepantry;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
@TargetApi(7)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                PopupMenu popup = new PopupMenu(MainActivity.this, fab);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().toString().contentEquals("Barcode Scanner")) {
                            Intent intent = new Intent(MainActivity.this, BarcodeScanner.class);
                            startActivity(intent);
                        } else if(item.getTitle().toString().contentEquals("Manually Enter")) {
                            Intent intent = new Intent(MainActivity.this, InventoryEntry.class);
                            startActivity(intent);
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(MainActivity.this, GroceryLists.class);
            startActivity(intent);
        } else if (id == R.id.inventory_settings) {
            Intent intent = new Intent(MainActivity.this, Inventory.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
