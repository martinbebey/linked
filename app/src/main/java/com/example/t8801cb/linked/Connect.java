package com.example.t8801cb.linked;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static android.content.Context.*;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 *
 * @author sqlitetutorial.net
 */
public class Connect {
    /**
     * Connect to a sample database
     */
    public static void connect()
    {
        Connection conn = null;
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/sqlite/SQLiteStudio/linked.db"; //"
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        connect();
        SQLiteDatabase db =(SQLiteDatabase) openOrCreateDatabase("C:/sqlite/SQLiteStudio/linked.db",null);
        Cursor cursor = db.rawQuery("SELECT username, password FROM users" + " WHERE username = '"+ "martinbebey" + "' AND password ='"+ "superuser" + "'", null);

        if(cursor != null)
        {
            System.out.println("fuck yea");
        }

        else
        {
            System.out.println("shit!");;
        }
    }
}