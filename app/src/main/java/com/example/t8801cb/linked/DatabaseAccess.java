package com.example.t8801cb.linked;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess
{
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context)
    {
        this.openHelper = new DatabaseHelper(context);
    }

    public static DatabaseAccess getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DatabaseAccess(context);
        }

        return instance;
    }

    public void open()
    {
        this.db = openHelper.getWritableDatabase();
    }

    public void close()
    {
        if(db!= null)
        {
            this.db.close();
        }
    }

    public Cursor getUser(String username, String password)
    {
        c = db.rawQuery("SELECT username, password FROM users WHERE username = '"+ "martinbebey" + "' AND password = '"+ "superuser" + "'", new String[]{});

        return c;
    }
}
