package com.cahstudio.pohonku.ui.addtree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cahstudio.pohonku.R;
import com.cahstudio.pohonku.ui.detailtree.DetailTreeActivity;
import com.google.android.material.button.MaterialButton;

public class AddTreeActivity extends AppCompatActivity {
    private MaterialButton btnAd;
    private AppCompatImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tree);

        btnAd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.appCompatImageButton);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), DetailTreeActivity.class));
                finish();
            }
        });
    }
}