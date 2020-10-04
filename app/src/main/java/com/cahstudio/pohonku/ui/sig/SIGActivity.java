package com.cahstudio.pohonku.ui.sig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cahstudio.pohonku.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class SIGActivity extends AppCompatActivity {

    private GoogleMap mapIndonesia, mapMalang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_i_g);

        SupportMapFragment mapFragmentIndo = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapsIndonesia);
        mapFragmentIndo.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mapIndonesia = googleMap;

                LatLng indonesia = new LatLng(2.2059154,109.4387386);
                mapIndonesia.moveCamera(CameraUpdateFactory.newLatLng(indonesia));
                mapIndonesia.moveCamera(CameraUpdateFactory.zoomBy(4));
            }
        });

        SupportMapFragment mapFragmentMlg = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapsMalang);
        mapFragmentMlg.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

            }
        });
    }
}