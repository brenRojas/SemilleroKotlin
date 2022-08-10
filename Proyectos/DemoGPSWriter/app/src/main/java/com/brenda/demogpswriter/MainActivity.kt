package com.brenda.demogpswriter

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.brenda.demogpswriter.databinding.ActivityMainBinding
import com.brenda.demogpswriter.extensions.toast
import com.brenda.demogpswriter.models.Vehiculo
import com.brenda.demogpswriter.provider.RealtimeProvider
import com.google.android.gms.location.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var locationPermissionRequest: ActivityResultLauncher<Array<String>>
    private lateinit var fusedLocationCliente : FusedLocationProviderClient
    private lateinit var locationCallback : LocationCallback
    private lateinit var lr : LocationRequest
    private var gpsIniciado = false
    lateinit var mDatabase:RealtimeProvider


    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase = RealtimeProvider()

        locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                    activarGps()
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    // Only approximate location access granted.
                } else -> {
                //toast("Permiso denegado")
            }
            }
        }

        resultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(gpsEncendido()){
                toast("Gps Listo")
                solicitarPermisos()
            }
            else{
                toast("Necesario para poder utilizar la app")
            }
        }


        //Ubicacion en tiempo real periódicamente
        lr = creationLocationRequest()

        locationCallback = object : LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                for(location in locationResult.locations){
                    actualizarMarcador(location.latitude, location.longitude)
                }
            }
        }

        if(gpsEncendido()){
            solicitarPermisos()
        }else{
            //toast("El gps esta apagado")
            abrirVentanaActivarGps()
        }


    }

    fun solicitarPermisos(){
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            activarGps()
            return
        }
        when {
            ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                //se ejecuta cuando el permiso ha sido concedido
                activarGps()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                //Este se ejecuta cuando el usuario rechazó el permiso con anterioridad
                //toast("Activa los permisos en los ajustes")
            }
            else -> {
                //Este se ejecuta cuando es primera vez
                locationPermissionRequest.launch(arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION))
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun activarGps(){
        fusedLocationCliente = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationCliente.lastLocation.addOnSuccessListener {
            if(it != null){
                actualizarMarcador(it.latitude, it.longitude)
            }

        }
        Toast.makeText(applicationContext, "GPS activado", Toast.LENGTH_SHORT).show()
        gpsIniciado = true
        startLocationUpdates()
    }

    private fun actualizarMarcador(latitud:Double, longitud:Double) {
        binding.txtLatitud.text = latitud.toString()
        binding.txtLongitud.text = longitud.toString()

        val v = Vehiculo().apply {
            placa = "ASDFGH"
            this.latitud = latitud
            this.longitud = longitud
        }
        mDatabase.insertarVehiculo(v)
    }


    private fun creationLocationRequest() : LocationRequest{
        var locationRequest = LocationRequest.create()?.apply {
            interval        = 200
            fastestInterval = 1000
            priority        = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        return locationRequest!!
    }

    override fun onResume() {
        super.onResume()
        if(gpsIniciado){
            stopLocationUpdate()
        }
    }

    private fun stopLocationUpdate() {
        fusedLocationCliente.removeLocationUpdates(locationCallback)
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        fusedLocationCliente.requestLocationUpdates(lr, locationCallback, null)
    }

    fun gpsEncendido():Boolean{
        var manager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun abrirVentanaActivarGps(){
        var alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle("Activar GPS")
                setMessage("Es necesario que el gps este activado")
                setPositiveButton("Aceptar",
                    DialogInterface.OnClickListener { dialog, id ->
                        val intent= Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                        resultLauncher.launch(intent)
                    }
                )
                setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    }
                )
            }
            builder.create()
        }
        alertDialog.show()
    }
}