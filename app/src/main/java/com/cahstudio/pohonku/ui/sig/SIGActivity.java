package com.cahstudio.pohonku.ui.sig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cahstudio.pohonku.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

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

                LatLng indonesiaCoordinat = new LatLng(2.2059154,109.4387386);
                LatLngBounds indonesia = new LatLngBounds(indonesiaCoordinat, indonesiaCoordinat);
                mapIndonesia.moveCamera(CameraUpdateFactory.newLatLngZoom(
                        indonesiaCoordinat, 3));
//                mapIndonesia.setLatLngBoundsForCameraTarget(indonesia);
//                mapIndonesia.animateCamera(CameraUpdateFactory.newLatLngZoom(indonesiaCoordinat, 3.0f));
            }
        });

        SupportMapFragment mapFragmentMlg = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapsMalang);
        mapFragmentMlg.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mapMalang = googleMap;

                LatLng malangCoordinat = new LatLng(-7.964013, 112.633841);
                LatLngBounds malang = new LatLngBounds(malangCoordinat, malangCoordinat);
                mapMalang.moveCamera(CameraUpdateFactory.newLatLngZoom(
                        malangCoordinat, 11));
//                mapMalang.setLatLngBoundsForCameraTarget(malang);
//                mapMalang.animateCamera(CameraUpdateFactory.newLatLngZoom(malangCoordinat, 10.0f));
            }
        });
    }
}