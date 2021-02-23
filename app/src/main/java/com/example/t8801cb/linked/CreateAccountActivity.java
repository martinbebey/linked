package com.example.t8801cb.linked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.sql.Connection;

import static android.app.Activity.RESULT_OK;

public class CreateAccountActivity extends AppCompatActivity {
    private static final int GET_FROM_GALLERY = 3;
    private ImageView imageToUpLoad;
    private Uri selectedImage;
    private String username, password, confirmedPassword, displayName, about, tags;
    private EditText usernameBox = (EditText) findViewById(R.id.username_box);
    private EditText passwordBox = (EditText) findViewById(R.id.password_box);
    private EditText confirmPasswordBox = (EditText) findViewById(R.id.confirm_pwd_box);
    private EditText displayNameBox = (EditText) findViewById(R.id.display_name_box);
    private EditText aboutBox = (EditText) findViewById(R.id.about_you_box);
    private EditText tagsBox = (EditText) findViewById(R.id.tags_box);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    //uploads photo from gallery
    public void UploadPhoto(View view) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GET_FROM_GALLERY);
    }

    @Override //used by uploadPhoto()
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_FROM_GALLERY && resultCode == RESULT_OK && data != null)
        {
            selectedImage = data.getData();
            // to display image -> imageToUpLoad.setImageURI(selectedImage);
        }
    }

    //creates the account
    public void CreateAccount(View view)
    {
        username = usernameBox.getText().toString();
        password = passwordBox.getText().toString();
        confirmedPassword = confirmPasswordBox.getText().toString();
        displayName = displayNameBox.getText().toString();
        about = aboutBox.getText().toString();
        tags = tagsBox.getText().toString();

        if(confirmedPassword == password)
        {

        }
    }
}