package com.cahstudio.pohonku.ui.gli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.view.View;

import com.cahstudio.pohonku.R;

public class GLIActivity extends AppCompatActivity {

    private AppCompatImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_l_i);

        btnBack = findViewById(R.id.appCompatImageButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}