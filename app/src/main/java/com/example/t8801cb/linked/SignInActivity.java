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

public class SignInActivity extends AppCompatActivity
{
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private String username = "";
    private String password = "";
    private TextView usertextView;
    private TextView passtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }

    /** Called when the user taps the SignIn button */
    public void signIn(View view)
    {
        usertextView = (TextView)findViewById(R.id.username_box);
        username = usertextView.getText().toString();
        passtextView = (TextView)findViewById(R.id.password_box);
        password = passtextView.getText().toString();

        Cursor cursor = mDb.rawQuery("SELECT username, password FROM users" + " WHERE username = '"+ username + "' AND password ='"+ password + "'", null);

        if(cursor != null)
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

        else
        {
            usertextView.setText("");
            passtextView.setText("");
        }
    }
}
