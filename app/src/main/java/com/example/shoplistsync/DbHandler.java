package com.example.shoplistsync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;


public class DbHandler extends SQLiteOpenHelper
{
    // Db items
    private static final int DB_VERSION = 1;
    private static String DB_NAME = "listDb";
    private static final String COLUMN_NAME = "itemsList";
    private static final String ITEM_ID = "id";
    private static final String ITEM_TITLE = "item";
    private static final String ITEM_QUANTITY = "qty";
    private static final String ITEM_INFO = "info";
    private static final String PATH = "/storage/emulated/0/Documents";



    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insertItemDetails(String item, String qty, String info )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(ITEM_TITLE, item);
        cValues.put(ITEM_QUANTITY, qty);
        cValues.put(ITEM_INFO, info);

        long newRowId = db.insert(COLUMN_NAME, null, cValues);
        db.close();

    }

    //public ArrayList<HashMap<String, String>> getList()
    //{
      //  SQLiteDatabase db = this.getWritableDatabase();

       // ArrayList<HashMap<String, String>> itemList = new ArrayList<>();

        //String query = "SELECT id , item, info, qty FROM " + COLUMN_NAME;
        //Cursor cursor = db.rawQuery(query, null);

       // while (cursor.moveToNext())
       // {
         //   HashMap<String, String> item = new HashMap<>();
         //   item.put("id", cursor.getString(cursor.getColumnIndex(ITEM_ID)));
           // item.put("item", cursor.getString(cursor.getColumnIndex(ITEM_TITLE)));
           // item.put("info", cursor.getString(cursor.getColumnIndex(ITEM_INFO)));
           // item.put("qty", cursor.getString(cursor.getColumnIndex(ITEM_QUANTITY)));

           // itemList.add(item);
      //  }
      //  return itemList;
   // }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_COLUMN = "CREATE TABLE " + COLUMN_NAME + "("
                + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ITEM_TITLE + "TEXT,"
                + ITEM_INFO + "TEXT,"
                + ITEM_QUANTITY + "TEXT"
                + ")";

        db.execSQL(CREATE_COLUMN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + COLUMN_NAME);
        onCreate(db);

    }
}
