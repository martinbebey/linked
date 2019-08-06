package com.example.t8801cb.linked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.t8801cb.linked.ui.login.LoginActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the SignIn button */
    public void signIn(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = "shit";
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
