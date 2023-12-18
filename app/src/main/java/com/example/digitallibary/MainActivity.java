package com.example.digitallibary;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText loginReg;
    EditText passwordReg;
    EditText email;
    Button register;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginReg = findViewById(R.id.loginReg);
        passwordReg = findViewById(R.id.passwordReg);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(loginReg)) {
            Toast t = Toast.makeText(this, "Вы должны ввести имя для регистрации", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(passwordReg)) {
            passwordReg.setError("Вы должны ввести пароль для регистрации");
        }

        if (isEmail(email) == false) {
            email.setError("Вы должны ввсти почту для регистрации");
        }

    }
    public void b_exitClick(View view) {
        System.exit(0);
    }
}


