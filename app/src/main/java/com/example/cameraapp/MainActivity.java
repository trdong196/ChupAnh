package com.example.cameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCamera;
    ImageView imgPhoto;
    protected void innitControl(){
        btnCamera = findViewById(R.id.btnCamera);
        imgPhoto = findViewById(R.id.imgPhoto);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data){
        if(requestCode == 100 && resultCode == RESULT_OK && (data != null)){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(bitmap);
    }
    super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        innitControl();
    }
}