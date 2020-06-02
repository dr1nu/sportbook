package com.example.sportbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class adminActivity extends AppCompatActivity {
    private static final int GALLERY_REQUEST_CODE = 123;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        imageButton = findViewById(R.id.post_image);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent();
                picture_intent.setType("image/*");
                picture_intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(picture_intent, "Select Picture"), GALLERY_REQUEST_CODE);
            }
        });
    }
}
