package com.example.jeffalmeida.mapviewwithcorners;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

//    MapView mapView;

    CustomMap customMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);


        customMap = (CustomMap) findViewById(R.id.mapview);
        MapsInitializer.initialize(this);
        customMap.onCreate(savedInstanceState);

        customMap.getMapAsync(this);

//        mapView = (MapView) findViewById(R.id.mapview);
//        MapsInitializer.initialize(this);
//        mapView.onCreate(savedInstanceState);
//
//        mapView.getMapAsync(this);

    }

    @Override
    protected void onResume() {
//        mapView.onResume();
        customMap.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
//        mapView.onPause();
        customMap.onPause();
        super.onPause();
    }

    @Override
    public void onLowMemory() {
//        mapView.onLowMemory();
        customMap.onLowMemory();
        super.onLowMemory();
    }

    @Override
    protected void onDestroy() {
//        mapView.onDestroy();
        customMap.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        mapView.onSaveInstanceState(outState);

        customMap.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
