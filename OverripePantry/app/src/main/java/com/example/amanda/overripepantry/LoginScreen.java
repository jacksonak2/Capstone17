package com.example.amanda.overripepantry;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void loginView(View button) {
        final EditText loginTextView = (EditText) findViewById(R.id.password);
        String loginName = loginTextView.getText().toString();

        final EditText passwordTextView = (EditText) findViewById(R.id.password);
        String passwordName = passwordTextView.getText().toString();

        //adding underline and link to signup textview
        final TextView signUpTextView = (TextView) findViewById(R.id.signUpTextView);
        signUpTextView.setPaintFlags(signUpTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Button loginButton = (Button) findViewById(R.id.email_sign_in_button);
    }

    private boolean isEmailValid(String email) {
        //add your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //add your own logic
        return password.length() > 4;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_menu, menu);
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
            Intent intent = new Intent(LoginScreen.this, GroceryLists.class);
            startActivity(intent);
        } else if (id == R.id.home_settings) {
            Intent intent = new Intent(LoginScreen.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.inventory_settings) {
            Intent intent = new Intent(LoginScreen.this, Inventory.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
