package br.com.local.appgooglemapsformas;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        final LatLng parquedoCarmo = new LatLng(-23.570749, -46.4764926);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Double latitude, longitude;

                latitude = latLng.latitude;
                longitude = latLng.longitude;

              Toast.makeText(getApplicationContext(),
                        "Latitude: " + latitude + "\n" +
                                "Longitude: " + longitude,
                        Toast.LENGTH_SHORT).show();
            }
        });
        mMap.addMarker(
                new MarkerOptions()
                        .position(parquedoCarmo)
                        .title("Jardim Nossa Sra. do Carmo\n" +
                                "São Paulo - SP")
                        .icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.park)
                        )

        );
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(parquedoCarmo, 13));
    }
}