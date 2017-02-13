package com.example.amanda.overripepantry;
//http://stackoverflow.com/questions/37594936/expansion-panels-in-google-material-design-android
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
//import android.widget.RelativeLayout;

public class GroceryLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_lists);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
