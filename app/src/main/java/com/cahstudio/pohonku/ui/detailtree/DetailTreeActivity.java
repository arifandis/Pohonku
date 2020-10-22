package com.cahstudio.pohonku.ui.detailtree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.view.View;

import com.cahstudio.pohonku.R;

public class DetailTreeActivity extends AppCompatActivity {
    private AppCompatImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tree);

        btnBack = findViewById(R.id.appCompatImageButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}