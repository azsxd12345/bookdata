package com.example.bookdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import android.database.SQLException;
//import android.database.sqlite.SQLiteStatement;


public class BookDatabaseHelper extends SQLiteOpenHelper {
    static final private String DBNAME = "bookdata.sqlite";
    static final private int VERSION = 1;

    BookDatabaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE books (" +
                "isbn TEXT PRIMARY KEY, title TEXT, price INTEGER, note TEXT)");
        db.execSQL("INSERT INTO books(isbn, title, price, note)" +
                " VALUES('978-4866211992', '「300億円赤字」だったマックを六本木バーの店長がV字回復させた秘密', 1650, '勉強になった')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        onCreate(db);
    }
}