/**
 * Created by ffantl on 3/4/17.
 */

package com.example.amanda.overripepantry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by ffantl on 3/20/17.
 */
public class InventoryDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "inventory.db";
    private static final String COLUMN_ID = "_id";

    public InventoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is first created.
     * @param db The database being created, which all SQL statements will be executed on.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        addProductTable(db);
        addGroceryListsTable(db);
        addGroceryProductTable(db);
    }

    @Override
    public void onUgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
            * Inserts the genre table into the database.
     * @param db The SQLiteDatabase the table is being inserted into.
     */
//    CREATE TABLE IF NOT EXISTS products (
//            productID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
//            title VARCHAR(255) NOT NULL,
//    brand VARCHAR(255),
//    weight FLOAT,
//    upc VARCHAR(12),
//    expDate DATE NOT NULL,
//    entryDate DATE NOT NULL
//    );

    private void addProductTable(SQLiteDatabase db){
        db.execSQL(
                "CREATE TABLE " + InventoryContract.ProductEntry.TABLE_NAME + " (" +
                        InventoryContract.ProductEntry._ID + " INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                        InventoryContract.ProductEntry.COLUMN_NAME_TITLE + " VARCHAR(255) NOT NULL, " +
                        InventoryContract.ProductEntry.COLUMN_NAME_BRAND + " VARCHAR(255) NOT NULL, " +
                        InventoryContract.ProductEntry.COLUMN_NAME_WEIGHT + " FLOAT, " +
                        InventoryContract.ProductEntry.COLUMN_NAME_UPC + " VARCHAR(12), " +
                        InventoryContract.ProductEntry.COLUMN_NAME_EXPDATE + " DATE, " +
                        InventoryContract.ProductEntry.COLUMN_NAME_ENTRYDATE + " DATE );"
        );
    }

    /**
     * Inserts the movie table into the database.
     * @param db The SQLiteDatabase the table is being inserted into.
     */
    private void addGroceryListsTable(SQLiteDatabase db){
        db.execSQL(
                "CREATE TABLE " + InventoryContract.GroceryListEntry.TABLE_NAME + " (" +
                        InventoryContract.GroceryListEntry._ID + " INTEGER PRIMARY KEY, " +
                        InventoryContract.GroceryListEntry.COLUMN_NAME_TITLE + " TEXT NOT NULL " +
                        ");"
        );
    }

    private void addGroceryProductTable(SQLiteDatabase db){
        db.execSQL(
                "CREATE TABLE " + InventoryContract.GroceryProductEntry.TABLE_NAME + " (" +
                        InventoryContract.GroceryProductEntry._ID + " INTEGER PRIMARY KEY, " +
                        InventoryContract.GroceryProductEntry.COLUMN_NAME_TITLE + " TEXT NOT NULL, " +
                        InventoryContract.GroceryProductEntry.COLUMN_NAME_QTY + " INT NOT NULL " +
                        InventoryContract.GroceryProductEntry.COLUMN_NAME_LISTID + " INT NOT NULL"
                        "FOREIGN KEY (" + InventoryContract.GroceryListEntry._ID + ") " +
                        "REFERENCES " + InventoryContract.GroceryProductEntry.TABLE_NAME + " (" + InventoryContract.GroceryProductEntry.COLUMN_NAME_LISTID + "));"
        );
    }

}
