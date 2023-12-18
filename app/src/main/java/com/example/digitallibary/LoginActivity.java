package com.example.digitallibary;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setupListeners();
    }

    private void setupUI() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
    }

    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    void checkUsername() {
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("Вы должны ввести логин для регистрации");
            isValid = false;
        } else {
            if (!isEmail(username)) {
                username.setError("Вы должны ввести почту для регистрации");
                isValid = false;
            }
        }

        if (isEmpty(password)) {
            password.setError("Вы должны ввести пароль для логина");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Пароль должен быть длинее 4 символов");
                isValid = false;
            }
        }

        //check email and password
        //IMPORTANT: here should be call to backend or safer function for local check; For example simple check is cool
        //For example simple check is cool
        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            if (usernameValue.equals("test@test.com") && passwordValue.equals("password1234")) {
                //everything checked we open new activity
                Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(i);
            } else {
                Toast t = Toast.makeText(this, "Неправильная почта или пароль!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public void b_exitClick(View view) {
        System.exit(0);
    }
}

