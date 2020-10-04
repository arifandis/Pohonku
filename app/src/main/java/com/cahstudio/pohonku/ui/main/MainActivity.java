package com.cahstudio.pohonku.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cahstudio.pohonku.R;
import com.cahstudio.pohonku.ui.detailtree.DetailTreeActivity;
import com.cahstudio.pohonku.ui.gli.GLIActivity;
import com.cahstudio.pohonku.ui.reader.NFCReaderActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private CardView cardView, cvScan, cvGLI, cvSIG;
    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = findViewById(R.id.cardView2);
        cvScan = findViewById(R.id.cvScan);
        cvGLI = findViewById(R.id.cvGLI);
        cvSIG = findViewById(R.id.cvSIG);
        btnAdd = findViewById(R.id.floatingActionButton);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailTreeActivity.class));
            }
        });

        cvScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NFCReaderActivity.class);
                intent.putExtra("from", "read");
                startActivity(intent);
            }
        });

        cvGLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GLIActivity.class));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NFCReaderActivity.class);
                intent.putExtra("from", "add");
                startActivity(intent);
            }
        });
    }
}