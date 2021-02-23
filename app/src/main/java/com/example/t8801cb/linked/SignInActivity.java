package com.example.t8801cb.linked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.*;
import android.widget.TextView;

import java.io.IOException;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class SignInActivity extends AppCompatActivity
{
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private SQLiteOpenHelper openHelper;
    private String username = "";
    private String password = "";
    private TextView usertextView;
    private TextView passtextView;
   // private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mDBHelper = new DatabaseHelper(this);
        openHelper = new DatabaseHelper(this);

//        try {
//            mDBHelper.updateDataBase();
//        } catch (IOException mIOException) {
//            throw new Error("UnableToUpdateDatabase");
//        }

        //open db
//        try {
//            mDb = openHelper.getWritableDatabase();
//        } catch (SQLException mSQLException) {
//            throw mSQLException;
//        }
    }

    /** Called when the user taps the SignIn button */
    public void signIn(View view)
    {
        usertextView = (TextView)findViewById(R.id.username_box);
        username = usertextView.getText().toString();
        passtextView = (TextView)findViewById(R.id.password_box);
        password = passtextView.getText().toString();

//        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
//        databaseAccess.open();

//        cursor = databaseAccess.getUser(username, password);
        SQLiteDatabase db = new DatabaseHelper(this);
       // SQLiteDatabase db =openHelper.getWritableDatabase();//(SQLiteDatabase) openOrCreateDatabase("linked.db", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT username, password FROM users WHERE username = '"+ "martinbebey" + "' AND password = '"+ "superuser" + "'", null);

        //Cursor cursor = mDb.rawQuery("SELECT username, password FROM users" + " WHERE username = '"+ username + "' AND password ='"+ password + "'", null);

        if(cursor != null)
        {
            System.out.println("fuck yea");
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

        else
        {
            System.out.println("shit!");
            usertextView.setText("");
            passtextView.setText("");
        }
    }
}
