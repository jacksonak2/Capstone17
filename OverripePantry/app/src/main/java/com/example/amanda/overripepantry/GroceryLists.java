package com.example.amanda.overripepantry;
//http://stackoverflow.com/questions/37594936/expansion-panels-in-google-material-design-android
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
//import android.widget.RelativeLayout;

public class GroceryLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_lists);
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
        if (id == R.id.inventory_settings) {
            Intent intent = new Intent(GroceryLists.this, Inventory.class);
            startActivity(intent);
        } else if (id == R.id.home_settings) {
            Intent intent = new Intent(GroceryLists.this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
/*
    ExpandableLinearLayout content=(ExpandableLinearLayout) itemView.findViewById(R.id.content);
    RelativeLayout header=(RelativeLayout) itemView.findViewById(R.id.accordian_header);
//to toggle content
    header.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            content.toggle();
        }
    });
*/
}
