package com.brenda.demogpswriter.ui

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.brenda.demogpswriter.R
import com.brenda.demogpswriter.databinding.ActivitySeguimientoBinding
import com.brenda.demogpswriter.provider.RealtimeProvider

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.jar.Manifest


class SeguimientoActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var marcadorVehiculo: Marker
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivitySeguimientoBinding
    private lateinit var mDatabase : RealtimeProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeguimientoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase = RealtimeProvider()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        marcadorVehiculo = mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))!!
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.uiSettings.isZoomControlsEnabled = true
        mostrarUbicacionActual()

        var referencia = mDatabase.obtenerReferencia()
        referencia.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    if(snapshot.childrenCount > 0){
                        var lat = snapshot.child("latitud").getValue(Double::class.java)!!
                        var lng = snapshot.child("longitud").getValue(Double::class.java)!!
                        actualizarMarcador(lat, lng)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //TODO("Not yet implemented")
            }

        })
    }

    private fun actualizarMarcador(latitud:Double, longitud:Double){
        var coords = LatLng(latitud, longitud)
        marcadorVehiculo.position = coords
        marcadorVehiculo.title = "Marcador: $latitud, $longitud"
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coords))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f))
    }

    @SuppressLint("MissingPermission")
    private fun mostrarUbicacionActual(){
        mMap.isMyLocationEnabled = true
    }

}