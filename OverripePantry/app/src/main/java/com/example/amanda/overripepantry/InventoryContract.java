package com.example.amanda.overripepantry;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


public class InventoryContract {
    public static final String CONTENT_AUTHORITY = "com.example.amanda.database";

    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_INVENTORY = "inventory";
    public static final String PATH_PRODUCTS = "products";
    public static final String PATH_GROCERYLISTS = "grocerylist";
    public static final String PATH_GROCERY = "grocery";

    public static class ProductEntry implements BaseColumns {
        // Content URI represents the base location for the table
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_INVENTORY).build();

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_URI  + "/" + PATH_INVENTORY;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_INVENTORY;

        public static final String TABLE_NAME = "products";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_BRAND = "brand";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_UPC = "upc";
        public static final String COLUMN_NAME_EXPDATE = "expDate";
        public static final String COLUMN_NAME_ENTRYDATE = "entryDate";




        public static Uri buildProductUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static class GroceryListEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GROCERYLISTS).build();

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_URI + "/" + PATH_GROCERYLISTS;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_GROCERYLISTS;


        public static final String TABLE_NAME = "grocerylists";
        public static final String COLUMN_NAME_TITLE = "title";

        public static Uri buildGroceryListsUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class GroceryProductEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GROCERY).build();


        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_URI + "/" + PATH_GROCERY;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_GROCERY;



        public static final String TABLE_NAME = "grocery";
        public static final String COLUMN_NAME_LISTID = "listID";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_QTY = "qty";

        public static Uri buildGroceryProductUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}