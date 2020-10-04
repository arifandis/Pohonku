package com.cahstudio.pohonku.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cahstudio.pohonku.R;
import com.cahstudio.pohonku.ui.landing.LandingActivity;
import com.cahstudio.pohonku.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton btnLogin;
    private AppCompatTextView btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
    }

    void initialize(){
        btnLogin = findViewById(R.id.btnLogin);
        btnRegis = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(this);
        btnRegis.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                startActivity(new Intent(this, LandingActivity.class));
                finish();
                break;
            case R.id.tvRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}