package com.example.digitallibary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button aboutAuthor;
    Button selectFile;
    Button aboutProgram;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dbHandler = new DBHandler(this);

        dbHandler.addNewCourse("Имя", "Размер", "Описание", "Трек");
        dbHandler.addNewCourse("Имя", "Размер", "Описание", "Трек");
        dbHandler.addNewCourse("Имя", "Размер", "Описание", "Трек");
        setupUI();
    }
    private void setupUI() {
        aboutAuthor = findViewById(R.id.aboutAuthor);
        aboutProgram = findViewById(R.id.aboutProgram);
        selectFile = findViewById(R.id.selectFile);
        selectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ViewCourses.class);
                startActivity(intent);
            }
        });
    }

    public void toAboutAuthor(View v) {
        Intent integer = new Intent(this, AboutAuthorActivity.class);
        startActivity(integer);
    }

    public void toAboutProgram(View v) {
        Intent integer = new Intent(this, AboutProgramActivity.class);
        startActivity(integer);
    }
}

